spring-boot-pgsql-service
=========================

Infra setup (VM)
----------------

`vagrant up`

Infra setup (Ubuntu host)
-------------------------

`./ubuntu-deps.sh`

Build & run the app
-------------------

Note: If you want to use VM, begin with vagrant ssh && cd /vagrant

`mvn clean package`
`java -jar target/*.jar`

Run in port 80
--------------

`./enable-port80-ubuntu.sh`
`./run-port80.sh`
