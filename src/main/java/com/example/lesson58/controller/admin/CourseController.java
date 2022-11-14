package com.example.lesson58.controller.admin;

import com.example.lesson58.model.Result;
import com.example.lesson58.payload.CoursePayload;
import com.example.lesson58.service.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImpl courseService;

    @PostMapping
    public ResponseEntity<Result> saveCourse(@RequestBody CoursePayload coursePayload){
        Result result=courseService.saveCourse(coursePayload);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> findCourseById(@PathVariable("id")UUID courseId){
        Result result=courseService.findById(courseId);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }


}
