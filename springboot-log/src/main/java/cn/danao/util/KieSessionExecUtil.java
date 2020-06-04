package cn.danao.util;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date 2020/6/2 11:03 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Component
@Slf4j
public class KieSessionExecUtil {


    /**
     * 静态初始化的规则内容
     */
    public static final Map<String, KieSession> ALL_RULES_EXCEL_KIESESSION = new HashMap<>();

    /**
     * 初始化所有规则
     * 新规则在这里配置添加
     */
    static {
        //文件名和规则key一致
        //规则名需要和文件内部的规则组名字一致
        KieSession mapKieSession = initKieSession("rules/map.xls");
        //拼写测试
        StringBuffer strInfo = new StringBuffer();
        KieSession strInfoKieSession = initKieSession("rules/strInfo.xls");
        ALL_RULES_EXCEL_KIESESSION.put("map", mapKieSession);
        ALL_RULES_EXCEL_KIESESSION.put("strInfo", strInfoKieSession);
        log.info("初始化规则文件完成，共[{}]个文件", ALL_RULES_EXCEL_KIESESSION.size());
    }

    /**
     * 初始化执行规则
     *
     * @param resourceName
     * @return
     */
    public static KieSession initKieSession(String resourceName) {
        try {
            ClassPathResource resource = new ClassPathResource(resourceName);
            // 获取文件流
            InputStream inputStream = resource.getInputStream();
            // 获取文件
            File file = resource.getFile();
            String excelToDrl = KieSessionUtils.getDRL(inputStream);
            //规则执行
            KieSession kieSession = null;
            kieSession = KieSessionUtils.createKieSessionFromDRL(excelToDrl);
            log.info("\n规则文件是file={},\n规则内容是str={}", file.getName(), excelToDrl);
            return kieSession;
        } catch (Exception e) {
            log.error("初始化规则文件失败,异常信息:", e);
            throw new RuntimeException("初始化规则文件失败");
        }
    }

    public static String execKieSession(Map<String, String> map, String rulesKey) {
        KieSession kieSession = null;
        kieSession = ALL_RULES_EXCEL_KIESESSION.get(rulesKey);
        //获取指定组
        //todo 重点，这个对象每次都需要调用，不然规则只执行一次
        kieSession.getAgenda().getAgendaGroup(rulesKey).setFocus();
        kieSession.insert(map);
        List<String> listRules = new ArrayList<>();
        kieSession.setGlobal("listRules", listRules);
        int rules_count = kieSession.fireAllRules();
        log.info("用户 {} 评估规则ok,触发了 {} 条规则,listRules {}", map, rules_count, listRules);
        return "success";
    }

}
