package org.skypro.exam.service;

import org.skypro.exam.model.Question;

import java.util.Collection;
import java.util.Collections;

public interface ExaminerService {

    // Возвращает список вопросов
    public Collection<Question> getRandomQuestion(int amount);
}
