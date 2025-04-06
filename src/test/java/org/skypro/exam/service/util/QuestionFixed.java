package org.skypro.exam.service.util;

import org.skypro.exam.model.Question;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionFixed  {
    public static Collection<Question> getQuestions (int count) {
        Set<Question> questions = Stream.iterate(1, m -> m + 1)
                .limit(count)
                .map(m -> new Question("Question " + m.toString(), "Answer " + m.toString()))
                .collect(Collectors.toSet());
    return questions;
    }
}
