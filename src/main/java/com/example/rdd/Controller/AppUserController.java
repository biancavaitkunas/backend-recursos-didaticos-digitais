package com.example.rdd.Controller;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Domain.AppUser.AppUserRequestDTO;
import com.example.rdd.Domain.AppUser.AppUserResponseDTO;
import com.example.rdd.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app_user")
public class AppUserController {

    @Autowired
    private AppUserRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void insert(@RequestBody AppUserRequestDTO user) {
        final var appUserData = new AppUser(user);
        repository.save(appUserData);
    }

    @GetMapping
    public List<AppUserResponseDTO> getAll() {
        return repository.findAll().stream().map(AppUserResponseDTO::new).toList();
    }
}
