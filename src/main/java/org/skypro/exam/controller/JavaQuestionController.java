package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.JavaQuestionService;
import org.skypro.exam.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

// должен позволять пользователю добавлять, просматривать и удалять вопросы по Java.
@RestController
public class JavaQuestionController {

    JavaQuestionService service;

    JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }

    // Добавить вопрос:
    @GetMapping("/exam/java/add")
    Question addQuestion(@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {

        return service.add(question, answer);
    }

    // Удалить вопрос:
    @GetMapping("/exam/java/remove")
    Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return service.remove(new Question(question, answer));
    }

    // Получить все вопросы
    @GetMapping("/exam/java")
    Collection<Question> getQuestion() {
        return service.getAll();
    }

    // Получить случайный вопрос с ответом
    @GetMapping("/exam/java/find")
    Question find() {
        return service.getRandomQuestion();
    }
}
