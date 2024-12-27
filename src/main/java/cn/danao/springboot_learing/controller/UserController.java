package cn.danao.springboot_learing.controller;

import cn.danao.springboot_learing.dao.User;
import cn.danao.springboot_learing.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
     *
     * @author BEJSON
     * @date 2024/10/16
     * curl -X POST -H "Content-Type: application/json" -d '{"id": 1,"username": "John Doe", "age": 30}' http://localhost:8080/api/user/insert
     **/
    @PostMapping("/insert")
    public Object insert(@RequestBody User user) {
        return userService.insert(user);
    }

    /**
     * 刪除
     *
     * @author BEJSON
     * @date 2024/10/16
     * curl -X GET http://localhost:8080/api/user/delete?id=1
     **/
    @RequestMapping("/delete")
    public Object delete(int id) {
        return userService.delete(id);
    }

    /**
     * 更新
     *
     * @author BEJSON
     * @date 2024/10/16
     * curl -X POST -H "Content-Type: application/json" -d '{"id": 1,"username": "John Doe", "age": 30}' http://localhost:8080/api/user/update
     **/
    @RequestMapping("/update")
    public Object update(User user) {
        return userService.update(user);
    }

    /**
     * 查询 根据主键 id 查询
     *
     * @author BEJSON
     * @date 2024/10/16
     * curl -X GET http://localhost:8080/api/user/load?id=1
     **/
    @GetMapping("/get")
    public Object getById(int id) {
        return userService.getById(id);
    }

    /**
     * 查询 分页查询
     *
     * @author BEJSON
     * @date 2024/10/16
     **/
    @GetMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);
    }

}