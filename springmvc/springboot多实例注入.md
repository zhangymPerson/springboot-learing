- 在需要多例调用的类上加@Scope("prototype")
- 在进行注入时，不能直接使用@Autowired，否则注入的还是单例，需要使用工厂，最简单的是用

        @Autowired
        private ObjectFactory<T> objectFactory;

    对象进行注入（T为你要注入的类），想要使用该多例对象时，用

        T t = objectFactory.getObject();
    方法。