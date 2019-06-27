# 自定义注解

- 注解的定义

    注解通过 @interface 关键字进行定义。

    ```java
        public @interface TestAnnotation {
        }
    ```
    
## 元注解

- 元注解是什么意思呢？

    元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其它的注解上面。

    如果难于理解的话，你可以这样理解。元注解也是一张标签，但是它是一张特殊的标签，它的作用和目的就是给其他普通的标签进行解释说明的。

    元标签有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。
    
- @Retention
 
    Retention 的英文意为保留期的意思。当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。
    它的取值如下： 
    
        - RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。 
        - RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。 
        - RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。 
- @Documented

    顾名思义，这个元注解肯定是和文档有关。它的作用是能够将注解中的元素包含到 Javadoc 中去。

- @Target

    Target 是目标的意思，@Target 指定了注解运用的地方。

    你可以这样理解，当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。

    类比到标签，原本标签是你想张贴到哪个地方就到哪个地方，但是因为 @Target 的存在，它张贴的地方就非常具体了，比如只能张贴到方法上、类上、方法参数上等等。@Target 有下面的取值

        ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
        ElementType.CONSTRUCTOR 可以给构造方法进行注解
        ElementType.FIELD 可以给属性进行注解
        ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
        ElementType.METHOD 可以给方法进行注解
        ElementType.PACKAGE 可以给一个包进行注解
        ElementType.PARAMETER 可以给一个方法内的参数进行注解
        ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举


- @Inherited

    Inherited 是继承的意思，但是它并不是说注解本身可以继承，而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。 

- @Repeatable

    Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。

    什么样的注解会多次应用呢？通常是注解的值可以同时取多个。


### 自定义注解类的方式

- demo类
    ```java
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface TestNote {

        /**
         * 说明
         * 成员类型受限
         *
         * 基本类型 和 String
         *只有一个成员，则成员必须命名为 value
         *
         * 没有成员的注解是标识
         */

        /**
         * 成员定义无参无异常定义
         * @return
         */
        String test() default "test";

        /**
         * 注解中的参数可以设置默认值
         * @return
         */
        //int num() default 20;

    }

    ```
    
 # AOP使用
 
 - 常用概念
 
    Aspect（切面）： Aspect 声明类似于 Java 中的类声明，在 Aspect 中会包含着一些 Pointcut 以及相应的 Adv
    Joint point（连接点）：表示在程序中明确定义的点，典型的包括方法调用，对类成员的访问以及异常处理程序块的执行等等，它自身还可以嵌套其它 joint point。
    Pointcut（切点）：表示一组 joint point，这些 joint point 或是通过逻辑关系组合起来，或是通过通配、正则表达式等方式集中起来，它定义了相应的 Advice 将要发生的地方    
    Advice（增强）：Advice 定义了在 Pointcut 里面定义的程序点具体要做的操作，它通过 before、after 和 around 来区别是在每个 joint point 之前、之后还是代替执行的代码。
    Target（目标对象）：织入 Advice 的目标对象.。
    Weaving（织入）：将 Aspect 和其他对象连接起来, 并创建 Adviced object 的过程
 
- 注解

    @Aspect(切面): 通常是一个类，里面可以定义切入点和通知JointPoint(连接点):  程序执行过程中明确的点，一般是方法的调用Advice(通知):  AOP在特定的切入点上执行的增强处理:
    @Before:  标识一个前置增强方法，相当于BeforeAdvice的功能
    @After:  final增强，不管是抛出异常或者正常退出都会执行。
    @AfterReturning:  后置增强，似于AfterReturningAdvice, 方法正常退出时执行
    @AfterThrowing:  异常抛出增强，相当于ThrowsAdvice
    @Around: 环绕增强，相当于MethodInterceptor
    @Pointcut(切入点):   带有通知的连接点，在程序中主要体现为书写切入点表达式
    
