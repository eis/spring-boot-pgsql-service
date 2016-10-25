apt-get update
apt-get install -y postgresql postgresql-contrib openjdk-8-jdk maven
sudo -u postgres psql -U postgres -d postgres -c "alter user postgres with password 'postgres';"
