#!/bin/bash

function logs() {
    date=$(date +'%Y-%m-%d %H:%M:%S')
    echo "${date}" $*
}

# 打印日志 调用方式 log info
function log() {
    logs INFO $*
}

stop() {
    PID=$(ps -ef | grep $1 | grep -v grep | awk '{ print $2 }')
    if [ -z "$PID" ]; then
        log Application is already stopped
    else
        log Application stoping... 
        echo kill $PID
        kill $PID
        log Application stop success
    fi
}

start() {
    java -jar $1
}

# 编辑测试代码
# 输出日志
if [ $# -eq 1 ]; then
    jarName=$1
    log "启动的jar包是:" ${jarName}
    stop ${jarName}
    start ${jarName}
    exit 1
else
    logs ERROR "需要输入要启动的jar包"
    exit 1
fi
