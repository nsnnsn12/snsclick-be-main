package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultOrderDto extends BaseOrderDto{
    private Long serviceId;
    private String link;
    private Integer quantity;
    private Integer runs;
    private Integer interval;
}
