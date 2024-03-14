package com.snsclicksystem.main.domain.order;

import com.snsclicksystem.main.adapter.out.api.order.dto.OrderedInfo;
import com.snsclicksystem.main.application.service.order.InternalParameterForOrder;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Order {
    protected final InternalParameterForOrder parameter;

    /**
     * 주문 실행 및 실행 전후의 공통처리
     * @return 주문 결과
     * @throws NotEnoughApiAmountException 주문을 실행할 수 있는 api가 부족할 때
     */
    public final OrderedInfo execute() throws NotEnoughApiAmountException{
        if(canOrder()){
            /* TODO
             * 1. order 실행
             * 2. 주문 후 생성된 결과를 Order 로 변환
             */
            return order();
        }
        return null;
    }


    //TODO 이 부분에서 각각의 주문에 맞는 정보 실행
    protected abstract OrderedInfo order() throws NotEnoughApiAmountException;

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
