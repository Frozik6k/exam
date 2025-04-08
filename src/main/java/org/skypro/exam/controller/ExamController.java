package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.ExaminerService;
import org.skypro.exam.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/exam/get", method = RequestMethod.GET)
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return service.getRandomQuestion(amount);
    }

}
