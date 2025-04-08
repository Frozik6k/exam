package org.skypro.exam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.controller.error.NotQuestionException;
import org.skypro.exam.model.Question;
import org.skypro.exam.service.util.QuestionFixed;

import java.util.Collection;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @InjectMocks
    JavaQuestionService javaQuestionService;

    @Test
    void thenNoQuestionException() {
        Assertions.assertThrows(NotQuestionException.class, () -> {
            javaQuestionService.getRandomQuestion();
        });
    }

    @Test
    void giveQuestion_thenSameRemoveQuestion() {
        Question question = QuestionFixed.getQuestion();
        Assertions.assertSame(question, javaQuestionService.remove(question));
    }

    @Test
    void giveQuestionAnswer_whenNewQuestion_thenAddQuestion() {
        String question = "question";
        String answer = "answer";

        Question question1 = new Question(question, answer);

        Assertions.assertEquals(question1, javaQuestionService.add(question, answer));

    }

    @Test
    void giveQuestion_whenAdd_thenGetRandomQuestionQuestion() {
        String question = "question";
        String answer = "answer";

        javaQuestionService.add(question, answer);

        Assertions.assertNotNull(javaQuestionService.getRandomQuestion());
    }

    @Test
    void giveQuestions_whenAdd_thenGetAllSize() {
        String question1 = "question1";
        String answer1 = "answer1";
        String question2 = "question2";
        String answer2 = "answer2";

        Collection<Question> questions = new HashSet<>();
        questions.add(new Question(question1, answer1));
        questions.add(new Question(question2, answer2));
        javaQuestionService.add(question1, answer1);
        javaQuestionService.add(question2, answer2);

        assertThat(javaQuestionService.getAll())
                .hasSize(questions.size());
    }



}
