package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomCommentOrderDto extends BaseOrderDto {
    private String link;
    private String comments; //ex) "good pic\ngreat photo\n:)\n;)"
}
