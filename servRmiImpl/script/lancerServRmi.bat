set M2_REPOSITORY=C:\Users\stagiaire\.m2\repository
set CP="%M2_REPOSITORY%/fr/afcepf/al28/servRmiApi/1.0/servRmiApi-1.0.jar;%M2_REPOSITORY%/fr/afcepf/al28/servRmiImpl/1.0/servRmiImpl-1.0.jar"
cd /d "%~dp0"
java -cp %CP% fr.afcepf.al28.rmi.serv.app.ServRmiApp %REMOTE_HOST%
pause