FROM maven:latest

WORKDIR /usr/src/app

COPY . .

WORKDIR /usr/src/app/Java

RUN mvn clean install

RUN mvn -N io.takari:maven:wrapper

CMD ["./mvnw", "spring-boot:run"]