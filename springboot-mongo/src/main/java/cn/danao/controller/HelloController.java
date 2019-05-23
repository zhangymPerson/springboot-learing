package cn.danao.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danao
 * @version 1.0
 * @classname HelloController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/23 15:33
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {


    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("请求路由test");
        return "success";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String test1(){
        System.out.println(mongoTemplate);
        //获取集合
        MongoCollection<Document> collection = mongoTemplate.getCollection("goodwill");
        System.out.println(collection);
        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        int i =0;
        while (cursor.hasNext()) {
            System.out.println(i++);
            System.out.println(cursor.next());
        }
        //System.out.println(mongoTemplate.findAll(Object.class));
        return "success";
    }

}
