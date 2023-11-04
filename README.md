# spring-boot-example
review

# Code Review On Customer Class:

## Overview
The "Customer" class is well-structured but there can be some adjustments.

## Recommendations:
* Use Lombok annotations to reduce boilerplate code and long codes.
  the dependency <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.24</version>
      <scope>provided</scope>
  </dependency>
  
* Change the data type of the `id` field to Interger to Long and set it to be generated automatically (GenerationType.IDENTITY) 
  Why:  Long has a much bigger capacity than Integer data type, so if you are not sure what length your data is going to be, its better to be using Long type data and indentity increament in one table since it what we working with

* Remove the `id` field from the constructor
  Why: allows/helps for easier object creation when working with JPA.

* Remove `setId` method.
  Why: The getter and setter methods are kept for accessing and modifying the entity's properties. and the `id` is auto incremented

# Code Review On CustomerRepository Interface:

## Overview
The "CustomerRepository" extends `JpaRepository`. 

## Recommendations
* Add `@Repository` anotation but not necessary.

# Code Review: Main (Controller) Class

## Overview
The `Main()` calls all the other functions required to run your program. following RESTful conventions.

## Recommendations
* Introduce a service layer to separate data access from the controller
* Separate the controller from the main class


# Overview
* For a better approach, introduce a `CustomerService` for business Logic.
* Consider creating custom error, response status code and exception handling classes.
