package com.example.webfluxdemo.core.dto.response;

import com.example.webfluxdemo.core.enums.ResultCode;
import lombok.Getter;

@Getter
public class SingleResponse<T> {
    private final ResultCode result;
    private final T data;

    public SingleResponse(T data) {
        this.result = ResultCode.SUCCESS;
        this.data = data;
    }

    public SingleResponse(T data, ResultCode code) {
        this.result = code;
        this.data = data;
    }
}
