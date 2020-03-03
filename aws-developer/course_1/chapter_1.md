# Notes on chapter 1

## Hands-On exercise

Exercise has two major parts.

In the first part, we'll create a new network for our virtual servers in VPC, 
Using a bit of automation called a CloudFormation template.
This network will have both public and private subnets.

We'll also launch an EC2 instance into one of the public subnets within the VPC.

In the second half of the exercise, we'll connect to the EC2 instance using SSH.
Once connected, we'll query some properties about the instance from the EC2 metadata service.
check out things like 
the availability zone,
the region in which our instance is deployed
and networking configuration from within the instance itself.
We can also check some logs from the server which can help us debug our user data scripts.

chmod 400 PATH-TO-PEM-FILE

ssh -i PATH-TO-PEM-FILE ec2-user@PUBLIC-IP

cloud-init logs to verify the steps in the UserData script executed on the Amazon EC2 Instance.

cat /var/log/cloud-init-output.log

Explore the log file to see the log entries generated for installing the user data script.
To view the instance metadata, type the command below: \
curl http://169.254.169.254/latest/meta-data/

Execute the command below to get the instance identity document of your instance: \
curl http://169.254.169.254/latest/dynamic/instance-identity/document

Execute the command below to get the instance public IP address: \
curl http://169.254.169.254/latest/meta-data/public-ipv4

Execute the command below to get the MAC address of the instance: \
curl http://169.254.169.254/latest/meta-data/mac

Execute the command below to get the VPC ID in which the instance resides. Make sure to replace Your-MAC in the command below with the MAC address of your instance: \
curl http://169.254.169.254/latest/meta-data/network/interfaces/macs/Your-MAC/vpc-id

Execute the command below to get the subnet-id in which the instance resides. Make sure to replace Your-MAC in the command below with the MAC address of your instance: \ 
curl http://169.254.169.254/latest/meta-data/network/interfaces/macs/Your-MAC/subnet-id

Execute the command below to get the instance user data: \
curl http://169.254.169.254/latest/user-data

To get programmatic access to aws api using user configure AWS CLI with the access keys of the AWS IAM user.

aws configure

Follow the prompts on the screen and paste in the values for Access Key Id and Secret Access Key.

For Region, type us-west-2.

For Default output format, press ENTER.

You have now configured the AWS CLI so that any CLI calls will operate with the credentials of the AWS IAM user.

### Simple Storage Service

S3 allows us to set access control via three methods:
1. Bucket Policies, 
2. IAM for users and groups and
3. Access Control Lists.

