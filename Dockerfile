FROM openjdk:11
ADD target/foodconnect-0.0.1-SNAPSHOT.jar /food-app.jar 
ENTRYPOINT ["java","-jar","/food-app.jar"]