package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MentionsMediaLikersOrderDto extends BaseOrderDto{
    private String link;
    private Integer quantity;
    private String mediaLink; //ex) "http://example.com/p/Ds2kfEr24Dr"

}
