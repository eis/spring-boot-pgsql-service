spring-boot-pgsql-service
=========================

<a title="Build Status" href="https://travis-ci.org/eis/spring-boot-pgsql-service"><img src="https://api.travis-ci.org/eis/spring-boot-pgsql-service.svg?branch=master" /></a>

Infra setup (VM)
----------------

```bash
vagrant up
```

Infra setup (Ubuntu host)
-------------------------

```bash
./ubuntu-deps.sh
```

Build & run the app in port 8080
--------------------------------

Note: If you want to use VM, begin with `vagrant ssh` && `cd /vagrant`

1. `mvn clean package`
2. `java -jar target/*.jar`

Or just `mvn spring-boot:run`.

Run in port 80
--------------

1. `./enable-port80-ubuntu.sh`
2. `./run-port80.sh`

Usage
-----
```bash
# send an entry
curl -X PUT localhost:8080/highscore  -H "Content-Type: application/json" --data "{\"author\":\"me\", \"score\":\"999\",\"date\":\"2017-11-11T13:47:29Z\"}"

# get highscores
curl localhost:8080/highscore
```
Note that by default database is cleared on every start.
This can be controlled in properties, just comment out
`spring.jpa.hibernate.ddl-auto=create` or set it to `none`.