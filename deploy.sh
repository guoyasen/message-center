#!/bin/bash

# 基础配置
mysql_address="jdbc:oracle:thin:@192.168.40.245:1521:fgfk"
mysql_user=fkadmin
mysql_password=fullgoal123

# tsp
tsp_port=7011
# 容器内日志
logging_file=/log/tsp-web.log
# 挂载目录
log_v=/root/log

# phoenix
mq_address=192.168.41.58:9876
cmd_topic=command_topic
event_topic=event_topic

# 启动
function start_tsp_web() {
  echo "1. kill old container"
  docker ps | grep tsp-web | awk '{print $1}' | xargs -i docker kill {}
  docker ps -a | grep tsp-web | awk '{print $1}' | xargs -i docker rm {}

  echo "2. start new container"
  docker pull 192.168.41.41:5000/fullgoal-tsp/tsp-web:master
  
  echo "3. start new container"
  docker run -dti \
  --privileged=true \
  -e TZ=Asia/Shanghai \
  -e server.port=80 \
  -e logging.file=$logging_file \
  -e spring.datasource.url=$mysql_address \
  -e spring.datasource.username=$mysql_user \
  -e spring.datasource.password=$mysql_password \
  -e spring.rocketmp.nameServer=$mp_address \
  -e quantex.phoenix.mq.address=$mq_address \
  -e quantex.phoenix.client.cmd-topic=$cmd_topic \
  -e quantex.phoenix.client.event-topic=$event_topic \
  -e quantex.phoenix.client.rpc-topic=rpc_topic \
  -p $tsp_port:80 \
  -v $log_v:/log \
  192.168.41.41:5000/fullgoal-tsp/tsp-web:master 
}
start_tsp_web
