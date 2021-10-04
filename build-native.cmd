cmd /c "mvn clean package -Pnative -Dquarkus.native.container-runtime=docker -Dquarkus.container-image.push=true -Dquarkus.container-image.group=localhost:5000 -Dquarkus.container-image.name=nautible-app-product -Dquarkus.container-image.tag=latest -DskipTests=true"
if not %ERRORLEVEL% == 0 (
    echo "[ERROR] ----------------------[ maven build error ]-----------------------"
    exit 1
)

:dockerbuild
cmd /c "docker build -t %IMAGE% -f ./src/main/docker/Dockerfile.native ."
