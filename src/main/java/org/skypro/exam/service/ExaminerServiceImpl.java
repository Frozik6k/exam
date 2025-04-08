package org.skypro.exam.service;

import org.skypro.exam.controller.error.NumberQuestionsExceededException;
import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

// будет использовать QuestionService
@Service
public class ExaminerServiceImpl implements ExaminerService {

    JavaQuestionService questionService;

    private Set<Question> questions;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
        questions = new HashSet<>();
    }

    public Collection<Question> getRandomQuestion(int amount) {

        if (questionService.getAll().size() < amount) throw new NumberQuestionsExceededException();

        if (questionService.getAll().size() == amount) return questionService.getAll();

        List<Question> questions = new ArrayList<>(questionService.getAll());

        if (questions.size() < amount) throw new NumberQuestionsExceededException();

        Set<Question> questionsExam = new HashSet<>();
        Random random = new Random();
        while (questionsExam.size() < amount) {
            Question question = questions.get(random.nextInt(questions.size()));
            questionsExam.add(question);
            questions.remove(question);
        }

        this.questions = questionsExam;

        return questionsExam;
    }
}
