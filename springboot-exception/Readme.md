# springboot的全局异常处理

- spring 的异常处理体系

- spring 空白页的处理

    Whitelabel Error Page 

- 解决办法

    1.如AppController那样，定义没有路径的请求接收所有请求 如果不存在 则会返回相应的请求方式中的内容
    
    2.自定义错误路径 且 自己实现错误的内容或者指向自定义的路径
    
    3.两者同时存在，则优先匹配第一种

