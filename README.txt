Paperless World - Core Java + JDBC (Full)

Steps to run (Windows):
 1. Install JDK (11 or 17+). Ensure javac and java are on PATH.
 2. Install MySQL and create user. Note your root password.
 3. Edit file src/com/paperless/util/DBConnection.java and replace PASSWORD value with your MySQL password.
 4. Import database.sql into MySQL (Workbench or CLI):
      mysql -u root -p < database.sql
 5. Download MySQL Connector/J (mysql-connector-java-8.x.jar) and place it, e.g. C:\libs\mysql-connector-java.jar
 6. Open CMD, cd to the 'src' folder of this project and run:
      run.bat
    OR compile manually:
      javac -cp .;C:\libs\mysql-connector-java.jar Main.java com\paperless\**\*.java
      java -cp .;C:\libs\mysql-connector-java.jar Main

Steps to run (Linux/macOS):
 1. Similar; edit DBConnection PASSWORD and set MYSQL_JAR path in run.sh, then:
      chmod +x run.sh
      ./run.sh

Project features (menu):
 - Add user (ADMIN/SIGNER/REVIEWER)
 - Upload document (save metadata)
 - Sign document (create signature record)
 - Verify signature (lookup by signature id)
 - List documents

If you get Driver errors, ensure connector jar is in classpath.
