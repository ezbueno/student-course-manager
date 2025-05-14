package developer.ezandro.services;

import developer.ezandro.domain.Student;
import developer.ezandro.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    private final StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student) {
        this.studentRepository.addStudent(student);
    }

    public List<Student> listAllStudents() {
        if (this.studentRepository.getAllStudents().isEmpty()) {
            return Collections.emptyList();
        }
        return new ArrayList<>(this.studentRepository.getAllStudents());
    }

    public Student findStudentById(long id) {
        return this.studentRepository.findById(id);
    }
}