package developer.ezandro.ui;

import developer.ezandro.domain.Course;
import developer.ezandro.domain.Enrollment;
import developer.ezandro.domain.Student;
import developer.ezandro.exceptions.CourseNotFoundException;
import developer.ezandro.exceptions.StudentNotFoundException;
import developer.ezandro.services.CourseManager;
import developer.ezandro.services.EnrollmentManager;
import developer.ezandro.services.StudentManager;
import developer.ezandro.utils.MessageProvider;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class EnrollmentInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    private EnrollmentInput() {
    }

    public static Enrollment readEnrollmentData(
            StudentManager studentManager,
            CourseManager courseManager,
            EnrollmentManager enrollmentManager
    ) {
        System.out.println(MessageProvider.CANCELLATION_HINT);
        System.out.println(MessageProvider.PROVIDE_DETAILS);

        while (true) {
            try {
                System.out.println(MessageProvider.INPUT_ENROLLMENT_STUDENT_ID_PROMPT);
                long studentId = SCANNER.nextLong();

                if (studentId == 0) {
                    return null;
                }

                Student student = studentManager.findStudentById(studentId);

                System.out.println(MessageProvider.INPUT_ENROLLMENT_COURSE_ID_PROMPT);
                long courseId = SCANNER.nextLong();

                if (courseId == 0) {
                    return null;
                }

                Course course = courseManager.findCourseById(courseId);

                Enrollment enrollment = enrollmentManager.enrollStudent(student, course);

                if (Objects.isNull(enrollment)) {
                    System.out.println(MessageProvider.getEnrollmentAlreadyExistsMessage());
                    System.out.println(MessageProvider.TRY_AGAIN_OR_CANCEL);
                } else {
                    return enrollment;
                }

            } catch (InputMismatchException e) {
                System.out.println(MessageProvider.INVALID_ID_RETRY);
                SCANNER.nextLine();
            } catch (StudentNotFoundException | CourseNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println(MessageProvider.CHECK_IDS_OR_CANCEL);
            }
        }
    }
}