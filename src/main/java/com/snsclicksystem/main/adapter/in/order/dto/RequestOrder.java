package com.snsclicksystem.main.adapter.in.order.dto;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestOrder {

	private Long id;
	private Long memberId;
	private int orderPrice;

}
