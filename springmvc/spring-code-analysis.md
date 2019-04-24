# spring 源码分析

通过spring实战这本书的读书笔记

## ioc 容器


ApplicationContext 在 context模块下

继承自 EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,MessageSource, ApplicationEventPublisher, ResourcePatternResolver

[ApplicationContext 源码](https://github.com/spring-projects/spring-framework/blob/master/spring-context/src/main/java/org/springframework/context/ApplicationContext.java)

前面说的 ApplicationContext 其实就是一个 BeanFactory




## 初始化bean

## BeanFactory和FactoryBean

- spring-beans模块下

[BeanFactory源码 接口](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/factory/BeanFactory.java)

[FactoryBean 源码](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/factory/FactoryBean.java)