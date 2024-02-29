package com.snsclicksystem.main.domain.item;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SnsItem {
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
