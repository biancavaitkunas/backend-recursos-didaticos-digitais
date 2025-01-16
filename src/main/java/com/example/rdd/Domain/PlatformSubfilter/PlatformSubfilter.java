package com.example.rdd.Domain.PlatformSubfilter;

import com.example.rdd.Domain.Auditable;
import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.Subfilter.Subfilter;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity(name = "platform_subfilter")
public class PlatformSubfilter extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platform_subfilter")
    @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Platform platform;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subfilter subfilter;
}
