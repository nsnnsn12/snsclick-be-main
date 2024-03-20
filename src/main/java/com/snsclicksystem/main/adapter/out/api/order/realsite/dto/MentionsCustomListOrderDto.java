package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MentionsCustomListOrderDto extends BaseOrderDto{
    private String link;
    private String usernames; //ex) "test\nexample\nfb" => enable to use multiple usernames
}
