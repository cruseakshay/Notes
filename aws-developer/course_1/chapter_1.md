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
