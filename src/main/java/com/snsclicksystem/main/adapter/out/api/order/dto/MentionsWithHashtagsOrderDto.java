package com.snsclicksystem.main.adapter.out.api.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentionsWithHashtagsOrderDto extends BaseOrderDto{
    private Long serviceId;
    private String link;
    private Integer quantity;
    private String usernames; //ex) "test, testing" => enable to use multiple usernames
    private String hashtags; //ex) "#goodphoto"
}
