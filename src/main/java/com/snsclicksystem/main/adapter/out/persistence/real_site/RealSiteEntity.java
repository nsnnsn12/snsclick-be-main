package com.snsclicksystem.main.adapter.out.persistence.real_site;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Entity(name="real_site")
@Getter
public class RealSiteEntity extends BaseTimeEntity {
    private Long id;
    @Column(unique = true)
    private Long itemId;
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
