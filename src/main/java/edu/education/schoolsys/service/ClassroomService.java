package edu.education.schoolsys.service;

import edu.education.schoolsys.domain.Classroom;
import edu.education.schoolsys.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Classroom getClassroomById(Long id) {
        return classroomRepository.getOne(id);
    }

    public void addClassroom(Classroom classroom) {
        classroomRepository.saveAndFlush(classroom);
    }

    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }

}
