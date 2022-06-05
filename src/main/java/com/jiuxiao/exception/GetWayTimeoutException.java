package com.jiuxiao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 504 网络超时
 * @Author: 悟道九霄
 * @Date: 2022年05月30日 14:40
 * @Version: 1.0.0
 */
@ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
public class GetWayTimeoutException extends RuntimeException {

    public GetWayTimeoutException() {
    }

    public GetWayTimeoutException(String message) {
        super(message);
    }

    public GetWayTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}