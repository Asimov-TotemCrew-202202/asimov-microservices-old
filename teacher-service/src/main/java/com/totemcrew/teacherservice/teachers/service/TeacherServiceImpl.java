package com.totemcrew.teacherservice.teachers.service;

import com.totemcrew.teacherservice.shared.exception.ResourceNotFoundException;
import com.totemcrew.teacherservice.shared.exception.ResourceValidationException;
import com.totemcrew.teacherservice.shared.mapping.EnhancedModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class TeacherServiceImpl implements com.totemcrew.teacherservice.teachers.domain.service.TeacherService {

    private static final Logger logger = LoggerFactory.getLogger(com.totemcrew.teacherservice.teachers.service.TeacherServiceImpl.class);

    private static final String ENTITY = "Teacher";
    @Autowired
    private com.totemcrew.teacherservice.teachers.domain.persistence.TeacherRepository teacherRepository;
    @Autowired
    private Validator validator;

    @Autowired
    EnhancedModelMapper mapper;

    /*public TeacherServiceImpl(TeacherRepository teacherRepository, Validator validator) {
        this.teacherRepository = teacherRepository;
        this.validator = validator;
    }*/

    @Override
    public List<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Page<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher> getAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher getById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow( () -> new ResourceNotFoundException(ENTITY, teacherId));
    }

    @Override
    public com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher create(com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher teacher) {
        Set<ConstraintViolation<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher>> violations = validator.validate(teacher);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        var existingEmail = teacherRepository.existsByEmail(teacher.getEmail());
        if(existingEmail) {
            throw new ResourceValidationException("email is already taken");
        }

        return teacherRepository.save(teacher);
    }

    @Override
    public com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher update(Long teacherId, com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher teacher) {
        Set<ConstraintViolation<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher>> violations = validator.validate(teacher);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return teacherRepository.findById(teacherId).map( data ->
                teacherRepository.save(
                        data.withFirst_name(teacher.getFirst_name())
                                .withLast_name(teacher.getLast_name())
                                .withAge(teacher.getAge())
                                .withEmail(teacher.getEmail())
                                .withPhone(teacher.getPhone()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, teacherId));
    }

    @Override
    public ResponseEntity<?> delete(Long teacherId) {
        return teacherRepository.findById(teacherId).map(data -> {
            teacherRepository.delete(data);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, teacherId));
    }
}
