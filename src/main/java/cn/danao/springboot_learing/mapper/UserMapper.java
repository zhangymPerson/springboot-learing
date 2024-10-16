package cn.danao.springboot_learing.mapper;

import cn.danao.springboot_learing.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * date 2024/10/16 17:32 <br/>
 * description interface UserMapper<br/>
 *
 * @author zym
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增
     * @author BEJSON
     * @date 2024/10/16
     **/
    int insert(User user);

    /**
     * 刪除
     * @author BEJSON
     * @date 2024/10/16
     **/
    int delete(int id);

    /**
     * 更新
     * @author BEJSON
     * @date 2024/10/16
     **/
    int update(User user);

    /**
     * 查询 根据主键 id 查询
     * @author BEJSON
     * @date 2024/10/16
     **/
    User load(int id);

    /**
     * 查询 分页查询
     * @author BEJSON
     * @date 2024/10/16
     **/
    List<User> pageList(int offset, int pagesize);

    /**
     * 查询 分页查询 count
     * @author BEJSON
     * @date 2024/10/16
     **/
    int pageListCount(int offset,int pagesize);

}