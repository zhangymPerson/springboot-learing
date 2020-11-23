package cn.danao.generator.dao;

import cn.danao.generator.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}