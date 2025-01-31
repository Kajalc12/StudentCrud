package com.example.CourseCrudDB.Repository;

import com.example.CourseCrudDB.Domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long>
{

}
