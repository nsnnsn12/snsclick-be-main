package com.snsclicksystem.main.adapter.out.api.order.realsite;

import com.snsclicksystem.main.adapter.out.api.order.dto.OrderedInfo;

import com.snsclicksystem.main.adapter.out.api.order.OrderApi;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * RealSite용 주문을 처리하는 order api에 구현체
 * RealSite에 주문 요청 시 공통으로 처리해야 하는 작업 처리
 * ex) 공통으로 처리해야 하는 validation 처리 등등 => canOrder()
 */
@Component
@RequiredArgsConstructor
public class RealSiteApi implements OrderApi<RealSiteClient, Integer> {
	private final RealSiteClient realSiteClient;
	@Override
	public OrderedInfo order(Function<RealSiteClient, Integer> order) throws NotEnoughApiAmountException {
		if(canOrder()){
			/* TODO
			 * 1. order 실행
			 * 2. 주문 후 생성된 결과를 ResponseOrderApi로 변환
			 */
			Integer orderId = order.apply(realSiteClient);
		}
		return null;
	}

	private boolean canOrder(){
		isMoneyEnough();
		//TODO need to add more validation
		return true;
	}

	private void isMoneyEnough(){
		//TODO implement => if(apiAmount < orderPrice) throw new NotEnoughApiAmountException();
		//근데 어차피 금액이 부족하면 error를 던지니까 굳이 확인할 필요 없지 않나?
	}
}
