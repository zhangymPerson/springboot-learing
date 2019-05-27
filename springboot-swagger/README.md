# spring boot 整合swagger


- 引入jar包

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${version.swagger}</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>${version.swagger}</version>
        </dependency>

- 添加注解

    入口类 ： @EnableSwagger2
    
    Controller ：@Api("测试")
    
    请求方法：@ApiOperation("测试接口")

- 请求

        #请求页面
        http://localhost:port/swagger-ui.html
       
- swagger的常用注解

    @ApiOperation：用在方法上，说明方法的作用
    
        value: 表示接口名称
        notes: 表示接口详细描述 
    @ApiImplicitParams：用在方法上包含一组参数说明
    
    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
    
    paramType：参数位置
    header 对应注解：@RequestHeader
    query 对应注解：@RequestParam
    path  对应注解: @PathVariable
    body 对应注解: @RequestBody
    name：参数名
    dataType：参数类型
    required：参数是否必须传
    value：参数的描述
    defaultValue：参数的默认值
    @ApiResponses：用于表示一组响应
    
    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
    
    code：状态码
    message：返回自定义信息
    response：抛出异常的类
    @ApiIgnore: 表示该接口函数不对swagger2开放展示