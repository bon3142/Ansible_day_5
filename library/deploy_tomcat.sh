#! /bin/bash

[ -f "$1" ] && source $1
#Download artifact from Nexus
mkdir /tempory/version_new
cd /tempory/version_new
wget  http://nexus-ci.playpit.by/repository/MNT-pipeline-training/ydzmitryieu/pipeline-ydzmitryieu/58/pipeline-ydzmitryieu-58.tar.gz
    

#untar artifact
tar -xzf pipeline-ydzmitryieu-58.tar.gz -C /tempory/version_new
  
#Deploying artifact

curl -T 'helloworld-ws/target/helloworld-ws.war' 'http://tomcat:tomcat@192.168.56.5/manager/text/deploy?path=/helloworld-ws-ydzmitryieu&update=true'
