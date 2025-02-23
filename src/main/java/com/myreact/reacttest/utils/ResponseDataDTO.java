package com.myreact.reacttest.utils;

public class ResponseDataDTO<T> {
    private T responseData;
    private boolean success;
    private String errorMessage;

    public ResponseDataDTO() {
    }

    private ResponseDataDTO(T responseData, boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.responseData = responseData;
    }

    public static <T> ResponseDataDTO<T> success(T data) {
        return new ResponseDataDTO<>(data, true, null);
    }

    public static <T> ResponseDataDTO<T> error(String errorId) {
        return new ResponseDataDTO<>(null, false, errorId);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public T getResponseData() {
        return responseData;
    }
}

