## Little Banker Application

####Scope
Implement a RESTful service app that will simulate a little bank. 
It should provide the following:
- Create account with an initial balance
- Show balance per account
- Make payment from one account to another. Optionally, it can be specified that the order will be a recurring one with a period of one day
- Show all transactions in one account with filtering dateFrom and dateTo
- All services should return JSON objects

####Out of Scope:
Let’s assume we don’t need users and authorization for the sake of easiness.

####Run the Application
Please follow the below steps to run locally

1. Check out the code from github and execute "mvn clean compile spring-boot:run" to launch the application
2. Execute the below to create a new bank account
~~~~~~~~~
curl -H "Content-Type: application/json" -X POST -d '{"bankBalance": 100}' http://localhost:33333/account/
~~~~~~~~~
3. Execute the below to retrieve the created account
~~~~~~~~~
curl -H "Content-Type: application/json" -X GET http://localhost:33333/account/1
~~~~~~~~~

The application also has been deployed in OpenShift @ http://littlebanker-harishkumar.rhcloud.com