package com.snsclicksystem.main.adapter.out.api.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseOrderDto {
    private String apiKey;
    private String action;
}
