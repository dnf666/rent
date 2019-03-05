package com.dinner.controller;

import com.dinner.model.Admin;
import com.dinner.model.Login;
import com.dinner.service.AdminService;
import com.dinner.service.LoginService;
import com.dinner.util.Pager;
import com.dinner.util.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

/**
 * created on 2019-03-03
 *
 * @author dailinfu
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private LoginService loginService;
    @PostMapping(value = "login")
    public ResponseEntity login(@RequestBody Admin admin) {
        try {
            Admin result = adminService.selectByPrimaryKey(admin);
            return new ResponseEntity(1, "register success", result);
        }catch (Exception e){
            return new ResponseEntity(0, e.getMessage(), "");
        }
    }
    @PostMapping("/filter")
    public ResponseEntity memberFilter(@RequestBody Login login,
                            int page,
                            int size
    ) {
        Pager<Login> pager = new Pager<>();
        pager.setCurrentPage(page);
        pager.setPageSize(size);
        try {
            List<Login> list = loginService.filter(pager, login);
        pager.setData(list);
            return new ResponseEntity(1, "find member success", pager);
        } catch (Exception e) {
            return new ResponseEntity(0,e.getMessage(), pager);
        }
    }
}
