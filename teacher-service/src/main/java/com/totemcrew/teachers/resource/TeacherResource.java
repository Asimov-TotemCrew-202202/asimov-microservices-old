package com.totemcrew.teachers.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherResource {

    private Long id;
    private String first_name;
    private String last_name;
    private int age;
    private String email;
    private String phone;
}
