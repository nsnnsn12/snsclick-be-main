package com.snsclicksystem.main.adapter.out.api.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentionsUserFollowersOrderDto extends BaseOrderDto{
    private Long serviceId;
    private String link;
    private Integer quantity;
    private String username; //ex) "test" => enable to use only one username
}
