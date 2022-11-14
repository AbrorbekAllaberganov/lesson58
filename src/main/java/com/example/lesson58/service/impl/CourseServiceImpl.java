package com.example.lesson58.service.impl;

import com.example.lesson58.entity.Course;
import com.example.lesson58.exeption.ResourceNotFound;
import com.example.lesson58.model.Result;
import com.example.lesson58.payload.CoursePayload;
import com.example.lesson58.repository.CourseRepository;
import com.example.lesson58.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;


    @Override
    public Result saveCourse(CoursePayload coursePayload) {
        try {
            Course course=Course.builder()
                    .name(coursePayload.getName())
                    .price(coursePayload.getPrice())
                    .build();
            courseRepository.save(course);
            return Result.successStatic(course);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.failedStatic(e);
        }
    }

    @Override
    public Result editCourse(UUID courseId, CoursePayload coursePayload) {
        return null;
    }

    @Override
    public Result deleteById(UUID courseId) {
        return null;
    }

    @Override
    public Result getAll() {
        return null;
    }

    @Override
    public Result findById(UUID courseId) {
        try {
            return Result.successStatic(courseRepository.findById(courseId).orElseThrow(
                    ()->new ResourceNotFound("course","id",courseId)
            ));
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.failedStatic(e);
        }
    }
}
