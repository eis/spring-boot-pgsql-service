spring-boot-pgsql-service
=========================

Infra setup (VM)
----------------

1. vagrant up

Infra setup (Ubuntu host)
-------------------------

1. ./ubuntu-deps.sh

Build & run the app
-------------------

# If you want to use VM, begin with vagrant ssh && cd /vagrant

1. mvn clean package
2. java -jar target/*.jar

Run in port 80
--------------

1. ./enable-port80-ubuntu.sh
2. ./run-port80.sh
