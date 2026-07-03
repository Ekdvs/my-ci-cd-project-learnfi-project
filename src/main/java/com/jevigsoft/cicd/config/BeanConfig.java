package com.jevigsoft.cicd.config;


import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static com.jevigsoft.cicd.constants.AppConstants.PatternConstants.DATE_TIME_RESPONSE_PATTERN;
import static com.jevigsoft.cicd.constants.AppConstants.PatternConstants.TIME_ZONE;

/**
 * @author Navishka Darshana - navishka@learnfi.lk
 * @project my-cicd-project
 * @CreatedBy IntelliJ IDEA
 * @created 26/08/2024 - 23.16
 */

@EnableCaching
@EnableScheduling
@EnableAsync
@Configuration
@Log4j2
public class BeanConfig implements Jackson2ObjectMapperBuilderCustomizer {

    private final Environment environment;

    public BeanConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_RESPONSE_PATTERN)
                .withZone(ZoneId.of(TIME_ZONE));
        LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(formatter);

        builder.failOnEmptyBeans(false) // prevent InvalidDefinitionException Error
                .serializerByType(LocalDateTime.class, localDateTimeSerializer);
    }
}
