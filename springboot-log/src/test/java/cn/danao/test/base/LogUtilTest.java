package cn.danao.test.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.helpers.MessageFormatter;

/**
 * date 2020/6/5 15:57 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class LogUtilTest {

    @Test
    public void test() {
//        MessageFormatter.arrayFormat("", "", "");
        String a = "aa";
        log.info("test {} {} {} {} {} {} {} {} {} {} {} {} {} {}  ", a, a, a, a, a, a, a, a, a, a, a, a, a, a);

        log.info(getFormattedMessage("test"));
        log.info(getFormattedMessage("a {}"), a, a, a);
        log.info(getFormattedMessage("test {} "));
        log.info(getFormattedMessage("test {} {} {}"), a);
    }


    /**
     * 基于Slf4j的拼写工具类
     *
     * @param message
     * @param argumentArray
     * @return
     */
    public String getFormattedMessage(String message, Object... argumentArray) {
        String formattedMessage = "";
        if (argumentArray != null) {
            formattedMessage = MessageFormatter.arrayFormat(message, argumentArray).getMessage();
        } else {
            formattedMessage = message;
        }
        return formattedMessage;
    }

}
