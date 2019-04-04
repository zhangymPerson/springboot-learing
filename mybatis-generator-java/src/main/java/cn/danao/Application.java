package cn.danao;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang
 * @version 1.0
 * @classname Application
 * @descriptionclass class describe
 * 1.****************
 * 2.****************
 * @createdate 2019/4/4
 * @since 1.0
 */
public class Application {


	public static void main(String[] args) {
		System.out.println("Hello Word!");
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		System.out.println(System.getProperty("user.dir"));
		String filepath = System.getProperty("user.dir");
		File configFile = new File(filepath+"/src/main/resources/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		try{
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
