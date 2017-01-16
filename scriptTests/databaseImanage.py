#!/usr/bin/env python
# -*- coding: utf-8 -*-


import pymysql

listTables = ['UserAccount', 'Internship', 'Company', 'Category', 'UserProfile']

#userAccount = {
#	'name':'user',
#	'password' : 'passwd',
#	'mail' : 'user@mail.com'
#}

userProfile = {
	'firstName':'fname',
	'lastName' : 'lname',
	'mail' : 'user2@mail.com',
	'phone' : '0494668842',
	'cvPath' : '/home/file.pdf'
}

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

	def addUserAccount(self,name,password,mail,userCategory,id_profile_id=None):
		try:
			if id_profile_id==None:
				self.cursor.execute(""" INSERT INTO UserAccount (login, password, mail,userCategory) VALUES ('%s', '%s', '%s','%s'); """ 
									% (name, password,mail,userCategory))
			else:
				self.cursor.execute(""" INSERT INTO UserAccount (login, password, mail,userCategory,id_profile_id) VALUES ('%s','%s' ,'%s', '%s','%s'); """ 
									% (name, password,mail,userCategory,id_profile_id))

			self.conn.commit()
		except Exception as e:
			print str(e)
			self.conn.rollback()

	def addUserProfile(self,firstName,lastName,mail,phone,cvPath):
		try:
			self.cursor.execute(""" INSERT INTO UserProfile (firstName, lastName, mail, phone, cvPath) VALUES ('%s', '%s', '%s', '%s', '%s'); """ 
								% (firstName,lastName,mail, phone, cvPath))
			self.conn.commit()
		except Exception as e:
			print str(e)
			self.conn.rollback()

	def getIdProfile(self,firstName,lastName):
		try: 
			self.cursor.execute("""SELECT id FROM UserProfile WHERE firstName ='%s' AND lastName ='%s'""" % (firstName, lastName))
			result = self.cursor.fetchone()
			if result is not None:
				return result[0]
			else:
				return -1#si erreur 
		except Exception as e:
			print str(e)
			return -1#si erreur

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

	def addCompanies(self,listOfCompanies):
		try:
			for com in listOfCompanies:
				self.cursor.execute(""" INSERT INTO Company (name) VALUES ('%s'); """ 
									% (com))
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
	d1= databaseManager("imanage")
	d1.emptyDatase()
	#========================================================================
	#new account (test create account already exist)
	d1.addUserAccount("user","passwd","user@mail.com","Student")
	#========================================================================

	#new profile(test create profile already exist)
	d1.addUserProfile("Steve", "Job", "job@vacheALait.com", "0614008530", "home/apple.pdf")

	#========================================================================
	#account to delete (test delete account already exist)
	d1.addUserAccount("ichigo","bleach","manga@cool.com","Student")
	#========================================================================

	#profile to delete, must be link to accound (test delete profile already exist)
	d1.addUserProfile("BelleFontaine","fred","fred@mail.com","0494668842","/home/fredcv.pdf")
	id_profile = d1.getIdProfile("BelleFontaine","fred")
	d1.addUserAccount("BelleFontaine","fred@mail.com","popoye","Student",id_profile)
	#========================================================================

	#add some categories
	listOfCategories=["informatique","biologie","genie civil"]
	d1.addCategories(listOfCategories)
	listOfCompanies=["entreprisea","entrepriseb"]
	d1.addCompanies(listOfCompanies)
	# idInfo= d1.getCategoryId("informatique")
	# idBio =  d1.getCategoryId("biologie")
	# #add some internships 
	# listOfinternships = [("prototype application critique","/home/appCritique.pdf","entreprise a taille humaine cherche petit stagiaire",idInfo),\
	# 					("developpement web services","/home/webServiveces","expert SOA qui doit travailler dur",idInfo),\
	# 					("developpement Objet connecte","/home/iot.pdf","prototype toilettes connectees",idInfo),\
	# 					('amelioration nouvelle enzyme',"/home/enzyme.pdf","amelioration process developpement enzyme",idBio)]
	# d1.addListOfInterships(listOfinternships)