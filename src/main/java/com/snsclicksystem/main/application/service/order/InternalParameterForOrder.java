package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.domain.member.MemberInfo;
import lombok.Builder;

@Builder
public class InternalParameterForOrder {
    private MemberInfo member;
}
