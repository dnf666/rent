package com.dinner.controller;

import com.dinner.model.Login;
import com.dinner.service.LoginService;
import com.dinner.util.ResponseEntity;
import com.google.common.base.Strings;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created on 2019-03-03
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 注册
     *
     * @param login 数据
     * @return 注册结果
     */
    @PostMapping(value = "regist")
    public ResponseEntity register(@RequestBody Login login) {
        try {
            int result = loginService.insert(login);
            return new ResponseEntity(result, "register success", "");
        } catch (Exception e) {
            return new ResponseEntity(0, "该电话已注册", "");
        }
    }
    @GetMapping("login")
    public ResponseEntity getMessage(Login login){
        try {
            String phone = login.getPhone();
            if (Strings.isNullOrEmpty(phone)|| "null".equals(phone)){
                return new ResponseEntity(0, "服务器开小差，请刷新界面", "");
            }
            Login result = loginService.selectMessageByPhone(phone);
            return new ResponseEntity(1, "get success", result);
        } catch (Exception e) {
            return new ResponseEntity(0, "get fail", "");
        }
    }
    @PostMapping(value = "login")
    public ResponseEntity login(@RequestBody Login login) {
        try {
            Login result = loginService.selectByPrimaryKey(login);
            return new ResponseEntity(1, "register success", result);
        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage(), "");
        }
    }
    @PostMapping("delMember")
    public ResponseEntity delMember(@RequestBody Login login){
            int result = loginService.deleteByPrimaryKey(login);
            return new ResponseEntity(1, "delete success", result);
    }
    /**
     * 之前只创建了post方法，系统报错，然后就加了个get方法，没用
     * @param login
     * @return
     */
    @GetMapping(value = "regist")
    public ResponseEntity get(Login login) {
        loginService.insert(login);
        return new ResponseEntity(200, "register success", "");
    }

}
