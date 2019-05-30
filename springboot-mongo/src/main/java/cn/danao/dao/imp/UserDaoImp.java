package cn.danao.dao.imp;

import cn.danao.bean.User;
import cn.danao.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author danao
 * @version 1.0
 * @classname UserDaoImp
 * @descriptionclass
 * 1.mongo的实体类操作
 * 2.使用mongoTemplate 对象对mongo中的文档一起操作
 * @createdate 2019/5/30 15:10
 * @since 1.0
 */
@Service
public class UserDaoImp implements UserDao {

    private static final String COLL_NAME = "user_user2";

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void update(User user) {
        //mongo的save方法是刷新
        mongoTemplate.save(user);
    }

    @Override
    public User findById(String id) {
        return mongoTemplate.findById(id,User.class);
    }
}
