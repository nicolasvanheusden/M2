package fr.uge.jee.springmvc.reststudents.controller;

import fr.uge.jee.springmvc.reststudents.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private final Map<Long, Student> students = Map.of(
    1L, new Student(1L,"Léo", "Garnier"),
    2L, new Student(2L, "Léa", "Garnier")
    );

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") long id) {
        var student = students.get(id);
        if (student==null){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No student with id ("+id+")");
        } else {
            return student;
        }
    }

    @GetMapping("/students/")
    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }


}
