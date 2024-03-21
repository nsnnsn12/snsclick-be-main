package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MentionsMediaLikersOrderDto extends BaseOrderDto{
    private String link;
    private Integer quantity;
    private String mediaLink; //ex) "http://example.com/p/Ds2kfEr24Dr"

}
