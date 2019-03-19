package cn.danao.dao;

import cn.danao.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhang
 * @version 1.0
 * @classname UserDao
 * @descriptionclass
 * 1.@Mapper 注解将UserDao申明为一个Mapper接口
 * 2.****************
 * @createdate 2019/3/19
 * @since 1.0
 */
@Component
@Mapper
public interface UserDao {

	@Select("select * from user")
	List<User> getAllUser();

}
