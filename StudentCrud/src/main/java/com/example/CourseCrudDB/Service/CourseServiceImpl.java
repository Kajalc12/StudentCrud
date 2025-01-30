package com.example.CourseCrudDB.Service;

import com.example.CourseCrudDB.Domain.Courses;
import com.example.CourseCrudDB.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //    List<Courses> list;
    public CourseServiceImpl(){
//        list=new ArrayList<>();
//        list.add(new Courses(145,"Java Core Course","this course is for java"));
//        list.add(new Courses(143,"Spring Boot Course","this course is for Springboot"));
    }
    @Override
    public List<Courses> getCourse()
    {
        return courseRepository.findAll();
    }

    @Override
    public Courses getCourseById(long courseId)
    {
//        Courses c=null;
//        for(Courses courses:list)
//        {
//            if(courses.getId()==courseId)
//            {
//                c=courses;
//                break;
//            }
//        }
//
        return courseRepository.getOne(courseId);
    }

    @Override
    public Courses addCourse(Courses course)
    {
//        list.add(course);
//        return course;
        courseRepository.save(course);
        return course;
    }

    @Override
    public Courses updateCourse(Courses courses) {
//        list.forEach(e->{
//            if(e.getId()==courses.getId()){
//            e.setTitle(courses.getTitle());
//            e.setDescription(courses.getDescription());
//            }
//        });
//          return courses;
        courseRepository.save(courses);
        return courses;
    }


@Override
public void deleteCourse(long courseId)
{
//        list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
Courses entity=courseRepository.getReferenceById(courseId);
courseRepository.delete(entity);

}
}
