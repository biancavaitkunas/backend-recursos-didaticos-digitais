package com.example.rdd.Domain.Platform;

import com.example.rdd.Domain.Auditable;
import com.example.rdd.Domain.UploadFile.UploadFile;
import jakarta.persistence.*;
import lombok.*;

import java.io.IOException;

@Getter
@Builder(toBuilder = true)
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

    @Column(name = "description_platform", length = 1000)
    private String descriptionPlatform;

    @Column(name = "url_video", length = 1000)
    private String urlVideo;

    @Column(name = "url_platform")
    private String urlPlatform;

    @ManyToOne
    private UploadFile logo;

    @ManyToOne
    private UploadFile presentationImage;

    @ManyToOne
    private UploadFile textTutorial;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private AppUser registrationUser;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private StatusPlatform statusPlatform;

    public Platform(PlatformRequestDTO data) throws IOException {
        this.namePlatform = data.platform().getNamePlatform();
        this.descriptionPlatform = data.platform().getDescriptionPlatform();
        this.urlVideo = data.platform().getUrlVideo();
        this.urlPlatform = data.platform().getUrlPlatform();
    }
}
