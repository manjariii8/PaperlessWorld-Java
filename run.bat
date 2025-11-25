@echo off
REM Compile all Java files
javac com\paperless\model\*.java com\paperless\dao\*.java com\paperless\service\*.java Main.java

REM Run the program
java Main

pause
