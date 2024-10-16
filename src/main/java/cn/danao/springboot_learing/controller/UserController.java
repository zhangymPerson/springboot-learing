package cn.danao.springboot_learing.controller;

import cn.danao.springboot_learing.dao.User;
import cn.danao.springboot_learing.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * date 2024/10/16 17:32 <br/>
 * description class UserController<br/>
 *
 * @author zym
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 新增
     * @author BEJSON
     * @date 2024/10/16
     **/
    @RequestMapping("/insert")
    public Object insert(User user){
        return userService.insert(user);
    }

    /**
     * 刪除
     * @author BEJSON
     * @date 2024/10/16
     **/
    @RequestMapping("/delete")
    public Object delete(int id){
        return userService.delete(id);
    }

    /**
     * 更新
     * @author BEJSON
     * @date 2024/10/16
     **/
    @RequestMapping("/update")
    public Object update(User user){
        return userService.update(user);
    }

    /**
     * 查询 根据主键 id 查询
     * @author BEJSON
     * @date 2024/10/16
     **/
    @RequestMapping("/load")
    public Object load(int id){
        return userService.load(id);
    }

    /**
     * 查询 分页查询
     * @author BEJSON
     * @date 2024/10/16
     **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);
    }

}