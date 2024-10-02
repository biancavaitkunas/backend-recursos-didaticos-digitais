package com.example.rdd.Domain.StatusUser;

import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "status_user")
public class StatusUser extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status_user")
    @Setter
    private Long id;

    @Column(name = "description_status_user")
    private String description;

}
