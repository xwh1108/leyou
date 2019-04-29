package com.shopping.common.exception;

import com.shopping.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LyException extends RuntimeException {
    private ExceptionEnums exceptionEnums;

}
