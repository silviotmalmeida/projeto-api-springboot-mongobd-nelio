#!/bin/bash

echo "Definindo permissoes da pasta de código-fonte..."
docker container exec api-springboot-mongodb chmod 777 -R /app
sleep 1

echo "Parando o container..."
docker-compose down
