package developer.ezandro.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Enrollment {
    private static long idCounter = 1;
    private final long id;
    private final Student student;
    private final Course course;
    private final LocalDate enrollmentDate;

    public Enrollment(Student student, Course course) {
        this.id = idCounter++;
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
    }

    public long getId() {
        return this.id;
    }

    public Student getStudent() {
        return this.student;
    }

    public Course getCourse() {
        return this.course;
    }

    private String getFormattedEnrollmentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.enrollmentDate.format(formatter);
    }

    @Override
    public String toString() {
        return String.format("""
                --- Enrollment ---
                ID: %d
                Student: %s
                Course: %s
                Workload: %d
                Date: %s
                """, this.id, this.student.getName(), this.course.getName(), this.getCourse().getWorkload(), this.getFormattedEnrollmentDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Enrollment that = (Enrollment) o;

        return this.student.getId() == that.student.getId() &&
                this.course.getId() == that.course.getId();
    }

    @Override
    public int hashCode() {
        return 31 * Long.hashCode(this.student.getId()) +
                Long.hashCode(this.course.getId());
    }
}