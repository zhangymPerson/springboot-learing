# spring 源码分析

通过spring实战这本书的读书笔记

## ioc 容器


ApplicationContext 在 context模块下

继承自 EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,MessageSource, ApplicationEventPublisher, ResourcePatternResolver

[ApplicationContext 源码](https://github.com/spring-projects/spring-framework/blob/master/spring-context/src/main/java/org/springframework/context/ApplicationContext.java)


- springcontext的jar包依赖关系

    ![springjar包依赖关系](https://github.com/zhangymPerson/springboot-learing/blob/master/picture/Spring-context%E4%BE%9D%E8%B5%96%E5%85%B3%E7%B3%BB.png)



前面说的 ApplicationContext 其实就是一个 BeanFactory




## 初始化bean

## BeanFactory和FactoryBean

- spring-beans模块下

[BeanFactory源码 接口](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/factory/BeanFactory.java)

[FactoryBean 源码](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/factory/FactoryBean.java)