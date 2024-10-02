package com.example.rdd.Domain.AppUser;

import com.example.rdd.Domain.Auditable;
import com.example.rdd.Domain.StatusUser.StatusUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @Column(name = "login_user", unique = true)
    private String loginUser;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "cpf_user")
    private String cpf;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusUser statusUser;

    public AppUser(final AppUserRequestDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.birthDate = data.birthDate();
        this.loginUser = data.loginUser();
        this.cpf = data.cpf();
    }


}
