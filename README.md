# Stock market

The application consists of 2 modules:
 - stock producer - produces with fixed delay stock prices 
 - stock consumer - consumes produced stock prices
 
 Communication between components is based on spring cloud stream module. The message broker used in the example is rabbitmq.
 
 ### Tools
 - jdk - at least 8
 - maven - at least 3.3.9
 
 ### Build
 The following command build, runs tests and generates 2 runnable jar files:
 
 <code>mvn clean package</code> 
 
 ### Links
 - https://cloud.spring.io/spring-cloud-stream/ - official site of spring cloud stream