package com.snsclicksystem.main.adapter.in.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseItem {
    private String itemType;
    private Integer itemPrice;
    private Integer minOrderQuantity;
    private Integer maxOrderQuantity;
    private Boolean isRepeatable;
    private Boolean isCancelable;
    private Integer averageCompletionTime;
}
