package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.domain.member.Member;
import lombok.Builder;

@Builder
public class InternalParameterForOrder {
    private Member member;
}
