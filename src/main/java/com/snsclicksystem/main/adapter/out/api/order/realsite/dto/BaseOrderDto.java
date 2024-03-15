package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseOrderDto {
    private String apiKey;
    private String action;
    private Long serviceId;
}
