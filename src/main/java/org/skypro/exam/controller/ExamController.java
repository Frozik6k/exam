package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.ExaminerService;
import org.skypro.exam.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    ExaminerServiceImpl service;

    public ExamController(ExaminerServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/exam/get")
    Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return service.getRandomQuestion(amount);
    }

}
