package cn.danao.springBaseTest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringBoot

fun main(args: Array<String>) {
    //Class<?> 在kotlin中 ClassName::class.java
    //可变参数在kotlin中不能直接传数组，需要传入 *arrayName 这种方式
    var run = SpringApplication.run(KotlinSpringBoot::class.java, *args)
    var bean = run.getBean("person")
    print(bean)
}