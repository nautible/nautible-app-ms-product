cmd /c "mvn clean package -P %1 -Dquarkus.package.type=legacy-jar -DskipTests=true"
if not %ERRORLEVEL% == 0 (
    echo "[ERROR] ----------------------[ maven build error ]-----------------------"
    exit 1
)

:dockerbuild
cmd /c "docker build -t %IMAGE% -f ./src/main/docker/Dockerfile.legacy-jar ."
