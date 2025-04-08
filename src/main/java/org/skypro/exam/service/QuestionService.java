package org.skypro.exam.service;

import org.skypro.exam.model.Question;

import java.util.Collection;

// В нем должны быть методы работы с вопросами определенного предмета
public interface QuestionService {
    public Question add(String question, String answer);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion();

}

