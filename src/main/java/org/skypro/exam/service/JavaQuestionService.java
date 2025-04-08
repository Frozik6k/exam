package org.skypro.exam.service;

import org.skypro.exam.controller.error.NotQuestionException;
import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionService() {
        questions = new HashSet<>();
    }

    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;
    }

    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NotQuestionException();
        }
        List<Question> questionList = new ArrayList<>(questions);
        Random random = new Random();
        return questionList.get(random.nextInt(questionList.size()));
    }
}
