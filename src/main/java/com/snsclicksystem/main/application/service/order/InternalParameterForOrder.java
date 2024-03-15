package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InternalParameterForOrder {
    private Member member;
    private String apiKey;
    private String action;
    private Long serviceId;
    private OrderType orderType;
}
