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


```bash
# Build
mvn clean package

# Run
./run-app.sh

# Run in VM:
vagrant ssh
/vagrant/run-app.sh

# Stop in VM: 
vagrant ssh -c "pkill java"
```

Run in port 80
--------------

```bash
./enable-port80-ubuntu.sh
./run-port80.sh
```

Usage
-----
```bash
# send an entry
curl -X PUT localhost:8080/highscore  -H "Content-Type: application/json" --data "{\"author\":\"me\", \"score\":\"999\",\"date\":\"2017-11-11T13:47:29Z\"}"

# get highscores
curl localhost:8080/highscore
```
