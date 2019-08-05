#!/bin/bash

function logs() {
    date=$(date +'%Y-%m-%d %H:%M:%S')
    echo "${date}" $*
}

# 打印日志 调用方式 log info
function log() {
    logs INFO $*
}

# 启动
start() {
    nohup java -jar $1 &
    log start success
}

# 编辑测试代码
# 输出日志
if [ $# -eq 1 ]; then
    log "启动的jar包是:" ${jarName}
    start ${jarName}
    exit 1
else
    logs ERROR "需要输入要启动的jar包"
    exit 1
fi
