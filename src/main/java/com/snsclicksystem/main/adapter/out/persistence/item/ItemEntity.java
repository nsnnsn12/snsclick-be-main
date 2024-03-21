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
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_content")
    private String content;
    @Column(name = "item_price")
    private Integer price;
}
