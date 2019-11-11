package cn.danao.kotlin_project.server


interface StartServer {
    /**
     * 获取两数之和
     */
    fun getSum(a: Int, b: Int, c: String = "默认值"): String

    /**
     * 接口默认实现
     */
    fun interfaceTest(): String {
        return "接口测试"
    }
}