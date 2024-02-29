package com.snsclicksystem.main.adapter.in.common;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiExceptionEntity {
    private final String errorCode;
    private final String errorMessage;

    @Builder
    public ApiExceptionEntity(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
