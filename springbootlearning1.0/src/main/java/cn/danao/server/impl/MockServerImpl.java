package cn.danao.server.impl;

import cn.danao.bean.UserInfo;
import cn.danao.server.MockService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service
public class MockServerImpl implements MockService {

    public static List<UserInfo> list = new ArrayList<>();

    @Override
    public UserInfo getUser(int userId) {
        if (list == null || list.size() == 0) {
            return null;
        }
        for (UserInfo u : list) {
            if (u.getId() == userId) {
                return u;
            }
        }
        return null;
    }

}
