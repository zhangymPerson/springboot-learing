package cn.danao.dao;

import cn.danao.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 * mongo 操作方式之一
 * 继承Mongo jar包的接口实现
 */
@Service
public interface UserDaoTest extends MongoRepository<User,String> {

}
