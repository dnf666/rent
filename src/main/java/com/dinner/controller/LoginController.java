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
     * @param login 数据
     * @return 注册结果
     */
    @PostMapping(value = "regist")
    public ResponseEntity register(@RequestBody Login login) {
        loginService.insert(login);
        return new ResponseEntity(200, "register success", "");
    }
    @GetMapping(value = "regist")
    public ResponseEntity get(Login login) {
        loginService.insert(login);
        return new ResponseEntity(200, "register success", "");
    }

}
