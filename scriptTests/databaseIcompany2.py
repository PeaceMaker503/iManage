#!/usr/bin/env python
# -*- coding: utf-8 -*-


import pymysql

listTables = ['Internship',  'Category']



class databaseManager:

	def __init__(self,dbName):
		self.conn = pymysql.connect(host="localhost",user="root",password="mamaya", database=dbName)
		self.cursor = self.conn.cursor()
	

	def emptyDatase(self):
		try:
			for table in listTables:
				self.cursor.execute(""" delete from %s; """ % (table))
				self.conn.commit()
		except Exception as e:
			print str(e)
			self.conn.rollback()

	
	def addListOfInterships(self,listOfinternships):
		try:
			for internship in listOfinternships:
				self.cursor.execute(""" INSERT INTO Internship (name, pdfPath, description,id_category_id) VALUES ('%s','%s', '%s', '%s'); """ 
									% (internship[0],internship[1],internship[2],str(internship[3])))
			self.conn.commit()
		except Exception as e:
			print str(e)
			self.conn.rollback()

	def addCategories(self,listOfCategories):
		try:
			for cat in listOfCategories:
				self.cursor.execute(""" INSERT INTO Category (name) VALUES ('%s'); """ 
									% (cat))
			self.conn.commit()
		except Exception as e:
			print str(e)
			self.conn.rollback()

	def getCategoryId(self,name):
		try: 
			self.cursor.execute("""SELECT id FROM Category WHERE name ='%s' """ % (name))
			result = self.cursor.fetchone()
			if result is not None:
				return result[0]
			else:
				return -1#si erreur 
		except Exception as e:
			print str(e)
			return -1#si erreur



if __name__ == '__main__':
	d1= databaseManager("entrepriseb")
	d1.emptyDatase()

	#add some categories
	listOfCategories=["informatique","biologie","genie civil"]
	d1.addCategories(listOfCategories)
	idInfo= d1.getCategoryId("informatique")
	idBio =  d1.getCategoryId("biologie")
	idGC=d1.getCategoryId("genie civil")
	#add some internships 
	listOfinternships = [
						(
							"Stage - Consultant BI/Datastage",
							"/home/appCritique.pdf/20/21",
							"Vous interviendrez sur un projet en phase devolution dedie a la mise en place dun systeme permettant \
							levolution pour notre client de ses besoins dimmobilisation en fonds propes",
							idInfo),
						(
							"Stage - Consultant Cyberdefense",
							"/home/webServiveces/32/33",
							"Participer au developpement de solutions de Kill Chain en Cyberdefense. Soutenu par ds systemes toujous plus \
							ouvertes, le numerique est une source de menaes toujours plus nombreuses.",
							idInfo), 
						(
							"Stage - Ingenieru dEtudes et Developpement WEB en Espagne",
							"/home/compilateur.pdf/14/15",
							"Participer a une mission doutsourcing applicatif dans le secteur energie en espagne. Notre client est le \
							principal distributeur de gaz naturel en France.",
							idInfo),
						(
							'Amelioration biologie moleculaire',
							"/home/enzyme.pdf",
							"amelioration de l enzyme de digestion",
							idBio), 
						(
							'Construction pont Rangueil',
							"/home/pont.pdf",
							"il faut le construire ce pont",
							idGC),
						(
							'Amelioration rotation des travailleurs sur un chantier',
							"/home/chantier.pdf",
							"amelioration d un chantier",idGC)
						]
	d1.addListOfInterships(listOfinternships)