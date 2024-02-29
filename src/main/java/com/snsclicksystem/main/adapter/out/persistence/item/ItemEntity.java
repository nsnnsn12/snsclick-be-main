package com.snsclicksystem.main.adapter.out.persistence.item;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity(name="item")
@Getter
public class ItemEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    private String itemType;
    private Integer itemPrice;
    private Integer itemSolidPrice;
    private Integer minOrderQuantity;
    private Integer maxOrderQuantity;
    private Boolean isRepeatable;
    private Boolean isCancelable;
    private Integer averageCompletionTime;
}
