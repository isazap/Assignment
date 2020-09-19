FROM openjdk:8-jre

ENV WIREMOCK_VERSION 2.27.2

# get standalone wiremock jar
RUN mkdir -p /var/wiremock/lib/ \
    && wget https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-jre8-standalone/$WIREMOCK_VERSION/wiremock-jre8-standalone-$WIREMOCK_VERSOIN.jar \
    -0 /var/wiremock/lib/wiremock-jre8-standalone.jar

WORKDIR /home/wiremock

VOLUME /home/wiremock
EXPOSE 8080

CMD java $JAVA_OPTS -cp /var/wiremock/lib/*;/var/wiremock/extensions/* comm.github.tomakehurst.standalone.WireMockServerRunner