# 使用java代码进行mybatis逆向工程

- [官方文档](http://www.mybatis.org/generator/index.html)

- 依赖两个jar包

    mybatis-generator-core包
    
    mysql-connector-java包
    
    然后运行代码
    
- 直接下载两个jar 包

    然后创建  generatorConfig.xml 文件
    
    将上面三个东西一起放到项目的特定位置 
    
    此样例是将三个东西一起放到了和项目src同级目录
    
    如果是其他目录也可以，但是需要改动generatorConfig配置文件的相关配置
    
    执行 java -jar mybatis-generator-core-5.1.38.jar -configfile generatorConfig.xml -overwrite
    
    即可逆向生成各种文件