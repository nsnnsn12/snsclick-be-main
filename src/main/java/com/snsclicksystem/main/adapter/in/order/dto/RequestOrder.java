package com.snsclicksystem.main.adapter.in.order.dto;

import com.snsclicksystem.main.domain.item.SnsItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestOrder {

	private Long id;
	private Long memberId;
	private int orderPrice;

	public SnsItem getOrderItem(){
		return SnsItem.builder().build();
	}
}
