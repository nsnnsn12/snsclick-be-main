package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MentionsUserFollowersOrderDto extends BaseOrderDto{
    private String link;
    private Integer quantity;
    private String username; //ex) "test" => enable to use only one username
}
