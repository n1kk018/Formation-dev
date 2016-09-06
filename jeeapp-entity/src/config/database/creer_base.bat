set MYSQL_HOME=C:\Program Files (x86)\MySQL\MySQL Server 5.1

cd /d "%~dp0" 
REM se placer dans le repertoire courant

"%MYSQL_HOME%\bin\mysql" -u root -p < create_devisedb.sql

pause

REM  open with / Text Editor pour editer le ficher sous eclipse
REM  open with / System Editor pour lancer le ".bat" sous eclipse