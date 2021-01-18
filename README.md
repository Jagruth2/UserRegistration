# UserRegistration

Use the jar file provided as user registration microservice

when this jar file run on windows, it will run on background as javaw which can viewed in details section of task manager.

Then use postman service to create the user

we use two commands in postman service POST and GET


creating the user:
POST : use POST http://localhost:8081/customer and add Content-Type as application/json in headers of postman service.

this will create the new user and send the details to DynamoDB database
      
      
      Then add details in Body section of postman as follows:
      
      {
    "customerId": "33",
    "title":"Mr",
    "lastName":"jag",
    "firstName": "Jagruthe",
    "mobileNumber":"33",
    "postCode":"2222",
    "subUrb" : "LEICHHARDT" ,
     "state" : "NSW" ,
    "fullAddress" : "100 william street, leichhdart, nsw 2040"
   
      }
      
      Note: customerId and mobile number should be numerical values or else it will give the error.
      
     
Getting details of the user:
GET:  use GET http://localhost:8081/customers/{customerId} and add Content-Type as application/json in headers of postman service.

example : GET http://localhost:8081/customers/33
This will fetch the details of the customer with id 33 from the DynamoDB database


     {
    "customerId": "33",
    "title":"Mr",
    "lastName":"jag",
    "firstName": "Jagruthe",
    "mobileNumber":"0334423344",
    "postCode":"2222",
    "subUrb" : "LEICHHARDT" ,
     "state" : "NSW" ,
    "fullAddress" : "100 william street, leichhdart, nsw 2040"
     }


Updating the details of the user:

User Need to know the customerID to update their details.
The customerId we used is a primary key of DyanmoDB database. So, it is unique. With the help of customerId the user can update the details.
POST : use POST http://localhost:8081/customer and add Content-Type as application/json in headers of postman service.


      
   
      Then add details in Body section of postman as follows:
      
      {
    "customerId": "33",
    "title":"Mr",
    "lastName":"Ram",
    "firstName": "Arnodl",
    "mobileNumber":"042222222",
    "postCode":"2222",
    "subUrb" : "LEICHHARDT" ,
     "state" : "NSW" ,
    "fullAddress" : "100 william street, leichhdart, nsw 2040"
   
      }
      
      this will update the user and send the details to DynamoDB database
      
      Note: customerId and mobile number should be numerical values or else it will give the error.
      
      
      
I have created the Docker container of this springboot Java application and uploaded it to ECS of AWS.
This created a public ip 3.92.51.165
Instead of using local host in POST and GET of PostMan
Use http://3.92.51.165:8081/customer for POST
and 
USE http://3.92.51.165:8081/customers/{customerId}
for GET in PostMan.
This is accessable from anylocation with the help of PostMan.


                     ARCHITECHURE:

Used SpringBoot and Maven with help of eclipse IDE to create this Application.
I have used mainly 4 java classes:

Customer.class to create and get the details of the customer.

CustomerController.class to create POST and GET methods.

DynamoDBConfig.class to validate AWS and DynamoDB configutations

CustomerDao.class to map DynamoDB database



Created local user-create-0.0.1-SNAPSHOT.jar java file which can be used as microservice.

Next downloaded the Docker Desktop application and installed it.
With the help of windows powershell opened from this project location I have created the docker image and pushed it Docker Hub as a repository.

Then in AWS ECS in virgina region I used this docker container.
In the ECS cluster I have obtained the Public IP 3.92.51.165 which can be used as a microservice with the port 8081
For example
http://3.92.51.165:8081/customer which can be used in postman POST to create the user profile

