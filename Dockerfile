FROM maven:3.6.1-jdk-8 as builder

ENV APP_HOME=/root/website-project

RUN mkdir -p $APP_HOME
WORKDIR $APP_HOME

COPY . $APP_HOME

RUN ["mvn", "package"]

FROM jetty:9.3.0-jre8

COPY --from=builder /root/website-project/target/*.war $JETTY_BASE/webapps/