FROM adoptopenjdk/openjdk11

COPY ./target/calculator-api-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

#RUN sh -c 'touch calculator-api-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","calculator-api-0.0.1-SNAPSHOT.jar"]
