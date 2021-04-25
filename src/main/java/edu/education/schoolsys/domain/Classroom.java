package edu.education.schoolsys.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "classroom_id")
    private Long id;
    private String className;
    private int number;
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "classroom_students",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> students;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "adviser_id")
    private User adviser;

}
