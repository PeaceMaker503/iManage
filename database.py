#!/usr/bin/env python
# -*- coding: utf-8 -*-


import pymysql

listTables = ['UserAccount', 'Internship', 'Company', 'Category', 'UserProfile']

#userAccount = {
#	'name':'user',
#	'password' : 'passwd',
#	'mail' : 'user@mail.com'
#}

#UserAccountToDelete = {
#	'name':'ichigo',
#	'password' : 'bleach',
#	'mail' : 'manga@cool.com'
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

	def addUserAccount(self,name,password,mail):
		try:
			self.cursor.execute(""" INSERT INTO UserAccount (login, password, mail) VALUES ('%s', '%s', '%s'); """ 
								% (name, password,mail))
			self.conn.commit()
		except Exception as e:
			print str(e)
			self.conn.rollback()

	def addUserProfile(self):
		try:
			self.cursor.execute(""" INSERT INTO UserProfile (firstName, lastName, mail, phone, cvPath) VALUES ('%s', '%s', '%s', '%s', '%s'); """ 
								% (userProfile['firstName'], userProfile['lastName'], userProfile['mail'], userProfile['phone'], userProfile['cvPath']))
			self.conn.commit()
		except Exception as e:
			print str(e)
			self.conn.rollback()

if __name__ == '__main__':
	d1= databaseManager()
	d1.emptyDatase()
	#new account 
	d1.addUserAccount("user","passwd","user@mail.com")
	#account to delete
	d1.addUserAccount("ichigo","bleach","manga@cool.com")
	d1.addUserProfile()