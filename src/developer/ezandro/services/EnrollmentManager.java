package developer.ezandro.services;

import developer.ezandro.domain.Course;
import developer.ezandro.domain.Enrollment;
import developer.ezandro.domain.Student;
import developer.ezandro.repositories.EnrollmentRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnrollmentManager {
    private final EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    public Enrollment enrollStudent(Student student, Course course) {
        boolean alreadyEnrolled = this.getAllEnrollments().stream()
                .anyMatch(enrollment -> enrollment.getStudent().getId() == student.getId()
                        && enrollment.getCourse().getId() == course.getId());

        if (alreadyEnrolled) {
            return null;
        }

        Enrollment enrollment = new Enrollment(student, course);
        this.enrollmentRepository.addEnrollment(enrollment);
        return enrollment;
    }

    public List<Enrollment> getAllEnrollments() {
        return this.enrollmentRepository.getAllEnrollments();
    }

    public Enrollment findEnrollmentById(long id) {
        return this.enrollmentRepository.findEnrollmentById(id);
    }

    public Map<Course, List<Enrollment>> getCoursesWithEnrollments() {
        return this.enrollmentRepository.getAllEnrollments()
                .stream()
                .collect(Collectors.groupingBy(
                        Enrollment::getCourse,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }

    public Map<Student, List<Course>> getStudentsWithCourses() {
        return this.enrollmentRepository.getAllEnrollments()
                .stream()
                .collect(Collectors.groupingBy(
                        Enrollment::getStudent,
                        LinkedHashMap::new,
                        Collectors.mapping(
                                Enrollment::getCourse,
                                Collectors.toList()
                        )
                ));
    }

    public List<Enrollment> getEnrollmentsByStudentId(long studentId) {
        return this.enrollmentRepository.getAllEnrollments()
                .stream()
                .filter(enrollment -> enrollment.getStudent().getId() == studentId)
                .toList();
    }
}