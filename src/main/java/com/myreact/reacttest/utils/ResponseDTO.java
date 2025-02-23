package com.myreact.reacttest.utils;

public class ResponseDTO {
    private boolean success;
    private String errorMessage;

    public ResponseDTO(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public static ResponseDTO success() {
        return new ResponseDTO(true, null);
    }

    public static ResponseDTO error(String errorMessage) {
        return new ResponseDTO(false, errorMessage);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

