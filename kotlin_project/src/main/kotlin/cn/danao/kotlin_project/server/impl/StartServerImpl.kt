package cn.danao.kotlin_project.server.impl

import cn.danao.kotlin_project.server.StartServer
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service(value = "startServer")
class StartServerImpl : StartServer {
    var log = LoggerFactory.getLogger(this.javaClass);
    override fun getSum(a: Int, b: Int, c: String): String {
        /**
         *TODO("not implemented")”
         * 这句代码，这句代码在运行的时候会抛出以上异常，
         * 这样做的好处是促使我们去实现接口方法或者手动删掉这句代码。
         * 解决这个异常的方法就是删掉这行代码
         */
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        log.info("请求服务参数是 a = ${a}, b =  ${b},c = ${c}")
        return (a + b).toString()
    }

    override fun interfaceTest(): String {
        log.info("测试接口实现方法的实现")
        return super.interfaceTest()
    }

}