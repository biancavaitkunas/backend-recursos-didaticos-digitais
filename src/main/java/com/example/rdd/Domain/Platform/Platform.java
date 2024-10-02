package com.example.rdd.Domain.Platform;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "platform")
public class Platform extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platform")
    @Setter
    private Long id;

    @Column(name = "name_platform")
    private String namePlatform;

    @Column(name = "description_platform")
    private String descriptionPlatform;

    @Column(name = "url_video")
    private String urlVideo;

    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser registrationUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusPlatform statusPlatform;
}
