package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DefaultOrderDto extends BaseOrderDto{
    private String link;
    private Integer quantity;
    private Integer runs; //optional
    private Integer interval; //optional
}
