# spring代码分析学习

## spring 官方的github地址

   [地址](https://github.com/spring-projects)

# spring各个包的区别

- 如下图所示

    ![spring-model图示](https://github.com/zhangymPerson/learning-notes/blob/master/Picture/Spring%E6%A8%A1%E5%9D%97%E8%AF%B4%E6%98%8E.png)

## [spring-aop](https://github.com/spring-projects/spring-framework/tree/master/spring-aop)

- Spring的面向切面编程,提供AOP(面向切面编程)实现

## [spring-aspects](https://github.com/spring-projects/spring-framework/tree/master/spring-aspects)

- Spring提供对AspectJ框架的整合

## [spring-beans](https://github.com/spring-projects/spring-framework/tree/master/spring-beans)

- SpringIoC(依赖注入)的基础实现
- Spring IOC的基础实现，包含访问配置文件、创建和管理bean等。

## [spring-context](https://github.com/spring-projects/spring-framework/blob/master/spring-context)

- 这个jar文件为Spring核心提供了大量扩展。可以找到使用Spring ApplicationContext特性时所需的全部类，JDNI所需的全部类，UI方面的用来与模板（Templating）引擎如Velocity、FreeMarker、JasperReports集成的类，以及校验Validation方面的相关类。

## [spring-core](https://github.com/spring-projects/spring-framework/tree/master/spring-core)

- 这个jar文件包含Spring框架基本的核心工具类，Spring其它组件要都要使用到这个包里的类，是其它组件的基本核心，当然你也可以在自己的应用系统中使用这些工具类。