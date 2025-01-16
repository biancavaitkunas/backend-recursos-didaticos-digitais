package com.example.rdd.Domain.UploadFile;

import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "image")
public class UploadFile extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    @Setter
    private Long id;

    @Column(name = "description_image")
    private String description;

    @Column(name = "image")
    private byte[] image;

}
