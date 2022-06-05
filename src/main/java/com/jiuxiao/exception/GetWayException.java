package com.jiuxiao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 502 网关错误
 * @Author: 悟道九霄
 * @Date: 2022年05月30日 12:13
 * @Version: 1.0.0
 */
@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class GetWayException extends RuntimeException {

    public GetWayException() {
    }

    public GetWayException(String message) {
        super(message);
    }

    public GetWayException(String message, Throwable cause) {
        super(message, cause);
    }
}