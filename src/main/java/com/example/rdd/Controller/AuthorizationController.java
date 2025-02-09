package com.example.rdd.Controller;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Domain.AppUser.AuthenticationDTO;
import com.example.rdd.Domain.AppUser.LoginResponse;
import com.example.rdd.Domain.AppUser.UserRole;
import com.example.rdd.Infra.Security.TokenService;
import com.example.rdd.Repository.AppUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.example.rdd.Util.Util.isPresent;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

    @Autowired
    private AppUserRepository repository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO dto) {
        try {
            final var usernamePassword = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
            final var auth = authenticationManager.authenticate(usernamePassword);
            final var token = tokenService.generateToken((AppUser) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponse(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos!");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid AppUser appUser) {
        if (isPresent(this.repository.findByUsername(appUser.getUsername())))
            return ResponseEntity.badRequest().build();

        final var user = appUser.toBuilder()
                .password(passwordEncoder.encode(appUser.getPassword()))
                .role(UserRole.USER)
                .build();
        repository.save(user);
        return ResponseEntity.ok("Cadastro realizado com sucesso!");
    }
}

