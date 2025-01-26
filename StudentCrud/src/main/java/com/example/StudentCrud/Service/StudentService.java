package com.example.StudentCrud.Service;

import com.example.StudentCrud.Domain.Student;
import com.example.StudentCrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository repo;
   public List<Student> listAll()
   {
return repo.findAll();
   }
   public void save(Student std)
   {
       repo.save(std);
   }

   public Student update(Long id)
   {
     return repo.findById(id).get();
   }
   public void delete(Long id)
   {
       repo.deleteById(id);
   }
}
