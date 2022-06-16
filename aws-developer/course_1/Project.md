# Hands On Project

The course project is a simple web application in which users log in to their accounts and upload photos to an Amazon S3 bucket, process the photos with Amazon Rekognition to generate labels and then store the photos along with their labels and description in an Amazon RDS database.

The application is deployed on an Amazon EC2 instance with an Application Load Balancer sitting in front of the instance to direct user requests to the instance. Amazon Cognito is used to sign up/sign in users for the application. In order to asynchronously process the photo labels, when a photo is uploaded, an Amazon S3 bucket event notification is issued to an Amazon SNS topic. This triggers a subscribed AWS Lambda function, which talks to Amazon Rekognition. To make the application more distributed, an Amazon SQS queue subscribed to the Amazon SNS topic stores all the incoming requests and an on-premises application polls the queue for processing. AWS X-Ray traces the calls made to all the AWS resources in this application, thereby providing diagnostics information.

## Launch an AWS CloudFormation template to create VPC and subnets.
create a VPC and subnets by launching an AWS CloudFormation template.

Region: Oregon (us-west-2) <br>
CloudFormation template: [VPC Template](vpc.template) <br>
Name of the stack: edx-vpc-stack

Write down the vpc-id of the edx-build-aws-vpc. <br>
You will see four subnets starting with edx-subnet-xxxx. Write down the subnet-id of edx-subnet-public-a.

## Create an Amazon S3 bucket to store the application photos.

Region: Oregon (us-west-2) <br>
Bucket name: Type a unique bucket name to store photos and make a note of it for later use.

## Create an Amazon S3 bucket for storing the deployment artifacts.

```
Region: Oregon (us-west-2)
Bucket name: Type a unique bucket name and make a note of it for later use.
```

## Create an Amazon RDS database instance.

Region: Oregon (us-west-2)
Amazon RDS Instance type: MySQL (free tier eligible)
Name of DB instance: edx-photos-db
Master username: master
Master user password: Type a master user password and write it down for later use.
VPC: edx-build-aws-vpc
Database name: Photos

Important: Make a note of the database endpoint.

**Modify the security group of the Amazon RDS database.**

- On the Amazon RDS database instance page, scroll down to the Details section.
- Under Security and network, click the security group. The security group should have a name like rds-launch-wizard-xxx. A new page displaying the security group you just clicked should open.
- Make a note of the security group ID. You will need it in subsequent exercises.
- Inbound > Edit
- Select the security group that contains your AWS Cloud9 environment name. > SAVE

The web_user is a restricted privilege user who has access solely to the photos table. The web application is configured to use the web_user and not the master user.

```
python3 exercise-rds/SetupScripts/database_create_tables.py
```

Database host: Paste the database endpoint you noted earlier.
Database user: master
Database password: Type the password for the master user.
Database name: Photos
web_user password: Type a password for the web_user. Make a note of the web_user password for later use.
You should see a message that a web_user is created with the required access granted to it.



## Create AWS Cloud9 environment for development.

Region: Oregon (us-west-2) <br>
Network settings (advanced)
- Network (VPC), choose the edx-build-aws-vpc id
- Subnet, choose the public subnet 
Create environment

AWS CLI is installed and pre-authneticated on cloud9 instance.
Install Boto 3 on AWS Cloud9 instance.
```bash
sudo pip-3.6 install boto3
```

**uploader component of the application**

```bash
cd ~/environment
wget https://us-west-2-tcdev.s3.amazonaws.com/courses/AWS-100-ADG/v1.1.0/exercises/ex-s3-upload.zip
unzip ex-s3-upload.zip
sudo pip-3.6 install -r exercise-s3-upload/FlaskApp/requirements.txt

```

- To run the application.py code:
  - Select exercise-s3-upload/FlaskApp/application.py in the tree view.
  - Run Configuration > click ENV
    - PHOTOS_BUCKET : name of the Amazon S3 bucket you created earlier.
    - FLASK_SECRET : type random characters and numbers. (The Flask app uses a secret value to encrypt session variables.)
    - DATABASE_HOST	Database endpoint you noted earlier
    - DATABASE_USER	web_user
    - DATABASE_PASSWORD	Password for the web_user you noted earlier
    - DATABASE_DB_NAME	Photos
  - Save the run configuration by typing a name(Python3RunConfiguration) for the configuration.
  - click Run -> Run With -> Python 3.
  - To test the application, click Preview -> Preview Running Application




  
