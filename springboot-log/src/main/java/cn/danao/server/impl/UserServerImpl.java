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
import java.util.Map;

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
        testOne();
        test();
        excel();
        excelTwo();
        return null;
    }


    /**
     * 测试简单的手写
     */
    private void testOne() {
        try {
            KieSession kieSession1 = KieSessionUtils.newKieSession("rules/HelloWord.drl");
            log.info("{}", kieSession1);
            User user = new User();
            user.setName("张三");
            user.setAge(34);
            kieSession1.insert(user);
            kieSession1.fireAllRules();
            List<User> users = new ArrayList<>();
            users.add(new User("1", "张三", 12, "备注"));
            users.add(new User("2", "李四", 19, "备注"));
            users.add(new User("3", "王五", 20, "备注"));
            users.add(new User("4", "赵六", 33, "备注"));
            for (int i = 0; i < users.size(); i++) {
                kieSession1.insert(users.get(i));
                kieSession1.fireAllRules();
            }
        } catch (Exception e) {
            log.error("简单drl文件测试异常", e);
        }
    }


    /**
     * 测试手写的drl文件规则
     */
    private void test() {
        try {
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

    /**
     * 测试excel文件
     */
    private void excelTwo() {
        try {
            String file = "D:\\person\\github\\springboot-learing\\springboot-log\\src\\main\\resources\\rules\\map.xls";
            String excelToDrl = KieSessionUtils.getDRL(file);
            log.info("读取excel之后的内容是\n{}", excelToDrl);
            //执行rules
            KieSession kieSession = null;
            try {
                kieSession = KieSessionUtils.createKieSessionFromDRL(excelToDrl);
            } catch (Exception e) {
                log.info("模板编写错误，请仔细核对！错误信息如下：", e);
                return;
            }
            //获取指定组
            List<Map<String, String>> users = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("name", "张三");
            map.put("age", "12");
            map.put("sex", "11");
            users.add(map);
            for (int i = 0; i < users.size(); i++) {
                //todo 重点，这个对象每次都需要调用，不然规则只执行一次
                kieSession.getAgenda().getAgendaGroup("map").setFocus();
                Map<String, String> u = users.get(i);
                kieSession.insert(u);
                List<String> listRules = new ArrayList<>();
                kieSession.setGlobal("listRules", listRules);
                int rules_count = kieSession.fireAllRules();
                log.info("用户 {} 评估规则ok,触发了 {} 条规则,listRules {}", u, rules_count, listRules);
            }
//            if (rules_count == 0 && listRules.size() == 0) {
//                return "触发了" + rules_count + "条规则,打印结果：true,通过校验";
//            } else {
//                return "触发了" + rules_count + "条规则,打印结果：" + listRules.toString();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void excel() {
        try {
            String file = "D:\\person\\github\\springboot-learing\\springboot-log\\src\\main\\resources\\rules\\user.xls";
            String excelToDrl = KieSessionUtils.getDRL(file);
            log.info("读取excel之后的内容是\n{}", excelToDrl);
            //执行rules
            KieSession kieSession = null;
            try {
                kieSession = KieSessionUtils.createKieSessionFromDRL(excelToDrl);
            } catch (Exception e) {
                log.info("模板编写错误，请仔细核对！错误信息如下：", e);
                return;
            }
            //获取指定组
            List<User> users = new ArrayList<>();
            users.add(new User("1", "张三", 12, "备注"));
            users.add(new User("2", "李四", 12, "备注"));
            users.add(new User("3", "王五", 12, "备注"));
            users.add(new User("4", "赵六", 12, "备注"));
            users.add(new User("5", "张三", 23, "备注"));
            for (int i = 0; i < users.size(); i++) {
                //todo 重点，这个对象每次都需要调用，不然规则只执行一次
                kieSession.getAgenda().getAgendaGroup("user").setFocus();
                User u = users.get(i);
                kieSession.insert(u);
                List<String> listRules = new ArrayList<>();
                kieSession.setGlobal("listRules", listRules);
                int rules_count = kieSession.fireAllRules();
                log.info("用户 {} 评估规则ok,触发了 {} 条规则", u, rules_count);
            }
//            if (rules_count == 0 && listRules.size() == 0) {
//                return "触发了" + rules_count + "条规则,打印结果：true,通过校验";
//            } else {
//                return "触发了" + rules_count + "条规则,打印结果：" + listRules.toString();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
