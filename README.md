Introduction
=====================


*   this is a testing project for techno:
    *   spring boot
    *   spring rest (not jersey) should change the name of the app)
    *   spring integration with rabbitMQ
    *   spring data mongodb


simple basic commands
=====================


*   Hello World Resource
`curl -X GET localhost:9000/hello-world`

*   Customer Resource
`curl -X POST localhost:9000/customer` create a customer
`curl -X GET localhost:9000/customer/id` get customer with id


*   Customers Resource
`curl -X GET localhost:9000/customers` => return a list of customers (default pagination to be done)
`curl -X DELETE localhost:9000/customers` => clean the collection of customer and create default one (RESET)


*   basic entry which reset mongo, create some data in it and send a message to the queue

