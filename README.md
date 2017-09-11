# sherlock
Simple app which given the right information can play clue. Implemented (with varying degrees of completeleness)
in Java and Python.

Spring-boot application provides serverside support through a REST interface. The React UI accesses this API to provide game functionality to the user. 
###############
# Java Server #
###############

Build: mvn clean install
Run: cd sherlock/Java; ./mvnw spring-boot:run

Rest Call example:
Http Request: http://localhost:8080/newgame/simple?players=Brandon
This will return the stringified version of a Game object. The object may be queried and edited then sent back. In the future I hope the provide serializer/deserializer support.
