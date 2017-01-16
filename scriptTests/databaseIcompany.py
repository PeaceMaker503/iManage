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
	d1= databaseManager("entreprisea")
	d1.emptyDatase()

	#add some categories
	listOfCategories=["informatique","biologie"]
	d1.addCategories(listOfCategories)
	idInfo= d1.getCategoryId("informatique")
	idBio =  d1.getCategoryId("biologie")
	#add some internships 
	listOfinternships = [("prototype projet qui ne sert a rien et qui va mal ","/home/appCritique.pdf","entreprise a taille humaine cherche petit stagiaire",idInfo),\
						("developpement Amazon web services de la mort","/home/webServiveces","expert SOA qui doit travailler dur",idInfo),\
						("developpement Objet connecte","/home/iot.pdf","prototype toilettes connectees",idInfo),\
						('amelioration process enzyme de la life qui tue',"/home/enzyme.pdf","amelioration process developpement enzyme de la life",idBio)]
	d1.addListOfInterships(listOfinternships)