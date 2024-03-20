package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MentionsWithHashtagsOrderDto extends BaseOrderDto{
    private String link;
    private Integer quantity;
    private String usernames; //ex) "test, testing" => enable to use multiple usernames
    private String hashtags; //ex) "#goodphoto"
}
