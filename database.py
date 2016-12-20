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

	def __init__(self):
		self.conn = pymysql.connect(host="localhost",user="root",password="mamaya", database="imanage")
		self.cursor = self.conn.cursor()
	

	def emptyDatase(self):
		try:
			for table in listTables:
				self.cursor.execute(""" delete from %s; """ % (table))
				self.conn.commit()
		except Exception as e:
			print str(e)
			self.conn.rollback()

	def addUserAccount(self,name,password,mail,id_profile_id=None):
		try:
			if id_profile_id==None:
				self.cursor.execute(""" INSERT INTO UserAccount (login, password, mail) VALUES ('%s', '%s', '%s'); """ 
									% (name, password,mail))
			else:
				self.cursor.execute(""" INSERT INTO UserAccount (login, password, mail,id_profile_id) VALUES ('%s', '%s', '%s','%s'); """ 
									% (name, password,mail,id_profile_id))

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

if __name__ == '__main__':
	d1= databaseManager()
	d1.emptyDatase()

	#new account (test create account already exist)
	d1.addUserAccount("user","passwd","user@mail.com")

	#new profile(test create profile already exist)
	d1.addUserProfile("Steve", "Job", "job@vacheALait.com", "0614008530", "home/apple.pdf")

	#account to delete (test delete account already exist)
	d1.addUserAccount("ichigo","bleach","manga@cool.com")


	#profile to delete, must be link to accound (test delete profile already exist)
	d1.addUserProfile("BelleFontaine","fred","fred@mail.com","0494668842","/home/fredcv.pdf")
	id_profile = d1.getIdProfile("BelleFontaine","fred")
	d1.addUserAccount("BelleFontaine","fred@mail.com","popoye",id_profile)