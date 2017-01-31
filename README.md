# iManage Web Application
## INSA Toulouse - 5IL
## Web application based on web services and SOA.

## Team members:
  - Abdillah Ahamada
  - Halim Chellal
  - Jordy Cabannes
  - Pablo Maldonado
  - Paul Neissen

## Description:

## Requirements:
* Java 8: you may find the installations instructions [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Netbeans IDE 8.2: you may find the installations instructions [here](https://netbeans.org/downloads/)
* Docker Engine: you may find the installation instructions [here](https://docs.docker.com/engine/installation/)

## Installation instructions:

To use iManage, please clone this repository to the desired folder of your computer. You will find the required libraries and also the source code of the three projects of iManage. 

### Set up the iManage project (Web application)

1. Create the project from existing sources (web application) 
2. Set up the database: 
  * Name: imanage
  * User: root 
  * Password: mamaya
3. Fix the paths of file savings of the iManage project:
  * asdas
    * Internship convention generation: /src/
    * Save a CV:
    * 

### Set up the iCompany project (Company A)

1. Create the project from existing sources (web application) 
2. Set up the database: 
  * Name: entreprisea
  * User: root 
  * Password: mamaya

### Set up the iCompany2 project (Company B)

1. Create the project from existing sources (web application) 
2. Set up the database: 
  * Name: entrepriseb
  * User: root 
  * Password: mamaya

### Populate the databases of each project:
1. Python script.

### Set up the Zato ESB 
1. Installation
2. Service configuration
3. Response configuration

## Deployment instructions:
1. Build and deploy iCompany
2. Build and deploy iCompany2
3. Start the Zato ESB Docker image.
4. Build and deploy iManage
