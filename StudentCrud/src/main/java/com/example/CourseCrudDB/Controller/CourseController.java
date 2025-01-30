package com.example.CourseCrudDB.Controller;

import com.example.CourseCrudDB.Domain.Courses;
import com.example.CourseCrudDB.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController
{

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home()
    {
        return  "this is my home";
    }

    @GetMapping("/courses")
    public List<Courses> getcourses()
    {
        return this.courseService.getCourse();
    }

    @GetMapping("/courses/{courseId}")
    public Courses getSpecificCourseById(@PathVariable String courseId)
    {
        return this.courseService.getCourseById(Long.parseLong(courseId));
    }

    @PostMapping("/addCourse")
    public Courses addCourses(@RequestBody Courses courses)
    {
        return this.courseService.addCourse(courses);
    }

    @PutMapping("/updatecourses")
    public Courses updateCourse(@RequestBody Courses courses)
    {
        return this.courseService.updateCourse(courses);
    }

    @DeleteMapping("/deletecourses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
    {
        try
        {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            System.out.println("record is deleted successfully");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
