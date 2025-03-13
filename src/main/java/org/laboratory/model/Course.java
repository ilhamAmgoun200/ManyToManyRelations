package org.laboratory.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private Set<org.laboratory.model.Student> students = new HashSet<>();

    public Course() {}

    public Course(String title) {
        this.title = title;
    }

    public Set<org.laboratory.model.Student> getStudents() {
        return students;
    }

    public String getTitle() {
        return title;
    }
}
