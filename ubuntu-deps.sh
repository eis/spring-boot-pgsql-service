apt-get update
apt-get install -y postgresql-9.5 postgresql-contrib openjdk-8-jdk maven
sudo -u postgres psql -U postgres -d postgres -c "alter user postgres with password 'postgres';"
if [ -f "/vagrant/create.sql" ]; then
  sudo -u postgres psql -U postgres -d postgres -f /vagrant/create.sql
else
  sudo -u postgres psql -U postgres -d postgres -f ./create.sql
fi
apt-get install -y tomcat8 tomcat8-admin tomcat8-docs