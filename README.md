Ecommerce
This is an ecommerce REST API built using Java and Spring Boot. The API provides functionality for managing products, orders, and customers. The API uses JSON Web Tokens (JWT) for authentication and authorization.

Table of Contents
Microservices
config-service
api-gateway
catalog-service
order-service
auth-service
image-service
customer-service
cart-service
Technologies Used
Setup
Authentication and Authorization
Future Development
Microservices
The API is built using a microservice architecture, with the following services:

api-gateway
The api-gateway service provides a single entry point for clients to access the various services in the system.

catalog-service
The catalog-service service manages the catalog of products available for sale.

config-service
The config-service service stores configuration data for the various services in the system.

order-service
The order-service service manages orders placed by customers.

auth-service
The auth-service service provides authentication and authorization for the system.

image-service
The image-service service manages the images associated with products.

customer-service
The customer-service service manages information about customers who have registered with the system.

cart-service
The cart-service service manages customer cart

Technologies Used
The following technologies were used to build this API:

Spring Cloud (Config, OpenFeign, Eureka)
JPA / Hibernate
Springdocv2
Java version 19
Spring Boot version 3.0.2
PostgreSQL database
Setup
Clone this repository to your local machine.
Install PostgreSQL database and create a database for the application.
Update the application-{service}.yml file in the config-server module with the database details for each service.
Start the Eureka server by running the DiscoveryServerApplication.java file in the discovery-server module.
Start the Config Server by running the ConfigServerApplication.java file in the config-server module.
Start the Api Gateway by running the ApiGatewayApplication.java file in the api-gateway module.
Start the remaining modules (catalog-service, order-service, auth-service, image-service, customer-service and cart-serivce) by running their respective Application.java files.
Authentication and Authorization
The API uses JSON Web Tokens (JWT) for authentication and authorization. When a user logs in, they receive a JWT that must be included in the header of all subsequent requests. The JWT is verified on the server side to ensure that the user is authenticated and authorized to perform the requested action.

Future Development
In the future, a React-based frontend will be added to the application to provide a user interface for managing products, orders, and customers.

Additionally, the API could be expanded to include features such as payment processing, order tracking, and inventory management. The API could also be optimized for performance by implementing caching, load balancing, and other techniques. Finally, the API could be secured further by adding additional security measures such as rate limiting, input validation, and intrusion detection.