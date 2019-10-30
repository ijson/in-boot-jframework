#!/usr/bin/env bash

PRO_HOME_PATH=/Users/cuiyongxu/workspace/ijson/in-boot-jframework
PRO_SERVER__PREFIX_NAME=in-boot

cd $PRO_HOME_PATH

git pull

cd $PRO_HOME_PATH/$PRO_SERVER__PREFIX_NAME-common
mvn clean install -Dmaven.test.skip=true

cd $PRO_HOME_PATH/$PRO_SERVER__PREFIX_NAME-remote
mvn clean install -Dmaven.test.skip=true

cd $PRO_HOME_PATH/$PRO_SERVER__PREFIX_NAME-core
mvn clean install -Dmaven.test.skip=true

cd $PRO_HOME_PATH/$PRO_SERVER__PREFIX_NAME-server

PID=$(ps -ef | grep "$PRO_SERVER__PREFIX_NAME-server" | grep -v grep | awk '{print $2}')

echo "current project $PRO_SERVER__PREFIX_NAME-server pid : " $PID

kill -9 $PID

cd $PRO_HOME_PATH

FATHER_PATH=$(dirname $(pwd))

echo "当前父类路径:"$FATHER_PATH
CREATE_PATH=$FATHER_PATH/$PRO_SERVER__PREFIX_NAME-server-log
echo "创建目录:"$CREATE_PATH


if [ ! -d $CREATE_PATH ];then
mkdir $CREATE_PATH
else
echo $CREATE_PATH"文件夹已经存在"
fi


DATE=$(date +%Y%m%d%H%M%S)-$PRO_SERVER__PREFIX_NAME-server
cd $PRO_HOME_PATH/$PRO_SERVER__PREFIX_NAME-server
mv $PRO_HOME_PATH/$PRO_SERVER__PREFIX_NAME-server/server.log $CREATE_PATH/$DATE.log

cd $PRO_HOME_PATH/$PRO_SERVER__PREFIX_NAME-server
nohup mvn spring-boot:run >> server.log 2>&1 &