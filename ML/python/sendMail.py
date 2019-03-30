import os
import commands
import socket
import smtplib
import subprocess

def send_mail():
  hostname = os.popen('hostname').read().rstrip() # get host name from SYS.
  SERVER = "localhost"
  from = "MAIL_ID@domail.com"
  to = ['LIST_MAIL_IDS']
  sub = "Alert for: " + hostname + " !"
  body = "DETAILS OF THE EVENT..."
  
  msg = "From: " + from + " \n" + "To: " + to + " \n" + "Subject: " + sub + " \n\n" + body
  
  #use smtplib to send mail
  server = smtplib.SMTP(SERVER)
  server.sendmail(from, to, msg)
  server.quit()
  
# Based on server events call sem_mail()
send_mail()
