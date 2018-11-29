# Stock market

Simple demonstration how to produce and consumer messages using spring stream cloud with rabbitmq support.

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
  
 ### Producing a message
 There are 2 options to produce a message:
 1) enable `producerScheduler` profile which makes message is emitted each 2 seconds
 2) send request to rest api:
 
 <code>curl -d '{"name":"ibm", "price":"500$", "time": 1543525802981}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/stock</code> 
 
 ### Links
 - https://cloud.spring.io/spring-cloud-stream/ - official site of spring cloud stream