package com.example.rdd.Domain.CollaborationType;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "collaboration_type")
public class CollaborationType extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_collaboration_type")
    @Setter
    private Long id;

    @Column(name = "description_collaboration_type")
    private String description;

    @ManyToMany
    @JoinTable(name = "app_user_collaboration_type", joinColumns = @JoinColumn(name = "id_collaboration_type"), inverseJoinColumns = @JoinColumn(name = "id_app_user"))
    private Set<AppUser> appUsers;
}
