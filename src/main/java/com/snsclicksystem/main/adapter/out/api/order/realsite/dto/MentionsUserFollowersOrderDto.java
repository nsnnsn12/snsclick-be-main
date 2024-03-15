package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MentionsUserFollowersOrderDto extends BaseOrderDto{
    private String link;
    private Integer quantity;
    private String username; //ex) "test" => enable to use only one username
}
