#!/usr/bin/python

import sys
import logging
import os
import fileinput
import subprocess
import time

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

def start_node_manager():
	try:
		log_file = open("<Path>/user_projects/domains/base_domain/bin/NM_start.log", "w+")
		read_file = open("<Path>/user_projects/domains/base_domain/bin/NM_start.log", "r")
		process = subprocess.Popen(['sh','<Path>/user_projects/domains/base_domain/bin/startNodeManager.sh'], stdout= log_file , stderr=log_file)

		status=0
		i=0
		while  (status < 1):

			print "Waiting for Nodemanager to start"
			time.sleep(30)
			content = read_file.read()
			if "<INFO> <Secure socket listener started on port" in content:
				status += 1
	
			i += 1
			if  i > 10:
				print "ERROR:Nodemanager did not start in maximum wait time. Exiting"
				quit()
		
		print "Node Manager started"
		log_file.close()
		read_file.close()
				
	except:
		print "Node Manager startup failed. Process will be terminated"
		e = sys.exc_info()[0]
		logger.error(str(e))
		raise

start_node_manager()
