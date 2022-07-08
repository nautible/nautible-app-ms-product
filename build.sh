#!/bin/sh

mvn clean package -P $1 -Dquarkus.package.type=fast-jar -DskipTests=true
ret=$?
if [[ $ret -ne 0 ]]; then
    echo "[ERROR] ----------------------[ maven build error ]-----------------------"
    exit 1
fi
cd nautible-app-ms-product-build
docker build -t $IMAGE -f ./src/main/docker/Dockerfile.jvm .
