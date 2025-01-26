package com.example.StudentCrud.Controller;

import ch.qos.logback.core.model.Model;
import com.example.StudentCrud.Domain.Student;
import com.example.StudentCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

public class StudentController
{
    @Autowired
    private StudentService service;

   // @GetMapping("/")
    @GetMapping("/new")
    public String add(Student model) {
        model.listAll("student", new Student());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std) {
        service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("new");
        Student std = service.update(id);
        mav.addObject("student", std);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id")Long id) {
        service.delete(id);
        return "redirect:/";
    }


}
