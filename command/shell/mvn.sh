#!/usr/bin/bash
#######################################
#脚本demo
#如果报错使用 which bash 修改上面路径
#######################################

# 调用方式 logs level级别(全部大写) 日志信息
# 函数调用会自动切割参数 如 logs "a b c" 会分割成 3个参数传进来  logs a b c  所以需要使用 $* 来打印所有参数
function logs(){
	date=$(date +'%Y-%m-%d %H:%M:%S')
	echo "${date}" $*
}


# 打印日志 调用方式 log info 
function log(){
	logs INFO $*
}


cmd(){
    #判断命令是否存在
    commandName=$1
    
    which ${commandName} > /dev/null
    if [ $? -eq 0 ]
    then
        log ${commandName} "存在"
    else
        log ${commandName} "不存在，请先安装maven"
        exit 1
    fi
}

mvnRum(){
    if [[ $1 -eq 1 ]]; 
    then
        log "1"
        mvn clear
    elif  [[ $1 -eq 2 ]];
    then
        log "2"
        mvn package
    elif [[ $1 -eq 3 ]];
    then
        log "3"
        mvn test
    else
        mvn help
    fi
}

# 编辑测试代码
# 输出日志
if [ $# -eq 1 ]; then
	cmd "mvn"
	log "第一个参数是:" $1
    mvnRum $1
	exit 1
else
	logs ERROR "脚本需要一个参数"
	logs ERROR "1 清理 2 打包 3 测试"
	exit 1
fi


