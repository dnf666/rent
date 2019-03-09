package com.dinner.controller;

import com.dinner.model.Login;
import com.dinner.service.LoginService;
import com.dinner.util.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created on 2019-03-03
 *
 * @author dailinfu
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

    @PostMapping(value = "login")
    public ResponseEntity login(@RequestBody Login login) {
        try {
            Login result = loginService.selectByPrimaryKey(login);
            return new ResponseEntity(1, "register success", result);
        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage(), "");
        }
    }

    @GetMapping(value = "regist")
    public ResponseEntity get(Login login) {
        loginService.insert(login);
        return new ResponseEntity(200, "register success", "");
    }

}
