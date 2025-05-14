package developer.ezandro.repositories;

import developer.ezandro.domain.Enrollment;
import developer.ezandro.exceptions.EnrollmentNotFoundException;
import developer.ezandro.utils.MessageProvider;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment) {
        this.enrollments.add(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(this.enrollments);
    }

    public Enrollment findEnrollmentById(long id) {
        return this.enrollments
                .stream()
                .filter(enrollment -> enrollment.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EnrollmentNotFoundException(MessageProvider.getEnrollmentNotFoundMessage(id)));
    }
}