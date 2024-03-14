package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.domain.order.Order;

public interface OrderCommandFactory {
    Order getCharge(InternalParameterForOrder parameter);
}
