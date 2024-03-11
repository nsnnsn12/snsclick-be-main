package com.snsclicksystem.main.adapter.out.api.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionsOrderDto extends BaseOrderDto{
    private Long serviceId;
    private String username; //ex) "test" => enable to use only one username
    private Integer min;
    private Integer max;
    private Integer posts;
    private Integer delay;
    private String expiry; //ex) "11/11/2022"
}