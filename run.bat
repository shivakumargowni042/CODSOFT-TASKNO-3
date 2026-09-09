@echo off
cd /d "%~dp0"
javac -encoding UTF-8 -d out src\*.java
if %errorlevel% neq 0 (
  echo Compilation failed.
  pause
  exit /b 1
)
java -cp out src.Server
