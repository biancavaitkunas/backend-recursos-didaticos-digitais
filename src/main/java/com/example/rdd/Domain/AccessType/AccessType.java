package com.example.rdd.Domain.AccessType;

import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "access_type")
public class AccessType extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_access_type")
    @Setter
    private Long id;

    @Column(name = "description_access_type")
    private String description;

}
