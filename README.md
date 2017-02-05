# Quest Developer Test

## Requirements and Deployment Guidelines

### Technology stack
- 	Spring MVC (spring 4 -annotation driven)
-   Jquery
-   Jsp
-   Junit test cases (mockito)


### Platform

- Java 1.7
-   Tested on Tomcat 7 server
-   Maven 3.3.9 (Build tool)


### Steps to deploy
- Pull the codebase from git
-   Run "mvn clean install" command on the codebase - to genarate war file
-   Push the war file to server (Tomcat 7) and start the server - the application can be accessed through http://localhost:8080/quest/welcome.html



## Application Walk-Through

### Landing Page

Landing page has two links

- Add a new record
- List all records


![landing](https://cloud.githubusercontent.com/assets/25563324/22627091/700bc87a-ebb3-11e6-99bc-40c099adc9ca.PNG)

### Add Record Page

This page gets the user inputs and performs that following validations. A combination of frontend and backend validations are used to perform this.

- Name should be less than 25 charaters
- PPS Number should be unique
- Date of Birth should be atleast 16 years of age and should not be in the future
- Phone Number should begin with 08


![add_record](https://cloud.githubusercontent.com/assets/25563324/22627113/4cd5a532-ebb4-11e6-8018-b6548b0f8a6d.PNG)


### List all records

This page displays all the existing records

![display_one_record](https://cloud.githubusercontent.com/assets/25563324/22627119/81545f6a-ebb4-11e6-8149-8afd0e006061.PNG)
