#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json
from zato.server.service import Service

class GetInternshipDetails(Service):
    def handle(self):
        try:
            self.logger.info('Request: {}'.format(self.request.payload))

            with self.outgoing.soap.get('getInternshipWebService1').conn.client() as companyA:
            	with self.outgoing.soap.get('getInternshipWebService2').conn.client() as companyB:
	                company=self.request.payload["selectCompany"]
	                category=self.request.payload["selectCategory"]
	                keywords=self.request.payload["keywords"]

	                self.logger.info("********* company : " + company +" category :"+ category + " keywords :" + keywords)
	                #permet de savoir si on a envoyé une requête à l'entreprise A 
	                RequestedEntrepriseA=0
	                
	                ListInternshipCompA=[]
	                if company=="entreprisea" or company=="All":
	                	ListInternshipCompA=companyA.service.getInternshipByCriteria(category,keywords)
	                	self.logger.info("================ result company A : " + str (ListInternshipCompA) + "  "+str(type(ListInternshipCompA)))
	                	RequestedEntrepriseA=len(ListInternshipCompA)

	                ListInternshipCompB=[]
	                if company=="entrepriseb" or company=="All":
	                	ListInternshipCompB=companyB.service.getInternshipByCriteria(category,keywords)
	                	self.logger.info("================ result company B : " + str (ListInternshipCompB) + "  "+str(type(ListInternshipCompB)))


	                # #let's build the final response 
	                finalResponse = {}
	                for ind, internship in enumerate(ListInternshipCompA):
	                    finalResponse[str(ind)]={"description":str(internship.description),"elementId":str(internship.id),\
	                    "category_id":str(internship.id_category.id),"category_name":str(internship.id_category.name),\
	                    "name":str(internship.name),"pdfPath":str(internship.pdfPath)} 
	                    #self.logger.info("////////////////////type of internship " + str(internship.id_category.name))

	                for ind, internship in enumerate(ListInternshipCompB):
	                    finalResponse[str(ind+RequestedEntrepriseA)]={"description":str(internship.description),"elementId":str(internship.id),\
	                    "category_id":str(internship.id_category.id),"category_name":str(internship.id_category.name),\
	                    "name":str(internship.name),"pdfPath":str(internship.pdfPath)} 
	                
	                ##return response to the caller
	                self.response.payload="\""+str(finalResponse)+"\""
                
        except Exception as e:
            self.logger.info("++++++++++++++++ ERROR  : " +str(e))
		
