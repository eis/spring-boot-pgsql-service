spring-boot-pgsql-service
=========================

<a title="Build Status" href="https://travis-ci.org/eis/spring-boot-pgsql-service"><img src="https://api.travis-ci.org/eis/spring-boot-pgsql-service.svg?branch=master" /></a>

Infra setup (VM)
----------------

`vagrant up`

Infra setup (Ubuntu host)
-------------------------

`./ubuntu-deps.sh`

Build & run the app
-------------------

Note: If you want to use VM, begin with `vagrant ssh` && `cd /vagrant`

1. `mvn clean package`
2. `java -jar target/*.jar`

Run in port 80
--------------

1. `./enable-port80-ubuntu.sh`
2. `./run-port80.sh`
