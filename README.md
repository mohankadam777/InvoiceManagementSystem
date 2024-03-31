# Invoice Management System

## Frontend 
1. Frontend part of the project is under `InvoiceeManagementSystem` of this repo
2. clone the rep and install all the dependencies using `npm install` by moving into the frontend folder
3. Angular is used as a Frontend framework.
4. To start the server run `ng serve`.
5. This application has only one page which handles CRUD application of Customer and Invoice Models.
6. We also have a filter to seperate out Invoice and Customer List
7. Validations has been done on the frontend side to accept only valid input.
   

 ## Backend 
 1. Springboot is used as framewwork to build REST API for the application.
 2. All configuration is done in the backend only
 3. Postgre SQL is used for the database.
 4. Entities are persisited with the help JPA repository.
 5. There are 2 Models first is the `Customer` and second is the `Invoice`
 6. Implemented Validations while persisting the records in database.
 7. Pagination is also implemented while fetching the records.
 8. Best practises are used for Error and exception handling.

  ## Database 
  1. For the database one need to have Postgre SQL in the machine.
  2. In the ackend we just need to change the update the database-name, username and password with your credentials.
  3. Now if we run the backend application it will connect with the local database.
  4. There are two tables in the database, first is the `Customer` and second is the `Invoice` primary key of `Customer` is the foreign key of `Invoice`.
  5. Invoice is having Many to one relationship with the Customer table
  6. Product details is also a part of the Invoice table which is json array.
  7. Suitable validations are included in the Schema.
     
 
