package com.example.CourseCrudDB.Service;


import com.example.CourseCrudDB.Domain.Courses;

import java.util.List;

public interface CourseService
{
    public List<Courses> getCourse();
    public Courses getCourseById(long Id);
    public Courses addCourse(Courses courses);
    public Courses updateCourse(Courses courses);
    public void deleteCourse(long courseId);
}
