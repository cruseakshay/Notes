# Practice questions for AWS-SAA

- What is the key difference between a NAT gateway and a NAT instance?

  A NAT gateway is managed (and automatically scaled when necessary) by AWS, while a NAT instance is a normal EC2 instance you launch using an AWS AMI.

- Which AWS service can help you visualize all the resources currently deployed in your account, their event histories, and how their configurations have changed over time?

  AWS Config

- You can protect RDS database availability from outages by creating full standby instances in a second availability zone using ________.

  multi-AZ deployment.

- The best protection against a region-wide service failure of S3 infrastructure is ________.

  Cross-region replication
  
- What are the three possible states of a CloudWatch alarm?

  ALARM, OK, and INSUFFICIENT_DATA

- True/False: EC2 instances and S3 buckets are the only origins you can use for CloudFront distributions.

  False

- What is the most efficient way to organize an account's multiple IAM users to minimize administration overhead?

  Create IAM groups
  
- EC2 instances connect to the Internet (via their elastic network interfaces) through an ________.

  Internet gateway

- What must you do to configure a NAT instance after creating it?

  The source/destination check on the NAT instance's ENI must be disabled to allow the instance to receive traffic not destined for its   IP and to send traffic using a source address that it doesn't own. The NAT instance's default route must point to an Internet gateway   as the target.

- Which CloudWatch resource type stores log events?

  log stream

- Which storage engine should you use with MySQL, Aurora, and MariaDB for maximum compatibility with RDS?

  InnoDB is the only storage engine Amazon recommends for MySQL and MariaDB deployments in RDS and the only engine Aurora supports.
  
- What do you have to do to securely authenticate to the GUI console of a Windows EC2 session?

  The client computer in an encrypted operation must always provide the private key to authenticate. For EC2 instances running Windows,   you retrieve the password you'll use for the GUI login using your private key.
  
- You have a VMware virtual machine in your local infrastructure that you'd like to copy to your AWS account and run as an EC2 instance.   Which of the following will be necessary steps?

  Import the virtual machine using VM Import/Export. Select the imported VM from among your private AMIs and launch an instance
  
- You want a CloudWatch alarm to change state when four consecutive evaluation periods elapse with no data. How should you configure the   alarm to treat missing data?

  To have CloudWatch treat missing data as exceeding the threshold, set the Treat Missing Data As option to Breaching.

- Which of the following content types is the best fit for a Real-Time Messaging Protocol (RTMP) distribution?

  A. Amazon Elastic Transcoder–based videos
  B. S3-based videos
  C. Streaming videos
  D. A mix of text and media-rich digital content

  RTMP distributions can only manage content from S3 buckets. RTMP is intended for the distribution of video content.
  
- what is the difference in durability between S3’s S3 One Zone-IA and Reduced Redundancy classes?

  One Zone-IA is heavily replicated but only within a single availability zone, while reduced redundancy is only lightly replicated.
  
- How many database engines can an RDS database instance run?

  Although there are six database engines to choose from, a single database instance can run only one database engine. If you want to     run more than one database engine, you will need a separate database instance for each engine.
  
- You have a publicly available file called filename stored in an S3 bucket named bucketname. Which of the following addresses will       successfully retrieve the file using a web browser?

  HTTP (web) requests must address the s3.amazon.aws.com domain along with the bucket and filenames.                                       https://s3.amazonaws.com/bucketname/filename
  
- If a MariaDB database running in RDS needs to write 200 MB of data every second, how many IOPS should you provision using io1 storage   to sustain this performance?

  MariaDB has a page size of 16 KB. To write 200 MB (204,800 KB) of data every second, it would need 12,800 IOPS. Oracle, PostgreSQL, or Microsoft SQL Server, which all use an 8 KB page size, would need 25,600 IOPS to achieve the same throughput.
  
- AWS is responsible for managing the network configuration of your EC2 instances.

  Customers are responsible for managing the network configuration of EC2 instances. AWS is responsible for the physical network           infrastructure.
  
- You've configured CloudTrail to log all management events in all regions. Which of the following API events will CloudTrail log? 

  Creating a bucket and subnet are API actions, regardless of whether they're performed from the web console or AWS CLI.

