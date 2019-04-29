package com.shopping.common.vo;

import com.shopping.common.enums.ExceptionEnums;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnums em) {
        status=em.getCode();
        message=em.getMsg();
        timestamp=System.currentTimeMillis();
    }
}
