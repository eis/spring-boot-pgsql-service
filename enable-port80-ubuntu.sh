sudo apt-get install -y authbind
echo AUTHBIND=yes | sudo tee /etc/default/$USER > /dev/null
sudo touch /etc/authbind/byport/80
sudo chmod 500 /etc/authbind/byport/80
sudo chown $USER /etc/authbind/byport/80
