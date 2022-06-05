package com.jiuxiao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 500 服务器内部错误
 * @Author: 悟道九霄
 * @Date: 2022年05月30日 11:51
 * @Version: 1.0.0
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerInnerException extends RuntimeException {
    public ServerInnerException() {
    }

    public ServerInnerException(String message) {
        super(message);
    }

    public ServerInnerException(String message, Throwable cause) {
        super(message, cause);
    }
}