package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CustomCommentOrderDto extends BaseOrderDto {
    private String link;
    private String comments; //ex) "good pic\ngreat photo\n:)\n;)"
}
