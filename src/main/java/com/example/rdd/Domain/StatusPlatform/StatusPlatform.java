package com.example.rdd.Domain.StatusPlatform;

import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "status_platform")
public class StatusPlatform extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status_platform")
    @Setter
    private Long id;

    @Column(name = "description_status_platform")
    private String description;
}
