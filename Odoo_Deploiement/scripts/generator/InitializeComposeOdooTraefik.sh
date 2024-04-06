#!/bin/bash

echo "version: '3'

services:

  traefik:
    image: traefik:v2.11
    container_name: traefik
    command:
      - --api.insecure=true
      - --providers.docker=true
      - --providers.docker.exposedbydefault=false
      - --entrypoints.web.address=:80
    ports:
      - 80:80
      - 8080:8080
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock:ro" > ~/sae-4b01-deploiement-odoo/config/docker-compose-odoo-traefik.yml