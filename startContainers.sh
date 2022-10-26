#!/bin/bash

echo "Subindo o container..."
docker-compose up -d --remove-orphans

sleep 5

echo "Definindo permissoes da pasta de código-fonte..."
docker container exec api-springboot-mongodb chmod 777 -R /app
sleep 1

# echo "Iniciando o mongo..."
# docker container exec api-springboot-mongodb mongod &
# sleep 5

echo "Processo concluído."
