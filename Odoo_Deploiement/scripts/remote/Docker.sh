#!/bin/bash

SCRIPT_NAME=$(echo $0 | rev | cut -d "/" -f 1 | rev)

echo "& $SCRIPT_NAME Execution..."

echo '{
  "registry-mirrors": ["http://172.18.48.9:5000"],
  "default-address-pools":
  [
    {"base":"172.20.0.0/16","size":24}
  ]
}' > /etc/docker/daemon.json