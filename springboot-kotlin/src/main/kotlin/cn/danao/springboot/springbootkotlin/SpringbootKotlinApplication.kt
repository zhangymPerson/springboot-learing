package cn.danao.springboot.springbootkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@PropertySource(value = ["classpath:/env.properties", "classpath:/db.properties"])
@SpringBootApplication
class SpringbootKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringbootKotlinApplication>(*args)
}
