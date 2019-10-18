# 问题记录

- 注解不再主类的包下的问题

    我们都知道，SpringBoot主启动类标注了@SpringBootApplication注解，程序会自动扫描**主启动类所在包及其子包**(要求包必须是子包))


    但是在多模块项目开发中，有时候会遇到这样的需求：

    需要将公共模块的一个组件加入IOC容器，但是其所在包又不在默认扫描范围内

- 解决办法两个：

    方法1：将公共模块中的该组件放在默认扫描的包下（包名一样）

    方法2：使用@ComponentScan额外指定待扫描的包，但是不能用在主启动类上，因为这样会覆盖掉默认的包扫描规则，
    
    ```java
    /**
    * 配置springboot注解生效的包 多个包用,隔开
    */
    @SpringBootApplication(scanBasePackages = {"cn.danao"})
    ```

- springboot配置在不同环境下生效

    ```java
    @Configuration
    //只开启dev和test环境中的配置
    @Profile({"dev","test"})
    @EnableSwagger2
    public class SwaggerConfig {
      //配置代码略去
    }
    ```


- springboot 不同请求时的配置

    RequestMapping 注解中的说明
    value:  指定请求的实际地址， 比如 /action/info之类。
    method：  指定请求的method类型， GET、POST、PUT、DELETE等
    consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
    produces:    指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
    params： 指定request中必须包含某些参数值是，才让该方法处理
    headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求