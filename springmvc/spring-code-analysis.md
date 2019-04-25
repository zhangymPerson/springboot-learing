# spring 源码分析

通过spring实战这本书的读书笔记

## ioc 容器


ApplicationContext 在 context模块下

继承自 EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,MessageSource, ApplicationEventPublisher, ResourcePatternResolver

[ApplicationContext 源码](https://github.com/spring-projects/spring-framework/blob/master/spring-context/src/main/java/org/springframework/context/ApplicationContext.java)


- springcontext的jar包依赖关系

    ![springjar包依赖关系](https://github.com/zhangymPerson/springboot-learing/blob/master/picture/Spring-context%E4%BE%9D%E8%B5%96%E5%85%B3%E7%B3%BB.png)



前面说的 ApplicationContext 其实就是一个 BeanFactory


- FileSystemXmlApplicationContext 的构造函数需要一个 xml 配置文件在系统中的路径，其他和 ClassPathXmlApplicationContext 基本上一样。

- AnnotationConfigApplicationContext 是基于注解来使用的，它不需要配置文件，采用 java 配置类和各种注解来配置，是比较简单的方式，也是大势所趋吧。



## 初始化bean

## BeanFactory和FactoryBean

- spring-beans模块下

[BeanFactory源码 接口](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/factory/BeanFactory.java)

[FactoryBean 源码](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/factory/FactoryBean.java)