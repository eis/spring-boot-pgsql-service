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

# Deploy to Tomcat:
mvn -s settings-vm.xml tomcat7:deploy-only

# Note that making it Tomcat root app still requires
# manual steps

# Stop in VM: 
vagrant ssh -c "sudo systemctl stop tomcat8"
```

Run Tomcat in port 80
---------------------

```bash
./enable-port80-ubuntu.sh
./run-port80.sh
```

Deploy to root context
----------------------
```bash
sudo systemctl stop tomcat8
cd /var/lib/tomcat8/webapps
sudo rm -rf ROOT
sudo rm -rf ROOT.war
sudo cp /vagrant/target/*.war ./ROOT.war
sudo systemctl start tomcat8
```

Usage
-----
```bash
# send an entry
curl -X PUT localhost:8080/highscore  -H "Content-Type: application/json" --data "{\"author\":\"me\", \"score\":\"999\",\"date\":\"2017-11-11T13:47:29Z\"}"

# get highscores
curl localhost:8080/highscore
```
