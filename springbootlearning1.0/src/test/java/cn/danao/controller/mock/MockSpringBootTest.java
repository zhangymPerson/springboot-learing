package cn.danao.controller.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * date 2020/12/16 10:35 <br/>
 * description class <br/>
 * 测试 springboot 中的mock
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MockSpringBootTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        //构造mock对象
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                //是否打印mock 过程
                .alwaysDo(print())
                .build();
    }

    @After
    public void tearDown() {
    }

    protected String sendPost(String url, String param) throws Exception {
        return sendPost(url, param, null);
    }

    protected String sendPost(String url, String param, String token) throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                post(url)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(param)
                // .header("token", token)
        ).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
        return mvcResult.getResponse().getContentAsString();
    }


}
