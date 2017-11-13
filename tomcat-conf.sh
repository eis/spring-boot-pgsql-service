cp -f ./tomcat-config/context.xml /etc/tomcat8
cp -f ./tomcat-config/server.xml /etc/tomcat8
cp -f target/boot-pgsql-service-1.0-SNAPSHOT/WEB-INF/lib/postgresql-9.1-901-1.jdbc4.jar	/etc/tomcat8
#cp -f tomcat-lib/org.springframework.instrument.tomcat-3.2.5.RELEASE.jar /opt/apache-tomcat/lib
rm -rf /var/lib/tomcat8/webapps/ROOT
