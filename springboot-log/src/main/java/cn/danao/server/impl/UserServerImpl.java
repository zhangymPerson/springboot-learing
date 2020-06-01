package cn.danao.server.impl;

import cn.danao.bean.RuleType;
import cn.danao.bean.User;
import cn.danao.bean.WordObj;
import cn.danao.server.UserServer;
import cn.danao.util.KieSessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * date 2020/6/1 14:58 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service
@Slf4j
public class UserServerImpl implements UserServer {
    @Override
    public User getUser() {
        List<User> userList = new ArrayList<>();
        test();
        return null;
    }

    /**
     * 测试规则
     */
    private void test() {
        try {
            KieSession kieSession1 = KieSessionUtils.newKieSession("rules/HelloWord.drl");
            log.info("{}", kieSession1);
            User user = new User();
            user.setName("张三");
            user.setAge(34);
            kieSession1.insert(user);
            kieSession1.fireAllRules();

            List<WordObj> list = new ArrayList<>();
            WordObj wordObj1 = new WordObj("1", "规则1测试", new ArrayList<>(), new HashMap<>(), RuleType.ONE);
            WordObj wordObj2 = new WordObj("2", "规则2测试", new ArrayList<>(), new HashMap<>(), RuleType.TWO);
            WordObj wordObj3 = new WordObj("3", "规则3测试", new ArrayList<>(), new HashMap<>(), RuleType.THREE);
            WordObj wordObj4 = new WordObj("4", "规则4测试", new ArrayList<>(), new HashMap<>(), RuleType.FORE);
            WordObj wordObj5 = new WordObj("5", "规则5测试", new ArrayList<>(), new HashMap<>(), RuleType.FIVE);
            list.add(wordObj1);
            list.add(wordObj2);
            list.add(wordObj3);
            list.add(wordObj4);
            list.add(wordObj5);
            list.forEach(System.out::println);
            KieSession kieSession2 = KieSessionUtils.newKieSession("rules/word/Word.drl");
            list.forEach(k -> {
                kieSession2.insert(k);
            });
            kieSession2.fireAllRules();
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
