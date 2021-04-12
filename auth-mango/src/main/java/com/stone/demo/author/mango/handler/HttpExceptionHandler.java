package com.stone.demo.author.mango.handler;

import com.stone.demo.author.mango.bean.vo.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 *
 * @Class HttpExceptionHandler
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  上午11:31
 * @Version 1.0
 */
@RestControllerAdvice
public class HttpExceptionHandler {

    public static final Logger log = LoggerFactory.getLogger(HttpExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public HttpResult apiExceptionHandler(Exception ex) {
        log.error(ex.getMessage(), ex);
        return HttpResult.error(500, ex.getMessage());
    }
}
