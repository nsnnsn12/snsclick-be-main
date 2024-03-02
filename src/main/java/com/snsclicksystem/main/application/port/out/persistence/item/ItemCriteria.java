package com.snsclicksystem.main.application.port.out.persistence.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCriteria {
    private String itemType;
    private Integer itemPrice;
    private Integer itemSolidPrice;
    private Integer minOrderQuantity;
    private Integer maxOrderQuantity;
    private Boolean isRepeatable;
    private Boolean isCancelable;
    private Integer averageCompletionTime;
}
