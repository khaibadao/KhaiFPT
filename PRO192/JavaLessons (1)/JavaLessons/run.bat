@echo off
REM Build va chay khong can NetBeans/Maven (Windows CMD)
REM   run.bat        -> menu
REM   run.bat all    -> chay tat ca bai
REM   run.bat 10     -> chay rieng bai 10
cd /d "%~dp0"
if exist out rmdir /s /q out
dir /s /b src\main\java\*.java > sources.txt
javac -encoding UTF-8 -d out @sources.txt
set ERR=%errorlevel%
del sources.txt
if not %ERR%==0 exit /b %ERR%
java -cp out Main %*
