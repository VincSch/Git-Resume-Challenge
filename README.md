Git Resumé - Java Challenge
=================
The project consists of a parent module with three sub modules (data,service,web).
For the backend part I used spring boot and for the frontend AngularJs and Bootstrap.
Even though splitting the application in sub modules might be not necessary I wanted to show how
it could be done using Maven.

Tested using OSX and Ubuntu.

Compile & Run
=======
Required: Maven 3+

Build:
mvn clean install

Run:
mvn spring-boot:run
or
cd /web/target
java -jar web-1.0-SNAPSHOT.jar

