@echo off

if "%OS%" == "Windows_NT" (
  set "DIRNAME=%~dp0%"
) else (
  set DIRNAME=.\
)
java %KC_OPTS% -cp "%DIRNAME%\client\keycloak-client-registration-cli-9.0.3.redhat-00002.jar" org.keycloak.client.registration.cli.KcRegMain %*
