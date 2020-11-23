package cn.danao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhang
 * @version 1.0
 * 1.mybatis扫描的注解  @MapperScan 指定要扫描的Mapper接口包 和 Mapper类
 * @since 1.0
 */
@SpringBootApplication
@PropertySource(value = {"classpath:db.properties"})
@MapperScan(basePackages = {"cn.danao.dao", "cn.danao.generator.dao"})
public class Applicattion {
    public static void main(String[] args) {
        SpringApplication.run(Applicattion.class);
    }
}
