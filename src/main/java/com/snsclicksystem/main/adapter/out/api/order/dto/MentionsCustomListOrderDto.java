package com.snsclicksystem.main.adapter.out.api.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentionsCustomListOrderDto extends BaseOrderDto{
    private Long serviceId;
    private String link;
    private String usernames; //ex) "test\nexample\nfb" => enable to use multiple usernames
}
