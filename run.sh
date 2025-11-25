#!/bin/bash
# Edit MYSQL_JAR path before running if needed
MYSQL_JAR=~/mysql-connector-java.jar
echo "Compiling..."
javac -cp .:$MYSQL_JAR Main.java com/paperless/util/DBConnection.java com/paperless/model/*.java com/paperless/dao/*.java com/paperless/service/*.java
echo "Running..."
java -cp .:$MYSQL_JAR Main
