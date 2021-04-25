package edu.education.schoolsys.controller;

import edu.education.schoolsys.domain.Classroom;
import edu.education.schoolsys.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    ClassroomService service;

    @PostMapping()
    public void createClassroom(@RequestBody Classroom classroom) {
        service.addClassroom(classroom);
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable("id") Long id) {
        service.deleteClassroom(id);
    }

    @GetMapping("/{id}")
    public Classroom getClassroomById(@PathVariable("id") Long id) {
        return service.getClassroomById(id);
    }

    @GetMapping()
    public List<Classroom> getAllClassroom() {
        return service.getAllClassrooms();
    }

}
