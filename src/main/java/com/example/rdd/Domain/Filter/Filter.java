package com.example.rdd.Domain.Filter;

import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "filter")
public class Filter extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filter")
    @Setter
    private Long id;

    @Column(name = "description_filter")
    private String description;

}
