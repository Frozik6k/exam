package org.skypro.exam.controller.error;

// Исключение если запрос количества вопросов больше чем есть в базе
public class NumberQuestionsExceededException extends RuntimeException {
    public NumberQuestionsExceededException() {
        super("Превышено количество вопросов");
    }
}
