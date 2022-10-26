#!/bin/bash

echo "Definindo permissoes da pasta de código-fonte..."
docker container exec api-springboot-mongodb chmod 777 -R /app
sleep 1

echo "Iniciando o app..."
docker container exec -it api-springboot-mongodb bash -c "cd /app; java -jar target/app-0.0.1-SNAPSHOT.jar;"
