package com.chen.utiles;

import com.chen.pojo.MSG;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @author 速度
 */
@ControllerAdvice
public  class GlobalDefultExceptionHandler   {
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public MSG doHandleRuntimeException(
            RuntimeException e){
        e.printStackTrace();
        return new MSG(e);
    }
}
