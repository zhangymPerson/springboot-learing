# mybatis 逆向工程


- 直接使用maven插件生成

    [官方说明文档](http://www.mybatis.org/generator/index.html)
    
- maven 的pom.xml文件

    pom.xml 文件
    
    ```xml
       <project ...>
         ...
         <build>
           ...
           <plugins>
            ...
            <plugin>
              <groupId>org.mybatis.generator</groupId>
              <artifactId>mybatis-generator-maven-plugin</artifactId>
              <version>1.3.7</version>
            </plugin>
            ...
          </plugins>
          ...
        </build>
        ...
      </project>
    
    ```
    插件运行命令
    ```
    #mvn插件使用 逆向工程插件
    mvn mybatis-generator:generate
    
    #  命令2
    mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
    ```
    
- 配置文件

    generatorConfig.xml 官方demo
	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE generatorConfiguration
	  PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
	  "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
	
	<generatorConfiguration>
	  <classPathEntry location="/Program Files/IBM/SQLLIB/java/db2java.zip" />
	
	  <context id="DB2Tables" targetRuntime="MyBatis3">
	    <jdbcConnection driverClass="COM.ibm.db2.jdbc.app.DB2Driver"
	        connectionURL="jdbc:db2:TEST"
	        userId="db2admin"
	        password="db2admin">
	    </jdbcConnection>
	
	    <javaTypeResolver >
	      <property name="forceBigDecimals" value="false" />
	    </javaTypeResolver>
	
	    <javaModelGenerator targetPackage="test.model" targetProject="\MBGTestProject\src">
	      <property name="enableSubPackages" value="true" />
	      <property name="trimStrings" value="true" />
	    </javaModelGenerator>
	
	    <sqlMapGenerator targetPackage="test.xml"  targetProject="\MBGTestProject\src">
	      <property name="enableSubPackages" value="true" />
	    </sqlMapGenerator>
	
	    <javaClientGenerator type="XMLMAPPER" targetPackage="test.dao"  targetProject="\MBGTestProject\src">
	      <property name="enableSubPackages" value="true" />
	    </javaClientGenerator>
	
	    <table schema="DB2ADMIN" tableName="ALLTYPES" domainObjectName="Customer" >
	      <property name="useActualColumnNames" value="true"/>
	      <generatedKey column="ID" sqlStatement="DB2" identity="true" />
	      <columnOverride column="DATE_FIELD" property="startDate" />
	      <ignoreColumn column="FRED" />
	      <columnOverride column="LONG_VARCHAR_FIELD" jdbcType="VARCHAR" />
	    </table>
	
	  </context>
	</generatorConfiguration>  
	
	```
