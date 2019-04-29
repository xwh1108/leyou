package com.shopping.common.advice;

import com.shopping.common.enums.ExceptionEnums;
import com.shopping.common.exception.LyException;
import com.shopping.common.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(LyException.class)
    public ResponseEntity<ExceptionResult> handlerException(LyException e){
        ExceptionEnums em=e.getExceptionEnums();
        return ResponseEntity.status(e.getExceptionEnums().getCode()).body(new ExceptionResult(em));
    }
}
