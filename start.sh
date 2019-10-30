#!/usr/bin/env bash

project_name=in-boot-jframework

server_name=in-boot-server

home_path=/Users/cuiyongxu/workspace/ijson

bash_path=$home_path/$project_name

cd $bash_path

git pull

cd $bash_path/in-proxy-common
mvn clean install -Dmaven.test.skip=true

cd $bash_path/in-proxy-core
mvn clean install -Dmaven.test.skip=true

cd $bash_path/in-proxy-server

pid=$(ps -ef | grep "in-proxy-server" | grep -v grep | awk '{print $2}')

echo "current in-proxy-server pid:" $pid

kill -9 $pid

DATE=$(date +%Y%m%d%H%M%S)
cd $bash_path/in-proxy-server
mv $bash_path/in-proxy-server/nohup.out /home/liyaping/in-proxy-server-log/$DATE.log

cd $bash_path/in-proxy-server/
nohup mvn spring-boot:run >> nohup.out 2>&1 &