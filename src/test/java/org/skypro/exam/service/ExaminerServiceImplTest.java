package org.skypro.exam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.controller.error.NumberQuestionsExceededException;
import org.skypro.exam.service.util.QuestionFixed;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void whenQuestionServiceGetAll_thenCountQuestions(int amount) {
        int allCountQuestions = 10;

        when(questionService.getAll())
                .thenReturn(QuestionFixed.getQuestions(allCountQuestions));

        assertThat(examinerServiceImpl.getRandomQuestion(amount))
                .hasSize(amount);
    }

    @Test
    void whenQuestionServiceGetAll_thenCountQuestionsException() {
        int allCountQuestions = 1;
        int amount = 2;
        when(questionService.getAll())
                .thenReturn(QuestionFixed.getQuestions(allCountQuestions));

        Assertions.assertThrows(NumberQuestionsExceededException.class, () -> {
            examinerServiceImpl.getRandomQuestion(amount);
        });

    }



}
