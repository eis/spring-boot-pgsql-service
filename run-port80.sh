BASEDIR=$(dirname $0)
exec authbind --deep java -jar $BASEDIR/target/*.jar --server.port=80
