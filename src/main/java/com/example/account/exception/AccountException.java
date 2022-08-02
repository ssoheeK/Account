package com.example.account.exception;

import com.example.account.type.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountException extends RuntimeException{
    private ErrorCode errorCode;
    private String errorMessage;

    public AccountException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
