REM open with text_editor ou open with system editor
REM Refresh eclipse pour visualiser le code généré

set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_102
set CHEMIN_XSD=src/main/resources/avec_namespaces
cd /d "%~dp0" 
REM se placer dans le repertoire courant

"%JAVA_HOME%\bin\xjc" -d src/main/java %CHEMIN_XSD%/product.xsd

pause