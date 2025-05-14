package developer.ezandro.repositories;

import developer.ezandro.domain.Student;
import developer.ezandro.exceptions.StudentNotFoundException;
import developer.ezandro.utils.MessageProvider;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(this.students);
    }

    public Student findById(long id) {
        return this.students
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(MessageProvider.getStudentNotFoundMessage(id)));
    }
}