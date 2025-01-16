package com.example.rdd.Domain.Favorite;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Domain.Auditable;
import com.example.rdd.Domain.Platform.Platform;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "favorite")
public class Favorite extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorite")
    @Setter
    private Long id;

    @Column(name = "description_favorite")
    private String description;

    @ManyToOne
    private AppUser user;

    @ManyToOne
    private Platform platform;
}
