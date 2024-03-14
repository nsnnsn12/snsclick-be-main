package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageOrderDto extends BaseOrderDto{
    private Long serviceId;
    private String link;
}
