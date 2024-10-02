package com.example.rdd.Domain.Sugestion;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "sugestion")
public class Sugestion extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sugestion")
    @Setter
    private Long id;

    @Column(name = "description_sugestion")
    private String description;

    @ManyToOne
    private AppUser appUser;
}
