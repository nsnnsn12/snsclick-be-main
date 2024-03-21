package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class DefaultOrderDto extends BaseOrderDto{
    private String link;
    private Integer quantity;
    private Long orderBeforeQuantity;
    private Integer runs; //optional
    private Integer interval; //optional
}
