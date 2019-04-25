spring 的配置文件

- spring application.xml demo
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context" 
	xmlns:jdbc="http://www.springframework.org/schema/jdbc"  
	xmlns:jee="http://www.springframework.org/schema/jee" 
	xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:aop="http://www.springframework.org/schema/aop" 
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:util="http://www.springframework.org/schema/util"
	xmlns:jpa="http://www.springframework.org/schema/data/jpa"
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd
		http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-4.1.xsd
		http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-4.1.xsd
		http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.1.xsd
		http://www.springframework.org/schema/data/jpa http://www.springframework.org/schema/data/jpa/spring-jpa-1.3.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.1.xsd
		http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.1.xsd
		http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.1.xsd">
	
	
	
	
	
	<!--   Spring框架的主配置文件：
	文件的命名为：ApplicationContext.xml或者Bean.xml,两种方式；
	位置一般在src目录下；
	在src目录下，可以直接读取配置文件的方式获取配置文件中注入的类型对象
	ApplicationContext ac = new ClassPathXmlApplicationContext("当前文件的路径信息");
	通过ac.getBean(参数1(String):bean的id或者name,参数2：类名.class(目标类的类信息));
	里面包含了Spring框架常用的配置内容和配置方法  -->
	
	
	
	
	
	<!--往容器添加baen对象的三种配置方式-->
	
	<!-- 1. bean标签的配置 ：
	id的属性是注入到Spring框架的类的别名，一般用类名全称首字母小写的方式，不允许使用特殊字符
	name的作用与id类似，但是可以使用特殊字符
	class属性是在Spring容器中存储的具体的对象类型
	这个配置默认是采用单例模式设置，即容器中一直存在一个对象，可以随时取用
	-->
	<bean id ="" class = ""></bean>
	<!--
	对象的自动装配

		我们可以在bean节点中, 添加autowire属性来完成自动装配的操作

		属性取值范围: 
	
		-	no : 默认设置 , 表示关闭自动装配
		-	byName : 通过名称完成自动装配: 
				例如: 当前我们容器中存在一个对象, id为book;
					而刚好当前的这个person类中有一个名称为book的属性	
					那么这个时候, 我们的容器, 会自动完成两个对象的关联	
					byName 不会判断传入的参数类型是否匹配, 只要名称相同, 就会强行建立依赖关系 , 导致报错!		
	
	 	-	byType : 通过类型完成自动装配
	 	
	 			例如: 当前我们容器中存在一个Book类的对象
	 				而刚好我们当前的Person有一个Book类型的属性
	 				我们的容器, 就会自动完成两个对象的关联


		-	constructor	与byType的方式类似，不同之处在于它应用于构造器参数
		-	autodetect	通过bean类来决定是使用constructor还是byType方式进行自动装配。如果发现默认的构造器，那么将使用byType方式
	-->
	
	
	
	
	<!-- 2. 通过静态工厂方法注入对象
		其中class为静态工厂类全称，由程序员自己编写；
		工厂方法为要获取的对象类型
	-->
	
	<bean id="key" class="工厂类的类信息" factory-method="getXXXX"></bean>
	
	
	
	
	
	
	<!--  3.通过实例化工厂获取对象	 
		1.先配置实例化工厂类
			
		2.再通过bean节点, 配置新的对象
          指定具体对象的id
		  指定factory-bean属性(工厂对象的id属性)
		  指定factory-method属性(工厂对象中的工厂方法名)

	-->
	<bean id="xxxFactory" class="工厂类的类信息" ></bean>
	<bean id="key" factory-bean="xxxFactory" factory-method="getXXX"></bean>
	
	
	
	
	
	
	<!-- 
	base-package : 指定要扫描的基本包
	
	例如: 我当前的项目包结构如下
	-	src
		-	cn
			-	xdl
				-	util
					-	HttpUtil
					-	StringUtil
					-	JDBCUtil
				-	dao
					-	UserDao
					-	GoodsDao
				-	bean
					-	XX
					
		那么我们可以通过指定cn.xdl.util 来扫描util包 
			或者通过指定cn 来扫描所有的包中的所有注解
			
		扫描的开启配置context:component-scan标签 
		属性：base-package:表示可以通过注解将类扫描到Spring的容器的包	

		注解类型：
		1.@Component 通用型注解
		2.@@Repository 持久化层组件通用注解
		3.@Service 业务层组件的注解
		4.@Controller 控制层组件的注解
		5.@Resource 处理setXXX()注入的注解
	 -->
	<context:component-scan base-package="cn.xdl.bean2"></context:component-scan>

	
	
	
	
	<!--
	<bean id="bookheheda" class="cn.xdl.demo1.HeHeDa"></bean>-->
	<!-- 
		byName : 通过名称完成自动装配: 
			例如: 当前我们容器中存在一个对象, id为book;
				而刚好当前的这个person类中有一个名称为book的属性	
				那么这个时候, 我们的容器, 会自动完成两个对象的关联	
				byName 不会判断传入的参数类型是否匹配, 只要名称相同, 就会强行建立依赖关系 , 导致报错!		
	
	-->
	<!-- 
	 	byType : 通过类型完成自动装配
	 	
	 		例如: 当前我们容器中存在一个Book类的对象
	 			而刚好我们当前的Person有一个Book类型的属性
	 			我们的容器, 就会自动完成两个对象的关联
	-->
	<bean id="person" class="cn.xdl.demo1.Person" autowire="byType">
	</bean>
	
	
	
	
	
	<bean id="" class="">
		<!-- 
			property:  通过set方法, 设置一个属性的值 
			name属性: 表示的是 当前类中的属性的名称
			value属性: 表示的是, 本次注入的值
			property: 通过set方法 设置属性
			通过连接 关联两个对象 ,让对象与对象之间产生一个依赖关系 !
			ref属性: 要引入的容器中对象的id  
		    <property name="book" ref="（要注入别的类信息时，用引用ref=""）bookheheda"></property>  
			    通过连接 关联两个对象 
				注意: 要关联的对象, 必须已经存在容器中
		-->
		<property name="类的成员变量名" value=""></property>
		<property name="" value=""></property>
		<constructor-arg name="book" ref="bookheheda"></constructor-arg>
	</bean>
		
		
		
		
	<bean id="" class="">
	<!-- 通过构造方法注入参数  
		 name属性:  这是一个容易混淆的地方 , 它指的其实是构造方法中形式参数列表中参数的名称
	     index代表的是参数的位置  在构造方法中的位置，位置从0开始  
	-->
		<constructor-arg index="0" value=""> </constructor-arg>
		<constructor-arg index="1" value=""></constructor-arg>
		<constructor-arg index="2" ref="bookheheda"></constructor-arg>
	
		<constructor-arg name="age" value="188"></constructor-arg> -->
	</bean>
	
	
	
	<!--
			注解方式

			开启组件扫描，可以利用注解方式应用IOC。使用步骤如下：

			1.	在applicationContext.xml中添加启用标记
					<context:component-scan base-package=“包路径”/>

			2.	在组件类中追加以下标记
				@Component	通用注解
				@Repository	持久化层组件注解
				@Service	业务层组件注解
				@Controller	控制层组件注解

			3.	正常创建容器对象, getBean即可获得对象

			
		----

			注解标记使用案例:

				1.	@Controller
					class Person{
					
					}
					此案例下, 容器中的Person对象的id为类名,首字母小写!
				2.	@Controller("person2")
					class Person{

					}
					此案例下, 容器中的Person对象的id为指定的idperson2

		Scope

			通过注解也可以指定scope
				@component(“person”)
				@Scope(“prototype”)


			如果指定多例 , 那么生命周期不再由容器所控制 ,而是由程序员的代码来控制 !

			多例情况下, 销毁方法的指定是无效果的!

		初始化与销毁方法

			@PostConstruct 
			此注解添加到方法上, 可以将方法设置为初始化回调方法
			@PreDestroy 
			此注解添加到方法上, 可以将方法设置为销毁回调方法

		通过@Value 注入String以及基本数据类型值

			案例:
				
				通过表达式
				@Value("#{book.name}")
				private String uname ;
				普通方式
				@Value("123456")
				private String upass ;

		指定依赖关系

			@Autowired/@Qualifier
			可以处理构造器注入和Setter注入

			@Resource
			只能处理Setter注入，但大部分情况都是Setter注入


		---


			通过@Resource 建立依赖关系的流程

				 *	1.	先默认使用byName方式 , 去容器查找是否存在对应的对象 ,如果存在则赋值
				 *	2.	如果上面没有查询到, 再 根据byType, 进行容器的查询,如果存在则赋值
				 *  3. 	如果上面两种方式 均未查到 ,则不赋值

	-->
	
	
	

	
	
	<!--   不太常用的配置内容集合的注入 -->
	
	<!-- 
			与bean节点一致, 都是向容器中添加对象, 不过这添加的是一个set集合，Map集合，以及注入集合的办法
	 -->
	<util:set id="setObject">
			<value>大卫</value>
			<value>俭娃</value>
			<value>杨策</value>
			<value>炙豪</value>
			<value>刘阳</value>
			<value>燕明</value>
	</util:set>
	<util:list id="setObject">
			<value>大卫</value>
			<value>俭娃</value>
			<value>杨策</value>
			<value>炙豪</value>
			<value>刘阳</value>
			<value>燕明</value>
	</util:list>
	<util:map>
		<entry key="" value=""></entry>
	</util:map>
	<util:properties>
		<prop key="">value</prop>
	</util:properties>
	
	
	<bean id="mingDa" class="cn.xdl.demo2.MingDa">
		<property name="name" value="明达"></property>
		<property name="age" value="79"></property>
		<property name="jiyous" ref="setObject"></property>
	</bean>
	
	<bean id="mingDa2" class="cn.xdl.demo2.MingDa2">
		<property name="name" value="明达"></property>
		<property name="age" value="79"></property>
		<property name="jiyous">
			<map>
				<entry key="大卫" value="18"></entry>
				<entry key="杨策" value="8"></entry>
				<entry key="燕明" value="28"></entry>
				<entry key="炙豪" value="6"></entry>
				<entry key="俭娃" value="0"></entry>
			</map>
		</property>
	</bean>
	<bean id="mingDa3" class="cn.xdl.demo2.MingDa3">
		<property name="name" value="明达"></property>
		<property name="age" value="79"></property>
		<property name="props">
			<props>
				<prop key="大卫">18</prop>
				<prop key="燕明">2</prop>
				<prop key="炙豪">1</prop>
				<prop key="俭娃">1</prop>
			</props>
		</property>
	</bean>
	
	
	
	
</beans>
```