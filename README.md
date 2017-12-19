spring-boot-pgsql-service
=========================

<a title="Build Status" href="https://travis-ci.org/eis/spring-boot-pgsql-service"><img src="https://api.travis-ci.org/eis/spring-boot-pgsql-service.svg?branch=master" /></a>

Amazon version.

Infra setup (VM)
----------------

https://eu-central-1.console.aws.amazon.com/elasticbeanstalk/home?region=eu-central-1#/getting_started

-> create new application -> Web -> Tomcat, Load balanced, Java8

http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/java-rds.html


Build & run the app in port 8080
--------------------------------


```bash
# Build
mvn clean package
```

Usage
-----
```bash
# send an entry
curl -X PUT hostname/highscore -H "Content-Type: application/json" --data "{\"author\":\"me\", \"score\":\"999\",\"date\":\"2017-11-11T13:47:29Z\"}"

# get highscores
curl hostname/highscore
```
