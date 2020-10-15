package cn.danao.dao;

import cn.danao.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * mongo 操作方式之一
 * 继承Mongo jar包的接口实现
 * 不用自己写实现类
 * 可以自定义常用的
 */
@Service
public interface UserTwoDao extends MongoRepository<User, String> {

    /**
     * 但是MongoRepository实现了的只是最基本的增删改查的功能，要想增加额外的查询方法，可以按照以下规则定义接口的方法。自定义查询方
     * 法，格式为“findBy+字段名+方法后缀”，方法传进的参数即字段的值，此外还支持分页查询，通过传进一个Pageable对象，返回Page集合。
     */
    User findByName(String name);

    // User findByName(String name,Passenger )

    /**
     * 注意 如果使用了userId 字段 作为document 的 _id ,则 不能使用 byId,要使用 byUserId
     * 否则报错
     * Caused by: org.springframework.data.mapping.PropertyReferenceException: No property id found for type User!
     *
     * Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userTwoDao': Invocation of init method failed; nested exception is org.springframework.data.mapping.PropertyReferenceException: No property id found for type User!
     *
     */

    /**
     * GreaterThan(大于)
     * 方法名举例：
     *
     * @param age
     */

    List<User> findByAgeGreaterThan(int age);


    /**
     * LessThan（小于）
     * 方法名举例：
     *
     * @param age
     */
    List<User> findByAgeLessThan(int age);


    /**
     * Between（在…之间）
     * 方法名举例：
     *
     * @param from
     * @param to
     */
    List<User> findByUserIdBetween(int from, int to);


    /**
     * Not（不包含）
     * 方法名举例：
     *
     * @param name
     */
    List<User> findByNameNot(String name);
}
