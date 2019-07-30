# springboot 使用及开发中问题记录

## 添加maven配置

    pom.xml

## 编写启动类

    cn.danao.ApplicationDaNao
- 注意:

    使用注解

    启动方法为主方法

## 编写测试类

    cn.danao.controller.HelloController
- 注意：

    使用注解

 - springboot参数接收注解
 
    GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。
 
    在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个。
 
    简言之:
 
    一个请求  >> 只有一个@RequestBody；
 
    一个请求 >> 可以有多个@RequestParam。
    
    同时使用@RequestParam（）和@RequestBody
    
    @RequestParam( )指定的参数可以是普通元素、数组、集合、对象等等
    (即: @RequestBody 与@RequestParam()可以同时使用时，原SpringMVC接收参数的机制不变，
    
    只不过RequestBody 接收的是请求体里面的数据(get是默认的请求体，post是提交表单需要的请求体)；
    
    而RequestParam接收的是key-value里面的参数，所以它会被切面进行处理从而可以用普通元素、数组、集合、对象等接收)。  
