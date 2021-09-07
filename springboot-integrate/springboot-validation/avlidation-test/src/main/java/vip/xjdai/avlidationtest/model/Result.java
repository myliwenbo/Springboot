package vip.xjdai.avlidationtest.model;

import lombok.Data;

@Data
public class Result {

    private String errorMessage;
    private String message;


    public static Result fail(String errorMessage, String message) {
        Result result = new Result();
        result.setErrorMessage(errorMessage);
        result.setMessage(message);
        return result;
    }
}
