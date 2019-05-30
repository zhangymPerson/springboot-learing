package cn.danao.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author danao
 * @version 1.0
 * @classname User
 * @descriptionclass
 * 1.用户的类 mongo 中集合对应的集合类
 * @createdate 2019/5/30 14:59
 * @since 1.0
 */
@Data
@Document(value = "user")
public class User {

    @Id
    public String userId;

    @Field(value = "name")
    public String name;

    @Field(value = "age")
    public int age;

    @Field(value = "createDate")
    public Date createDate;

}
