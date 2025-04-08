package org.skypro.exam.controller.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExamControllerAdvice {

    @ExceptionHandler(NumberQuestionsExceededException.class)
    public ResponseEntity<ExamError> handleNumberQuestionsExceededException(NumberQuestionsExceededException e) {
        // Возвращаем статус 400 Bad Request с сообщением об ошибке
        return ResponseEntity.badRequest().body(new ExamError("превышен параметр", "Число запрошенных вопросов больше чем есть в базе"));
    }
    @ExceptionHandler(NotQuestionException.class)
    public ResponseEntity<ExamError> handleNumberQuestionsExceededException(NotQuestionException e) {
        // Возвращаем статус 400 Bad Request с сообщением об ошибке
        return ResponseEntity.badRequest().body(new ExamError("База пуста", "В базе отсутствуют вопросы"));
    }




}
