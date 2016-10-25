spring-boot-pgsql-service
=========================

Infra setup (VM)
----------------

1. vagrant up
2. vagrant ssh
3. cd /vagrant
4. ./set-postgresql-pass.sh

Infra setup (Ubuntu host)
-------------------------

1. ./ubuntu-deps.sh
2. ./set-postgresql-pass.sh

Build & run the app
-------------------

1. mvn clean package
2. java -jar target/*.jar

Run in port 80
--------------

1. enable-port80-ubuntu.sh
2. run-port80.sh
