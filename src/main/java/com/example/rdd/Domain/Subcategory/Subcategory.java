package com.example.rdd.Domain.Subcategory;

import com.example.rdd.Domain.Auditable;
import com.example.rdd.Domain.Category.Category;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "subcategory")
public class Subcategory extends Auditable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategory")
    @Setter
    private Long id;

    @Column(name = "description_subcategory")
    private String description;

    @ManyToOne
    private Category category;
}
