# iManage Web Application
### INSA Toulouse - 5IL

## Description:

iManage is a web application conceived to serve as the sole platform which will help 5th year INSA students through the stages related to their internship application and administrative validation processes. These steps are currently accomplished through different websites but iManage simplifies these processes by reuniting them on the same interface. This product was developed using Java Enterprise Edition, Spring MVC framework, and Hibernate ORM to manipulate the transactions of the application database. In the aim of guaranteeing its scalability and maintainability, this product was developed following the Service Oriented Architecture approach and using the Zato Enterprise Service Bus technology. One of its main features is a search engine which looks for internship offers that are retrieved from several company databases. Students can to apply to multiple offers, and once one of them has attracted the attention of a company, a messaging system will be activated to establish the communication between them. The administrative processes related with the internship validation by the INSA staff and the generation of the internship convention are also managed by the web application.

## Team members:
  - Abdillah Ahamada.
  - Halim Chellal.
  - Jordy Cabannes.
  - Pablo Maldonado.
  - Paul Neissen.

## Requirements:
* Java 8: you may find the installation instructions [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Netbeans IDE 8.2: you may find the installation instructions [here](https://netbeans.org/downloads/)
* Docker Engine: you may find the installation instructions [here](https://docs.docker.com/engine/installation/)

## Installation instructions:

### Clone the repository

To use iManage, please clone this repository to the desired folder of your computer. You will find the required libraries and also the source code of the three projects of iManage. 

## Set up the databases:
1. You must create three databases with the following names:
  * imanage
  * entreprisea 
  * entrepriseb
2. Create a user with the following credentials with all the prvileges to all the mentioned databases:
  * user: root
  * password: mamaya

### Set up the iManage project (Web application)

1. Open Netbeans and create a new project (Java Web -> Web application from existing sources)
2. Name the project as iManage and select the /src folder from the repository.
3. As server and settings select GlassFish Server and Java EE 7 Web.
4. Remember to add the Spring MVC and the Hibernate frameworks.
5. Create the project.
6. Set up the connection for the imanage database. You may follow [these instructions](https://netbeans.org/kb/docs/ide/oracle-db.html#connect)
7. Fix the paths of the file savings of the iManage project:
  * asdas
    * Internship convention generation: src/java/insa/client/Convention.java
    * CV and Cover letter: /src/java/insa/client/FileUploadServlet.java

### Set up the iCompany project (Company A)

1. Open Netbeans and create a new project (Java Web -> Web application from existing sources)
2. Name the project as iCompany and select the /iCompany/src/ folder from the repository.
3. As server and settings select GlassFish Server and Java EE 7 Web.
4. Remember to add the Spring MVC and the Hibernate frameworks.
5. Create the project.
6. Set up the connection for the entreprisea database. You may follow [these instructions](https://netbeans.org/kb/docs/ide/oracle-db.html#connect)

### Set up the iCompany2 project (Company B)

1. Open Netbeans and create a new project (Java Web -> Web application from existing sources)
2. Name the project as iCompany2 and select the /iCompany2/src/ folder from the repository.
3. As server and settings select GlassFish Server and Java EE 7 Web.
4. Remember to add the Spring MVC and the Hibernate frameworks.
5. Create the project.
6. Set up the connection for the entrepriseb database. You may follow [these instructions](https://netbeans.org/kb/docs/ide/oracle-db.html#connect)

### Populate the databases of each project:
1. Run the Python script available at /scriptTests/populateDatabases.sh to populate all the databases.

### Set up the Zato ESB 
1. Installation:
  * Follow the instalation instructions available [here](https://zato.io/docs/admin/guide/install/docker.html)
  * Remember to save the web admin password to have access to the zato interface. 
  * After finishing the instructions, you may test that your zato instance is running on the address [http://localhost:8183](http://localhost:8183)
2. Service configuration:
  *
3. Response configuration:
  *

## Deployment instructions:
1. Build and deploy iCompany.
2. Build and deploy iCompany2.
3. Start the Zato ESB Docker image by running the following command:
  * ```docker start -a -i <image_id>```
4. Build and deploy iManage.
5. Check the address [http://localhost:8080/iManage](http://localhost:8080/iManage)
