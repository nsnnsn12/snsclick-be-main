package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PackageOrderDto extends BaseOrderDto{
    private String link;
}
