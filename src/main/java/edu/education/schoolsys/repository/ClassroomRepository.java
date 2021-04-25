package edu.education.schoolsys.repository;

import edu.education.schoolsys.domain.Classroom;
import edu.education.schoolsys.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