**Create a security group in edx-build-aws-vpc network to allow web traffic to the Amazon EC2 instance acting as the web server.**
```
Security group name: web-server-sg
Region: Oregon (us-west-2)
VPC: edx-build-aws-vpc
Rules: Allow HTTP and SSH
```

**Modify the Amazon RDS database security group to allow traffic from the web server.**
- select the security group of the Amazon RDS database instance
- Inbound > Edit > Add Rule
- For Type, select MYSQL/Aurora.
- In the Source textbox, type web-server-sg. > Save


**Update the configuration files.**
The app.ini file contains the settings for the uwsgi server.The uwsgi server hosts the Python Flask application.the uwsgi server also needs to be configured with the database information.

DATABASE_HOST: Database endpoint you noted in previous exercise
DATABASE_USER: web_user
DATABASE_PASSWORD: Password for the web_user
DATABASE_DB_NAME: Photos
FLASK_SECRET:Type a new secret consisting of random letters and numbers.
PHOTOS_BUCKET:Copy and paste the PHOTOS_BUCKET value from the AWS Cloud9 environment variables list.

Save the app.ini file.

**Add deployment bucket name to Deploy/userdata.txt**

**Create the deployment .zip package with updated settings.**
```
cd exercise-rds
zip -r ~/deploy-app.zip Deploy/ FlaskApp/
aws s3 cp ~/deploy-app.zip s3://YOUR_BUCKET_NAME/
```

**Create an AWS IAM role to allow the user to download the deployment package.**
create an AWS IAM role to authenticate the EC2 instance to download the deployment artifacts stored in the Amazon S3 bucket. You will also authenticate the instance to communicate with Amazon Rekognition.
```
Trusted entity: Amazon EC2
Use case: Allows Amazon EC2 instances to call AWS services on your behalf
Permissions: AmazonS3FullAccess, AmazonRekognitionReadOnlyAccess
Role Name: ec2-webserver-role
```

```
Region: Oregon (us-west-2)
Amazon Machine Image (AMI): Amazon Linux AMI (Do not use the Amazon Linux 2 AMI)
Instance Type: t2.micro
Network: edx-build-aws-vpc
Subnet: edx-subnet-public-a in us-west-2a availability zone
IAM Role: ec2-webserver-role
User data script: Copy and paste the contents of the userdata.txt file from your AWS Cloud9 environment.
Tag: WebServer1
Security Group: web-server-sg
Key Pair: Use the key pair created in the third exercise.

Region: Oregon (us-west-2)
Amazon Machine Image (AMI): Amazon Linux AMI (Do not use the Amazon Linux 2 AMI)
Instance Type: t2.micro
Network: edx-build-aws-vpc
Subnet: edx-subnet-public-b in us-west-2b availability zone
IAM Role: ec2-webserver-role
User data script: Copy and paste the contents of the userdata.txt file from your AWS Cloud9 environment.
Tag: WebServer2
Security Group: web-server-sg
Key Pair: Use the key pair created in the third exercise.
```
**write down the IPv4 Public IP found in the Descriptions tab at the bottom.**

## Create and configure the Application Load Balancer.
- Amazon EC2 dashboard  > Load Balancers > Create Load Balancer > **Application Load Balancer**
- Name, type photos-alb
- default settings for Scheme and Listeners.
- Under Availability Zones, for VPC, select edx-build-aws-vpc. > select the two Availability Zones shown in the list.
- Select the public subnet in each availability zone by clicking the row of the public subnet.
- Next: Configure Security Settings. Skip
- Next: Configure Security Groups. > Assign a security group > Select an existing security group > web-server-sg (unselect default if any)
- Next: Configure Routing. > New target group.
  - For Name, type webserver-target.
  - Next: Register Targets.> Add WebServer1 and WebServer2.
- Review and Create

sudo yum -y install python36
sudo pip-3.6 install boto3

import boto3
client = boto3.client('ec2')
client.describe_instances()

### Logs
cloud-init-output.log
sudo cat /var/log/uwsgi.log
