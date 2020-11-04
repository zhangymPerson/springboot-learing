package cn.danao.dao.imp;

import cn.danao.dao.DataDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * date 2020/11/4 14:46 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Service
public class DataDaoImpl implements DataDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 测试表/文档名
     */
    private final static String collectionName = "test";

    @Override
    public List<Map> getAllData() {
        List<Map> all = mongoTemplate.findAll(Map.class, collectionName);
        log.info("获取到{}中的数据量是{},数据是\n{}", collectionName, all.size(), all.get(0));
        return new ArrayList<>();
    }

    @Override
    public List<Map> getPageData(int page, int size) {
        //创建查询对象
        Query query = new Query();
        //查询条件
        query.addCriteria(Criteria.where("name").is("张三"));
        //查询总记录数
        long count = mongoTemplate.count(query, Map.class, collectionName);
        // 分页查询对象构建
        Pageable pageable = PageRequest.of(page, size);
        List<Map> pageList = mongoTemplate.find(query.with(pageable), Map.class, collectionName);
        log.info("map的总数量是{},查询到的数量{}", count, pageList.size());
        return null;
    }
}
