package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MentionsCustomListOrderDto extends BaseOrderDto{
    private String link;
    private String usernames; //ex) "test\nexample\nfb" => enable to use multiple usernames
}
