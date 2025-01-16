package com.example.rdd.Domain.Ocupation;

import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "ocupation")
public class Ocupation extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ocupation")
    @Setter
    private Long id;

    @Column(name = "description_ocupation")
    private String descriptionOcupation;

}
