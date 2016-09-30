set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_102
set WSDL_URL=http://localhost:8081/serviceTva?wsdl
REM set WSDL_URL=http://localhost:8080/jeeapp-ejb-impl/ServiceDeviseBean?wsdl
cd /d "%~dp0"
"%JAVA_HOME%/bin/wsimport" -d src/main/java -keep %WSDL_URL%
pause