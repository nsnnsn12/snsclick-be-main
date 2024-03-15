package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubscriptionsOrderDto extends BaseOrderDto{
    private String username; //ex) "test" => enable to use only one username
    private Integer min;
    private Integer max;
    private Integer posts;
    private Integer delay;
    private String expiry; //ex) "11/11/2022"
}