- What is the function of Amazon Cognito user pools?

  User pools provide sign-up and sign-in for your application's users. Temporary access to defined AWS services to your application       users is provided by identity pools. 
  
- You want to use Route 53 to send users to the application load balancer closest to them. Which routing policies lets you do this with   the least effort?

  Geoproximity routing routes users to the location closest to them.

- What is the range of allowed IPv4 prefix lengths for a VPC CIDR block?

  The allowed range of prefix lengths for a VPC CIDR is between /16 and /28 inclusive. The maximum possible prefix length for an IP       subnet is /32.

- Which service would you use to most effectively reduce the latency your end users experience when accessing your application resources   over the Internet?

  CloudFront maintains a network of endpoints where cached versions of your application data are stored to provide quicker responses to   user requests.
  
- Which actions will you need to perform to transfer a domain from an external registrar to Route 53?

  To transfer a domain, you'll need to make sure the domain isn't set to locked and an authorization code that you'll provide to Route     53.

- Which ElastiCache engine can persistently store data?

  ElastiCache supports Memcached and Redis, but only the latter can store data persistently.

- Enabling point-in-time RDS snapshots is sufficient to give you a recovery point objective (RPO) of less than 10 minutes.

  True
  
- What is the destination for a default IPv4 route?

  The destination 0.0.0.0/0 matches all IP prefixes and hence covers all publicly accessible hosts on the Internet.
  
- What uniquely distinguishes two CloudWatch metrics that have the same name and are in the same namespace?

  CloudWatch uses dimensions to uniquely identify metrics with the same name and namespace. 
  
- You learn that an instance in the us-west-1 region was deleted at some point in the past. To find out who deleted the instance and       when, which of the following must be true?

  If CloudTrail were logging write-only management events in the same region as the instance, it would have generated trail logs           containing the deletion event.
  
- an example of a top-level domain (TLD)?
  The rightmost section of an FQDN address is the TLD like *.com .
  
- Which services can alert you to malware on an EC2 instance?

  GuardDuty looks for potentially malicious activity.
  
- Which VPC resource performs network address translation?

  An Internet gateway performs NAT for instances that have a public IP address.
  
- What must every relational database table contain?

  A table must contain at least one attribute or column. 
  
- Which AWS tools will allow you to locate EC2 instances closer to each other to reduce network latency?

  Placement groups.

- The EBS Lifecycle Manager can take snapshots of volumes that were once attached to terminated instances.

  The EBS Lifecycle Manager can take scheduled snapshots of any EBS volume, regardless of attachment state.
  
- EC2 Auto Scaling automatically replaces group instances directly terminated by the root user.
  
  True
  
- In a CloudWatch alarm, what does the EC2 recover action do to the monitored instance?

  The recover action is useful when there's a problem with an instance that requires AWS involvement to repair, such as a hardware         failure. The recover action migrates the same instance to a new host.
  
- S3 cross-region replication uses transfer acceleration.

  False; Explanation: S3 cross-region replication transfers objects between different buckets. Transfer acceleration uses a CloudFront     edge location to speed up transfers between S3 and the Internet.
  
- Where do AWS Config and CloudTrail store their logs?

  Both store their logs in S3 buckets.
  
- What is a difference between a token generated by the AWS Security Token Service (STS) and an IAM access key?

  STS tokens expire while IAM access keys do not. An STS token can be used more than once. IAM access keys and STS tokens are both         unique. An IAM principal can use an STS token. 
  
- What is the relationship between a subnet and an availability zone?

  Multiple subnets may exist in a single availability zone. A subnet cannot span availability zones.

- What is a public subnet ?

  The definition of a public subnet is a subnet that has a default route pointing to an Internet gateway as a target. Otherwise, it's a   private subnet.

- Which AWS tool lets you organize your EC2 instances and configure their network connectivity and access control?

  VPCs are virtualized network environments where you can control the connectivity of your EC2 (and RDS, etc.) infrastructure.
  
- What does the term availability zone refer to in AWS documentation?

  An availability zone is an isolated physical data center within an AWS region. Regions are geographic areas that contain multiple       availability zones.
  
- 
