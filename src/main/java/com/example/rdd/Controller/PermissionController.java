package com.example.rdd.Controller;

import com.example.rdd.Controller.Generic.GenericController;
import com.example.rdd.Domain.Permission.Permission;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("permission")
public class PermissionController extends GenericController<Permission, Long> {

}
