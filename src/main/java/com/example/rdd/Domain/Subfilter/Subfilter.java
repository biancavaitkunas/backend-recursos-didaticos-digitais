package com.example.rdd.Domain.Subfilter;

import com.example.rdd.Domain.Auditable;
import com.example.rdd.Domain.Filter.Filter;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "subfilter")
public class Subfilter extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subfilter")
    @Setter
    private Long id;

    @Column(name = "description_subfilter")
    private String description;

    @ManyToOne
    private Filter filter;
}
