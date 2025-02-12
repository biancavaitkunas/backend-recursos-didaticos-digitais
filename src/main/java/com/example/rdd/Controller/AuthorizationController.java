package com.example.rdd.Controller;

import com.example.rdd.Domain.AppUser.*;
import com.example.rdd.Infra.Security.TokenService;
import com.example.rdd.Repository.AppUserRepository;
import com.example.rdd.Service.AppUserService;
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
    AppUserService userService;

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
            final var appUser = repository.findAppUserByUsername(dto.username()).orElseThrow();
            return ResponseEntity.ok(new LoginResponse(token, appUser));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos!");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody @Valid AppUser appUser) {
        if (isPresent(this.repository.findByUsername(appUser.getUsername()))) return ResponseEntity.badRequest().build();

        final var user = appUser.toBuilder()
                .password(passwordEncoder.encode(appUser.getPassword()))
                .role(UserRole.USER)
                .build();
        repository.save(user);
        return ResponseEntity.ok(repository.save(user));
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        final var user = repository.findAppUserByUsername(request.username()).orElseThrow();

        if (!passwordEncoder.matches(request.oldPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha não confere!");
        }

        final var updatedUser = user.toBuilder().password(passwordEncoder.encode(request.newPassword())).build();
        userService.update(user.getId(), updatedUser);
        return ResponseEntity.ok("Senha alterada com sucesso!");
    }
}

