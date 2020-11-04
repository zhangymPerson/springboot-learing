package cn.danao.dao.imp;

import cn.danao.dao.DataDao;
import cn.danao.test.SpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class DataDaoImplTest extends SpringTest {

    @Autowired
    private DataDao dataDao;

    @Test
    public void getAllData() {
        // dataDao.getAllData();
        dataDao.getPageData(1, 10);
    }
}