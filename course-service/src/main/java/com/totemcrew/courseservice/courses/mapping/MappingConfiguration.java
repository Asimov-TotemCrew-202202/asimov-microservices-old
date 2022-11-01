package com.totemcrew.courseservice.courses.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("courseMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public CourseMapper courseMapper() { return new CourseMapper(); }
}
