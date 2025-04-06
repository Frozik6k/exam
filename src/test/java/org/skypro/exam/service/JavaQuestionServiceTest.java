package org.skypro.exam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.controller.error.NotQuestionException;

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

}
