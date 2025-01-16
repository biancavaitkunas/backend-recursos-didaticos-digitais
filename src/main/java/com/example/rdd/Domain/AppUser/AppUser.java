package com.example.rdd.Domain.AppUser;

import com.example.rdd.Domain.AccessType.AccessType;
import com.example.rdd.Domain.Auditable;
import com.example.rdd.Domain.Ocupation.Ocupation;
import com.example.rdd.Domain.StatusUser.StatusUser;
import jakarta.persistence.*;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "app_user")
public class AppUser extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @Setter
    private Long id;

    @Column(name = "first_name_user")
    private String firstName;

    @Column(name = "last_name_user")
    private String lastName;

    @Column(name = "email_user")
    private String email;

    @Column(name = "gender_user")
    private String gender;

    @Column(name = "login_user", unique = true)
    private String login;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "cpf_user")
    private String cpf;

    @Column(name = "password_user")
    private String password;

    @Column(name = "role")
    private UserRole role;

    @ManyToOne
    private Ocupation ocupation;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusUser statusUser;

    @ManyToOne
    private AccessType accessType;

    public AppUser(final AppUserRequestDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.birthDate = data.birthDate();
        this.login = data.loginUser();
        this.cpf = data.cpf();
    }


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return switch (role) {
//            case ADMIN ->
//                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_PARTNER"), new SimpleGrantedAuthority("ROLE_USER"));
//            case PARTNER ->
//                    List.of(new SimpleGrantedAuthority("ROLE_PARTNER"), new SimpleGrantedAuthority("ROLE_USER"));
//            case USER -> List.of(new SimpleGrantedAuthority("ROLE_USER"));
//        };
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
}
