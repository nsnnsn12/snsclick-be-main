package com.snsclicksystem.main.adapter.out.persistence.real_site;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity(name="real_site")
@Getter
public class RealSiteEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "real_site_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    @Column(unique = true)
    private Long serviceId;
    private String name;
    @Enumerated(EnumType.STRING)
    private RealSiteType realSiteType;
    private Integer minOrderQuantity;
    private Integer maxOrderQuantity;
    private boolean repeatable;
    private boolean refillable;
    private boolean cancelable;
    private Integer avgCompTime;
}
