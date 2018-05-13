#!/bin/bash

##
#
# 命令: ./deploy.sh dev/pre/prod
# dev: 测试环境
# pre: 预发布环境
# prod: 生产环境
# module 目录有两级结构的,只需修改PROJECT_NAME={PROJECT_NAME}
# module 目录是一级结构的,需要修改PROJECT_NAME={PROJECT_NAME} 与 FILE_PATH=target 与 TOOLS_PATH=deploy/tools/bin
# SERVER_PORT 服务启动的端口

if [ ! -n "$1" ];then
    echo "please input ENV paramete like [dev] [pre] [prod].";
    exit
fi

APP_HOME=/var/local/www

PROJECT_NAME=hf_website

SRC_DIR=$(dirname "$0")
FILE_PATH=target
TOOLS_PATH=deploy/tools/bin
export FILE_NAME=${PROJECT_NAME}.jar
export DEST_DIR=${APP_HOME}/${PROJECT_NAME}
export ENV=$1
export SERVER_PORT=37800
export CONTEXT_PATH=

date=$(date +%Y%m%d%H%M)

server_address=140.143.206.247



echo "ENV is : " $1


function package {
    mvn clean package -U -DskipTests
}

function deploy {

            echo "backup jar on SERVER_LIST , ip [ ${server_address} ] !"
            ssh -T jenkins@${server_address} << EOF
                sudo -i
                mkdir -p ${DEST_DIR}/logs
                mkdir -p ${DEST_DIR}/bak
                chown -R jenkins:jenkins ${DEST_DIR}
                mv ${DEST_DIR}/${FILE_NAME} ${DEST_DIR}/bak/${FILE_NAME}.${date}

EOF
            echo "rsync jar to SERVER_LIST , ip [ ${SERVER_LIST[$i]} ] !"
            echo "rsync -vz ${FILE_PATH}/${FILE_NAME} jenkins@${SERVER_LIST[$i]}:${DEST_DIR}/${FILE_NAME}"
            scp ${FILE_PATH}/${FILE_NAME} jenkins@${SERVER_LIST[$i]}:${DEST_DIR}/${FILE_NAME}
            echo "TOOLS_PATH:" ${TOOLS_PATH}
            scp ${TOOLS_PATH}/start.sh ${TOOLS_PATH}/stop.sh ${TOOLS_PATH}/restart.sh jenkins@${SERVER_LIST[$i]}:${DEST_DIR}
            echo "restart ${PROJECT_NAME} service"
            ssh -T jenkins@${SERVER_LIST[$i]} << EOF
                sudo -i
                echo "stop ################################################"
                sh ${DEST_DIR}/stop.sh ${PROJECT_NAME}
                echo "start ################################################"
                sh ${DEST_DIR}/start.sh ${PROJECT_NAME} ${ENV}
EOF
            healthCheck

}

function healthCheck {
    HEALTH_CHECK_URL=http://${SERVER_LIST}:${SERVER_PORT}/${CONTEXT_PATH}/healthCheck
    for i in {1..20}; do
    STATUS_CODE=`curl -o /dev/null -s -w "%{http_code}" ${HEALTH_CHECK_URL}`
    if [ "$STATUS_CODE" = "200" ]; then
       echo "发布成功"
       exit 0
    fi
    echo "健康检查失败 [" ${i} "] 次:"${HEALTH_CHECK_URL}
    sleep 1
done;

echo "发布失败"
exit 1

}

function de {
    package
    deploy
}

echo "if before ${ENV}V"
if [ "${ENV}V" != "V" ]; then
    echo "enter if"
	de
fi