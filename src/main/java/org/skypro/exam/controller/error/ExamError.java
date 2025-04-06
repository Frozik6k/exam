package org.skypro.exam.controller.error;

final public class ExamError {

    private String code;

    private String message;

    public ExamError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
