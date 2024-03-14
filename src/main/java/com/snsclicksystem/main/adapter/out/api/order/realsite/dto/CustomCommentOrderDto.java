package com.snsclicksystem.main.adapter.out.api.order.realsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomCommentOrderDto extends BaseOrderDto {
    private Long serviceId;
    private String link;
    private String comments; //ex) "good pic\ngreat photo\n:)\n;)"
}
