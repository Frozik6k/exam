package org.skypro.exam.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomConfiguration {

    @Bean
    public Random myRandomInstance() {
        return new Random();
    }
}
