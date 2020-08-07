# springboot 整合 log 日志文件

## 要配置 logback-spring.xml，

- spring boot 会默认加载此文件，为什么不配置 logback.xml,

  因为 logback.xml 会先 application.properties 加载，而 logback-spring.xml 会后于 application.properties 加载，这样我们在 application.properties 文中设置日志文件名称和文件路径才能生效。

- 项目中指定 logback.xml

  在 application.properties 中
  添加 `logging.config=classpath:logback-spring.xml` 指定日志配置文件

  如果指定了配置文件，则该文件必须存在，否则启动报错

  如果没有配置该文件，则默认使用 springboot 自带的配置启动项目

## 可以创建一个空的配置，

- 项目可以正常启动，无任何打印信息
- 空配置如下
  ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <configuration scan="true" scanPeriod="10 seconds">
    </configuration>
  ```

## 配置文件 logback.xml 说明

- 配置节点

  根节点 configuration 三个子节点

  ```mermaid
  graph LR;
  configuration-->appender;
  configuration-->root;
  configuration-->logger;
  ```

- 配置日志文件输出位置

  在 logback-spring.xml 配置文件中配置输出位置

    <!-- name的值是变量的名称，value的值时变量定义的值。通过定义的值会被插入到logger上下文中。定义变量后，可以使“${}”来使用变量。 -->
    <property name="logging.path" value="C:/Users/zhang/Desktop" />

    <!--配置从 application.properties 中读取日志文件位置 -->
    <springProperty scope="context" name="logging.path" source="logging.path"/>

* 新增全局异常处理类

  cn.danao.aop.GlobalExceptionHandler

### springboot 参数校验

- JSR 提供的校验注解：

  @AssertFalse 被注释的元素只能为 false
  @AssertTrue 被注释的元素只能为 true
  @DecimalMax 被注释的元素必须小于或等于{value}
  @DecimalMin 被注释的元素必须大于或等于{value}
  @Digits 被注释的元素数字的值超出了允许范围(只允许在{integer}位整数和{fraction}位小数范围内)
  @Email 被注释的元素不是一个合法的电子邮件地址
  @Future 被注释的元素需要是一个将来的时间
  @FutureOrPresent 被注释的元素需要是一个将来或现在的时间
  @Max 被注释的元素最大不能超过{value}
  @Min 被注释的元素最小不能小于{value}
  @Negative 被注释的元素必须是负数
  @NegativeOrZero 被注释的元素必须是负数或零
  @NotBlank 被注释的元素不能为空
  @NotEmpty 被注释的元素不能为空
  @NotNull 被注释的元素不能为 null
  @Null 被注释的元素必须为 null
  @Past 被注释的元素需要是一个过去的时间
  @PastOrPresent 被注释的元素需要是一个过去或现在的时间
  @Pattern 被注释的元素需要匹配正则表达式"{regexp}"
  @Positive 被注释的元素必须是正数
  @PositiveOrZero 被注释的元素必须是正数或零
  @Size 被注释的元素个数必须在{min}和{max}之间

  Hibernate Validator 提供的校验注解：
  @CreditCardNumber 被注释的元素不合法的信用卡号码
  @Currency 被注释的元素不合法的货币 (必须是{value}其中之一)
  @EAN 被注释的元素不合法的{type}条形码
  @Email 被注释的元素不是一个合法的电子邮件地址 (已过期)
  @Length 被注释的元素长度需要在{min}和{max}之间
  @CodePointLength 被注释的元素长度需要在{min}和{max}之间
  @LuhnCheck 被注释的元素${validatedValue}的校验码不合法, Luhn模10校验和不匹配
  @Mod10Check             被注释的元素${validatedValue}的校验码不合法, 模 10 校验和不匹配
  @Mod11Check 被注释的元素${validatedValue}的校验码不合法, 模11校验和不匹配
  @ModCheck               被注释的元素${validatedValue}的校验码不合法, ${modType}校验和不匹配  (已过期)
  @NotBlank               被注释的元素不能为空  (已过期)
  @NotEmpty               被注释的元素不能为空  (已过期)
  @ParametersScriptAssert 被注释的元素执行脚本表达式"{script}"没有返回期望结果
  @Range                  被注释的元素需要在{min}和{max}之间
  @SafeHtml               被注释的元素可能有不安全的HTML内容
  @ScriptAssert           被注释的元素执行脚本表达式"{script}"没有返回期望结果
  @URL                    被注释的元素需要是一个合法的URL
  @DurationMax            被注释的元素必须小于${inclusive == true ? '或等于' : ''}${days == 0 ? '' : days += '天'}${hours == 0 ? '' : hours += '小时'}${minutes == 0 ? '' : minutes += '分钟'}${seconds == 0 ? '' : seconds += '秒'}${millis == 0 ? '' : millis += '毫秒'}${nanos == 0 ? '' : nanos += '纳秒'}
  @DurationMin 被注释的元素必须大于${inclusive == true ? '或等于' : ''}${days == 0 ? '' : days += '天'}${hours == 0 ? '' : hours += '小时'}${minutes == 0 ? '' : minutes += '分钟'}${seconds == 0 ? '' : seconds += '秒'}${millis == 0 ? '' : millis += '毫秒'}\${nanos == 0 ? '' : nanos += '纳秒'}

- 在 logback-spring.xml 配置文件中配置输出位置

  ```xml
  <!-- name的值是变量的名称，value的值时变量定义的值。通过定义的值会被插入到logger上下文中。定义变量后，可以使“${}”来使用变量。 -->
  <property name="logging.path" value="C:/Users/zhang/Desktop" />

  <!--配置从 application.properties 中读取日志文件位置 -->
  <springProperty scope="context" name="logging.path" source="logging.path"/>
  ```

* 新增全局异常处理类

  cn.danao.aop.GlobalExceptionHandler

* 测试 nacos 配置

  参考项目 - https://github.com/nacos-group/nacos-examples
