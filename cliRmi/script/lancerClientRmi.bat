set M2_REPOSITORY=C:\Users\stagiaire\.m2\repository
REM set CP="./servRmiApi-1.0.jar;./cliRmi-1.0.jar"
set CP="%M2_REPOSITORY%/fr/afcepf/al28/servRmiApi/1.0/servRmiApi-1.0.jar;%M2_REPOSITORY%/fr/afcepf/al28/cliRmi/1.0/cliRmi-1.0.jar"
REM set REMOTE_HOST=localhost
set REMOTE_HOST=192.168.102.76
cd /d "%~dp0"
java -cp %CP% fr.afcepf.al28.rmi.client.clientRmiApp %REMOTE_HOST%
pause