package cn.danao.dao;

import java.util.List;
import java.util.Map;

/**
 * date 2020/11/4 14:44 <br/>
 * description class <br/>
 * 测试数据操作接口
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface DataDao {

    /**
     * 获取所有数据
     *
     * @return
     */
    List<Map> getAllData();

    /**
     * 分页数据
     *
     * @param page 页数
     * @param size 单页数据
     * @return
     */
    List<Map> getPageData(int page, int size);
}
