package com.snsclicksystem.main.domain.order;

import com.snsclicksystem.main.application.service.order.InternalParameterForOrder;
import com.snsclicksystem.main.domain.order.dto.OrderedInfoDto;
import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Order {
    protected final InternalParameterForOrder parameter;

    /**
     * 주문 실행 및 실행 전후의 공통처리
     * @return 주문 결과
     * @throws NotEnoughApiAmountException 주문을 실행할 수 있는 api가 부족할 때
     */
    public final OrderedInfoDto execute() throws NotEnoughApiAmountException, NotEnoughConsumerAmountException {
        canOrder();
        return order();
    }


    //TODO 이 부분에서 각각의 주문에 맞는 정보 실행 후 알맞은 값 리턴
    private void canOrder() throws NotEnoughConsumerAmountException{
        isMoneyEnough();
    }
    private void isMoneyEnough() throws NotEnoughConsumerAmountException{
        if(parameter.getMember().getTotalAmount() < getPrice()){
            throw new NotEnoughConsumerAmountException();
        }
    }

    protected abstract OrderedInfoDto order() throws NotEnoughApiAmountException;
    protected abstract Long getPrice();
}
