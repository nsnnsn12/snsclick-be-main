package com.snsclicksystem.main.domain.order;

import com.snsclicksystem.main.domain.item.SnsItem;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Order {
    private SnsItem item;
    private Long consumerId;
}
