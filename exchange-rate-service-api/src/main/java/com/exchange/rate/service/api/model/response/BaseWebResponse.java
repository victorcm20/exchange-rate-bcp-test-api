package com.exchange.rate.service.api.model.response;

import com.exchange.rate.service.api.model.enums.ErrorCode;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseWebResponse<T> {
    private ErrorCode errorCode;
    private T data;

    public static BaseWebResponse successNoData() {
        return BaseWebResponse.builder()
                .build();
    }

    public static <T> BaseWebResponse<T> successWithData(T data) {
        return BaseWebResponse.<T>builder()
                .data(data)
                .build();
    }

    public static BaseWebResponse error(ErrorCode errorCode, String d) {
        return BaseWebResponse.builder()
                .errorCode(errorCode)
                .data(d)
                .build();
    }
}
