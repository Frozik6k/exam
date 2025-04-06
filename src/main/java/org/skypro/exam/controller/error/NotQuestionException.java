package org.skypro.exam.controller.error;

public class NotQuestionException extends RuntimeException{
    public NotQuestionException() {
        super("В базе отсутствуют вопросы");
    }
}
