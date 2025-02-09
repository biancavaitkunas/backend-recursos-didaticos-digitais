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

//    @Override
//    public ResponseEntity<AppUser> create(final AppUser entity) {
//        return new ResponseEntity<>(service.create(entity), HttpStatus.CREATED);
//    }

//    @GetMapping("login/{login}")
//    public ResponseEntity<List<AppUser>> findByLogin(@PathVariable String login) {
//        //return ResponseEntity.ok(service.findByLogin(login));
//    }
}
