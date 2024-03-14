package com.snsclicksystem.main.adapter.out.api.order.realsite.command;

import com.snsclicksystem.main.adapter.out.api.order.dto.OrderedInfo;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.Consumer;
import com.snsclicksystem.main.domain.consumer.OrderCommand;
import com.snsclicksystem.main.domain.order.Order;
import lombok.RequiredArgsConstructor;

/**
 * Real site에 주문 요청을 하는 command
 * 주문 실행 전후의 공통처리를 맡는다.
 */
@RequiredArgsConstructor
public abstract class RealSiteOrderCommand implements OrderCommand {
    protected final RealSiteClient realSiteClient;

    /**
     * 주문 실행 및 실행 전후의 공통처리
     * @param consumer 주문을 실행할 사용자
     * @return 주문 결과
     * @throws NotEnoughApiAmountException 주문을 실행할 수 있는 api가 부족할 때
     */
    @Override
    public final Order execute(Consumer consumer) throws NotEnoughApiAmountException{
        if(canOrder()){
            /* TODO
             * 1. order 실행
             * 2. 주문 후 생성된 결과를 Order 로 변환
             */
            return toOrder(order());
        }
        return null;
    }

    protected abstract OrderedInfo order();

    private boolean canOrder(){
        isMoneyEnough();
        //TODO need to add more validation
        return true;
    }

    private void isMoneyEnough(){
        //TODO implement => if(apiAmount < orderPrice) throw new NotEnoughApiAmountException();
        //근데 어차피 금액이 부족하면 error를 던지니까 굳이 확인할 필요 없지 않나?
    }

    private Order toOrder(OrderedInfo orderedInfo){
        //TODO need to implement
        return null;
    }
}
