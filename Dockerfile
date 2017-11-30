FROM maven

WORKDIR /usr/src/app

COPY . .

WORKDIR /usr/src/app/Java

RUN mvn clean install

RUN ./mvnw spring-boot:run