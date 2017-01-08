#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os
from zato.server.service import Service

class GetInternshipDetails(Service):
    def handle(self):
    	try:
    		self.logger.info('Request: {}'.format(self.request.payload))
    		with self.outgoing.soap.get('getInternshipFirstWebservice').conn.client() as client:
                jsonRequestInfo= json.loads(self.request.payload)
                compagny=jsonRequestInfo["selectCompany"]
                category= jsonRequestInfo["selectCategory"]
                keywords=jsonRequestInfo["keywords"]

    			listOfInternship=client.service.getInternshipByCriteria(compagny,category,keywords)
    			self.logger.info("================ result : " + str (listOfInternship))

    			#let's build the final response 
    			finalResponse = {}
    			for ind, internship in enumerate(listOfInternship):
    				finalResponse[str(ind)]=internship 
    			
    			self.response.payload=finalResponse
    	except Exception as e:
    		self.logger.info("++++++++++++++++ ERROR  : " +str(e))
		
