SET MYSQL_HOME=C:\Program Files (x86)\MySQL\MySQL Server 5.1
cd /d %~dp0
"%MYSQL_HOME%/bin/mysql" -uroot -pafcepf <bdd_livraison.sql
