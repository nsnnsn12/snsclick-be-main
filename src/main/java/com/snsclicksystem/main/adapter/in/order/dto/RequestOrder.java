package com.snsclicksystem.main.adapter.in.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestOrder {
	private String link;
	private Integer quantity;
	private Integer runs; //optional
	private Integer interval; //optional
}
