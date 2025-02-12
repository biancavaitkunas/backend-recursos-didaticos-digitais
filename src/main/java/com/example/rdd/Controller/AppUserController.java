package com.example.rdd.Controller;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app_user")
public class AppUserController extends GenericController<AppUser, Long> {

    @Autowired
    private AppUserService service;

}
