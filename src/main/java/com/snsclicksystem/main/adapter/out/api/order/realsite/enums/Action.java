package com.snsclicksystem.main.adapter.out.api.order.realsite.enums;

public enum Action {
    ADD("add"), BALANCE("balance");


    Action(String message) {
        this.message = message;
    }
    String message;

    public String getMessage() {
        return message;
    }
}
