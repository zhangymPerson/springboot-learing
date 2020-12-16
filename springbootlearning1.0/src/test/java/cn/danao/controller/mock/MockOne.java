package cn.danao.controller.mock;

import cn.danao.bean.UserInfo;
import cn.danao.server.MockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * date 2020/12/16 10:36 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class MockOne extends MockSpringBootTest {

    @MockBean
    private MockService mockService;

    @Test
    public void test() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform(
                    post("/post/params")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                            .content("id=2")
                    // .header("token", token)
            ).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            log.info("response=[{}]", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(
                //构造一个get请求
                get("/user/1")
                        //请求类型 json
                        .contentType(MediaType.APPLICATION_JSON))
                // 期待返回的状态码是4XX，因为我们并没有写/user/{id}的get接口
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

    @Test
    public void getUserById() throws Exception {
        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(
                //构造一个get请求
                get("/user/test")
                        //请求类型 json
                        .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    /**
     * mock一个Service对象
     *
     * @throws Exception
     */
    @Test
    public void getUser() throws Exception {
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setName("mock测试对象");
        user.setAge(18);
        //Mock一个结果，当userService调用getById的时候，返回user
        // Unable to register mock bean cn.danao.server.UserServer expected a single matching bean to replace but found [userServer1, userServer2]
        // mock不能有多个实现的service对象
        doReturn(user).when(mockService).getUser(anyInt());

        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(MockMvcRequestBuilders
                //构造一个get请求
                .get("/user/get/23")
                //请求类型 json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
