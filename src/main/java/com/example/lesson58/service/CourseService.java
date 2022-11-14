package com.example.lesson58.service;

import com.example.lesson58.model.Result;
import com.example.lesson58.payload.CoursePayload;

import java.util.UUID;

public interface CourseService {
    Result saveCourse(CoursePayload coursePayload);
    Result editCourse(UUID courseId, CoursePayload coursePayload);
    Result deleteById(UUID courseId);
    Result getAll();
    Result findById(UUID courseId);
}
