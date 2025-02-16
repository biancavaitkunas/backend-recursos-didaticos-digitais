package com.example.rdd.Controller;

import com.example.rdd.Controller.Generic.GenericController;
import com.example.rdd.Domain.AppUser.AppUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app_user")
public class AppUserController extends GenericController<AppUser, Long> {

}
