package com.snsclicksystem.main.application.port.in.item;

public class ItemNotFoundException extends Exception{
    private static final String DEFAULT_MESSAGE = "존재하지 않는 item입니다.";


    public ItemNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
