package com.example.rdd.Domain.AppUserCollaborationType;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Domain.Auditable;
import com.example.rdd.Domain.CollaborationType.CollaborationType;
import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.Subfilter.Subfilter;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "app_user_collaboration_type")
public class AppUserCollaborationType extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_app_user_collaboration_type")
    @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    private CollaborationType collaborationType;
}
