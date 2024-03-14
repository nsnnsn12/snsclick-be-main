package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentionsMediaLikersOrderDto extends BaseOrderDto{
    private Long serviceId;
    private String link;
    private Integer quantity;
    private String mediaLink; //ex) "http://example.com/p/Ds2kfEr24Dr"

}
