@echo off
echo "================================= clean start ================================="
call mvn clean
echo "================================= clean success ================================="
echo "================================= package start ================================="
call mvn package -Dmaven.test.skip=true
echo "================================= package success ================================="
echo "================================= porject start ================================="
set dirPath=%cd%/target/springbootlearingone-1.0-SNAPSHOT.jar
echo %dirPath%
java -jar %dirPath%

