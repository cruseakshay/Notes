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
