#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json
from zato.server.service import Service

class GetInternshipDetails(Service):
    def handle(self):
        try:
            self.logger.info('Request: {}'.format(self.request.payload))
            with self.outgoing.soap.get('getInternshipWebService1').conn.client() as client:
                compagny=json.loads(self.request.payload)["selectCompany"]
                category= json.loads(self.request.payload)["selectCategory"]
                keywords=json.loads(self.request.payload)["keywords"]
                self.logger.info("********* " + compagny + "  "+ category +"  " +keywords)
                listOfInternship=client.service.getInternshipByCriteria(compagny,category,keywords)
                self.logger.info("================ result : " + str (listOfInternship) + "  "+str(type(listOfInternship)))
                #let's build the final response 
                finalResponse = {}
                for ind, internship in enumerate(listOfInternship):
                    finalResponse[str(ind)]=str(internship)
                #    self.logger.info("+++type of internship " + str(ind )+"  "+ str(type(internship)))

                #return response to the caller
                self.response.payload="\""+str(finalResponse)+"\""
                
        except Exception as e:
            self.logger.info("++++++++++++++++ ERROR  : " +str(e))
		
