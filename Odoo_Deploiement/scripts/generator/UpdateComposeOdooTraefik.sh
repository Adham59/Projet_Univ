#!/bin/bash

ODOO_INSTANCE_NAME=$1
ODOO_VERSION=$2
REDIRECTED_PORT=$3

echo "
  odoo_$ODOO_INSTANCE_NAME:
    container_name: cont_odoo_$ODOO_INSTANCE_NAME
    image: odoo:$ODOO_VERSION
    ports:
      - $REDIRECTED_PORT:8069
    volumes:
      - ./odoo.conf.$ODOO_INSTANCE_NAME:/etc/odoo/odoo.conf
    labels:
      - traefik.enable=true
      - "traefik.http.routers.odoo_$ODOO_INSTANCE_NAME.rule=Host\(\`$ODOO_INSTANCE_NAME.localhost\`\)"
      - traefik.http.routers.odoo_$ODOO_INSTANCE_NAME.entrypoints=web
    restart: always" >> ~/sae-4b01-deploiement-odoo/config/docker-compose-odoo-traefik.yml