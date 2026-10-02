@echo off
setlocal
cd /d "%~dp0"

set "JAR=gradle\wrapper\gradle-wrapper.jar"
set "URL=https://services.gradle.org/distributions/gradle-9.6.0-wrapper.jar"
set "SHA=497c8c2a7e5031f6aa847f88104aa80a93532ec32ee17bdb8d1d2f67a194a9c7"

if exist "%JAR%" goto verify

echo Baixando o Gradle Wrapper oficial...
powershell -NoProfile -Command "Invoke-WebRequest -UseBasicParsing '%URL%' -OutFile '%JAR%'"
if errorlevel 1 (
    echo.
    echo Nao foi possivel baixar o wrapper automaticamente.
    echo Abra o projeto no Android Studio e gere o Gradle Wrapper, ou execute Gradle 9.6.0: gradle wrapper.
    pause
    exit /b 1
)

:verify
for /f "usebackq delims=" %%H in (`powershell -NoProfile -Command "(Get-FileHash '%JAR%' -Algorithm SHA256).Hash.ToLower()"`) do set "ACTUAL=%%H"
if /I not "%ACTUAL%"=="%SHA%" (
    echo ERRO: checksum do gradle-wrapper.jar nao confere.
    echo Esperado: %SHA%
    echo Obtido:   %ACTUAL%
    del /q "%JAR%" 2>nul
    pause
    exit /b 1
)

echo Gradle Wrapper pronto e verificado.
echo Agora voce pode abrir esta pasta no Android Studio.
pause
