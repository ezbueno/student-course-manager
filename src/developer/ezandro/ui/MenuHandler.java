package developer.ezandro.ui;

import developer.ezandro.domain.Course;
import developer.ezandro.domain.Enrollment;
import developer.ezandro.domain.Student;
import developer.ezandro.exceptions.CourseNotFoundException;
import developer.ezandro.exceptions.EnrollmentNotFoundException;
import developer.ezandro.exceptions.StudentAlreadyEnrolledException;
import developer.ezandro.exceptions.StudentNotFoundException;
import developer.ezandro.services.CourseManager;
import developer.ezandro.services.EnrollmentManager;
import developer.ezandro.services.StudentManager;
import developer.ezandro.utils.MessageProvider;

import java.util.*;

public class MenuHandler {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final StudentManager STUDENT_MANAGER = new StudentManager();
    private static final CourseManager COURSE_MANAGER = new CourseManager();
    private static final EnrollmentManager ENROLLMENT_MANAGER = new EnrollmentManager();

    private MenuHandler() {
    }

    public static void handleMainMenu() {
        boolean running = true;

        MessageProvider.displayMainMenu();

        while (running) {
            try {
                int option = SCANNER.nextInt();

                while (option < 1 || option > 5) {
                    System.out.println(MessageProvider.MAIN_MENU_INVALID_OPTION);
                    option = SCANNER.nextInt();
                }

                if (option == 5) {
                    running = false;
                    exitProgram();
                } else {
                    handleSelectedOption(option);
                }

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.MAIN_MENU_INVALID_OPTION);
                SCANNER.nextLine();
            }
        }
    }

    private static void handleSelectedOption(int option) {
        switch (option) {
            case 1 ->
                    handleStudentsMenu();
            case 2 ->
                    handleCoursesMenu();
            case 3 ->
                    handleEnrollmentsMenu();
            case 4 ->
                    handleViewReports();
            case 5 ->
                    exitProgram();
            default ->
                    System.out.println(MessageProvider.MAIN_MENU_INVALID_OPTION);
        }
    }

    private static void exitProgram() {
        System.out.println(MessageProvider.PROGRAM_EXIT_MESSAGE);
    }

    private static void handleStudentsMenu() {
        boolean isValidOption = true;

        MessageProvider.displayStudentsMenu();

        while (isValidOption) {
            try {
                int option = SCANNER.nextInt();

                switch (option) {
                    case 1 ->
                            handleAddStudent();
                    case 2 ->
                            handleListAllStudents();
                    case 3 ->
                            handleFindStudentById();
                    case 4 -> {
                        isValidOption = false;
                        MessageProvider.displayMainMenu();
                    }
                    default ->
                            System.out.println(MessageProvider.SUBMENU_STUDENT_INVALID_OPTION);
                }

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.SUBMENU_STUDENT_INVALID_OPTION);
                SCANNER.nextLine();
            }
        }
    }

    private static void handleAddStudent() {
        Student student = StudentInput.readStudentData();

        if (Objects.isNull(student)) {
            System.out.println(MessageProvider.OPERATION_CANCELLED);
            MessageProvider.displayStudentsMenu();
            return;
        }

        STUDENT_MANAGER.addStudent(student);
        System.out.println(MessageProvider.STUDENT_REGISTRATION_SUCCESS);
        MessageProvider.displayStudentsMenu();
    }

    private static void handleListAllStudents() {
        if (STUDENT_MANAGER.listAllStudents().isEmpty()) {
            System.out.println(MessageProvider.NO_REGISTERED_STUDENTS);
        } else {
            System.out.println(MessageProvider.STUDENT_LIST_HEADER);
            STUDENT_MANAGER.listAllStudents().forEach(System.out::println);
        }

        MessageProvider.displayStudentsMenu();
    }

    private static void handleFindStudentById() {
        boolean isValidId = true;

        System.out.println(MessageProvider.CANCELLATION_HINT);

        while (isValidId) {
            try {
                System.out.println(MessageProvider.INPUT_STUDENT_ID_PROMPT);
                long id = SCANNER.nextLong();

                if (id == 0) {
                    System.out.println(MessageProvider.OPERATION_CANCELLED);
                    MessageProvider.displayStudentsMenu();
                    return;
                }

                Student student = STUDENT_MANAGER.findStudentById(id);
                System.out.println(student);

                isValidId = false;
                MessageProvider.displayStudentsMenu();

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.INVALID_ID);
                SCANNER.nextLine();
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void handleCoursesMenu() {
        boolean isValidOption = true;

        MessageProvider.displayCoursesMenu();

        while (isValidOption) {
            try {
                int option = SCANNER.nextInt();

                switch (option) {
                    case 1 ->
                            handleAddCourse();
                    case 2 ->
                            handleListAllCourses();
                    case 3 ->
                            handleFindCourseById();
                    case 4 -> {
                        isValidOption = false;
                        MessageProvider.displayMainMenu();
                    }
                    default ->
                            System.out.println(MessageProvider.SUBMENU_COURSE_INVALID_OPTION);
                }

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.SUBMENU_COURSE_INVALID_OPTION);
                SCANNER.nextLine();
            }
        }
    }

    private static void handleAddCourse() {
        Course course = CourseInput.readCourseData();

        if (Objects.isNull(course)) {
            System.out.println(MessageProvider.OPERATION_CANCELLED);
            MessageProvider.displayCoursesMenu();
            return;
        }

        COURSE_MANAGER.addCourse(course);
        System.out.println(MessageProvider.COURSE_REGISTRATION_SUCCESS);
        MessageProvider.displayCoursesMenu();
    }

    private static void handleListAllCourses() {
        if (COURSE_MANAGER.listAllCourses().isEmpty()) {
            System.out.println(MessageProvider.NO_REGISTERED_COURSES);
        } else {
            System.out.println(MessageProvider.COURSE_LIST_HEADER);
            COURSE_MANAGER.listAllCourses().forEach(System.out::println);
        }

        MessageProvider.displayCoursesMenu();
    }

    private static void handleFindCourseById() {
        boolean isValidId = true;

        System.out.println(MessageProvider.CANCELLATION_HINT);

        while (isValidId) {
            try {
                System.out.println(MessageProvider.INPUT_COURSE_ID_PROMPT);
                long id = SCANNER.nextLong();

                if (id == 0) {
                    System.out.println(MessageProvider.OPERATION_CANCELLED);
                    MessageProvider.displayCoursesMenu();
                    return;
                }

                Course course = COURSE_MANAGER.findCourseById(id);
                System.out.println(course);

                isValidId = false;
                MessageProvider.displayCoursesMenu();

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.INVALID_ID);
                SCANNER.nextLine();
            } catch (CourseNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void handleEnrollmentsMenu() {
        boolean isValidOption = true;

        MessageProvider.displayEnrollmentsMenu();

        while (isValidOption) {
            try {
                int option = SCANNER.nextInt();

                switch (option) {
                    case 1 ->
                            handleAddEnrollment();
                    case 2 ->
                            handleViewEnrollments();
                    case 3 ->
                            handleFindEnrollmentById();
                    case 4 -> {
                        isValidOption = false;
                        MessageProvider.displayMainMenu();
                    }
                    default ->
                            System.out.println(MessageProvider.SUBMENU_ENROLLMENT_INVALID_OPTION);
                }

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.SUBMENU_ENROLLMENT_INVALID_OPTION);
                SCANNER.nextLine();
            }
        }
    }

    private static void handleAddEnrollment() {
        Enrollment enrollment = EnrollmentInput.readEnrollmentData(STUDENT_MANAGER, COURSE_MANAGER, ENROLLMENT_MANAGER);

        if (enrollment == null) {
            System.out.println(MessageProvider.OPERATION_CANCELLED);
            MessageProvider.displayEnrollmentsMenu();
            return;
        }

        try {
            ENROLLMENT_MANAGER.enrollStudent(enrollment.getStudent(), enrollment.getCourse());
            System.out.println(MessageProvider.ENROLLMENT_SUCCESS);
            System.out.println(MessageProvider.getEnrollmentCreationSuccessMessage());

        } catch (StudentAlreadyEnrolledException _) {
            System.out.println(MessageProvider.STUDENT_ALREADY_ENROLLED);
        }

        MessageProvider.displayEnrollmentsMenu();
    }

    private static void handleViewEnrollments() {
        List<Enrollment> enrollments = ENROLLMENT_MANAGER.getAllEnrollments();

        if (enrollments.isEmpty()) {
            System.out.println(MessageProvider.getEnrollmentListEmptyMessage());
        } else {
            System.out.println(MessageProvider.ENROLLMENT_LIST_HEADER);
            enrollments.forEach(System.out::println);
        }

        MessageProvider.displayEnrollmentsMenu();
    }

    private static void handleFindEnrollmentById() {
        boolean isValidId = true;

        System.out.println(MessageProvider.CANCELLATION_HINT);

        while (isValidId) {
            try {
                System.out.println(MessageProvider.INPUT_ENROLLMENT_ID_PROMPT);
                long id = SCANNER.nextLong();

                if (id == 0) {
                    System.out.println(MessageProvider.OPERATION_CANCELLED);
                    MessageProvider.displayEnrollmentsMenu();
                    return;
                }

                Enrollment enrollment = ENROLLMENT_MANAGER.findEnrollmentById(id);
                System.out.println(enrollment);

                isValidId = false;
                MessageProvider.displayEnrollmentsMenu();

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.INVALID_ID);
                SCANNER.nextLine();
            } catch (EnrollmentNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void handleViewReports() {
        boolean isValidOption = true;

        MessageProvider.displayViewReports();

        while (isValidOption) {
            try {
                int option = SCANNER.nextInt();

                switch (option) {
                    case 1 ->
                            handleViewAllCoursesWithEnrolledStudents();
                    case 2 ->
                            handleViewAllStudentsWithEnrolledCourses();
                    case 3 ->
                            handleViewEnrollmentsByStudentId();
                    case 4 -> {
                        isValidOption = false;
                        MessageProvider.displayMainMenu();
                    }
                    default ->
                            System.out.println(MessageProvider.SUBMENU_REPORTS_INVALID_OPTION);
                }

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.SUBMENU_REPORTS_INVALID_OPTION);
                SCANNER.nextLine();
            }
        }
    }

    private static void handleViewAllCoursesWithEnrolledStudents() {
        Map<Course, List<Enrollment>> courseEnrollments = ENROLLMENT_MANAGER.getCoursesWithEnrollments();

        if (courseEnrollments.isEmpty()) {
            System.out.println(MessageProvider.NO_ENROLLMENTS_FOUND);
            MessageProvider.displayViewReports();
            return;
        }

        System.out.println(MessageProvider.COURSES_WITH_STUDENTS_HEADER);

        for (Map.Entry<Course, List<Enrollment>> entry : courseEnrollments.entrySet()) {
            Course course = entry.getKey();
            List<Enrollment> enrollments = entry.getValue();

            System.out.printf(MessageProvider.COURSE_LABEL + "%n", course.getName(), course.getId());
            System.out.println(MessageProvider.ENROLLED_STUDENTS_HEADER);

            for (Enrollment enrollment : enrollments) {
                Student student = enrollment.getStudent();
                System.out.printf(MessageProvider.STUDENT_ENTRY_WITH_ENROLLMENT + "%n",
                        student.getName(),
                        student.getId(),
                        enrollment.getId());
            }
            System.out.println();
        }

        MessageProvider.displayViewReports();
    }

    private static void handleViewAllStudentsWithEnrolledCourses() {
        Map<Student, List<Course>> studentCoursesMap = ENROLLMENT_MANAGER.getStudentsWithCourses();

        System.out.println(MessageProvider.STUDENTS_WITH_COURSES_HEADER);

        studentCoursesMap.forEach((student, courses) -> {
            System.out.printf(MessageProvider.STUDENT_ENTRY_FORMAT + "%n",
                    student.getName(),
                    student.getId());

            System.out.println(MessageProvider.ENROLLED_COURSES_HEADER);

            courses.forEach(course -> System.out.printf(MessageProvider.COURSE_ENTRY_FORMAT + "%n",
                    course.getName(),
                    course.getId()));

            System.out.println();
        });

        MessageProvider.displayViewReports();
    }

    private static void handleViewEnrollmentsByStudentId() {
        boolean isValidId = true;
        long studentId = 0;

        System.out.println(MessageProvider.CANCELLATION_HINT);

        while (isValidId) {
            try {
                System.out.println(MessageProvider.INPUT_STUDENT_ID_PROMPT);
                studentId = SCANNER.nextInt();

                if (studentId == 0) {
                    System.out.println(MessageProvider.OPERATION_CANCELLED);
                    MessageProvider.displayViewReports();
                    return;
                }

                Student student = STUDENT_MANAGER.findStudentById(studentId);

                List<Enrollment> enrollments = ENROLLMENT_MANAGER.getEnrollmentsByStudentId(studentId);

                if (enrollments.isEmpty()) {
                    System.out.println(MessageProvider.NO_ENROLLMENTS_FOR_STUDENT);
                } else {
                    System.out.println(MessageProvider.ENROLLMENTS_FOR_STUDENT_HEADER);
                    System.out.printf("%n" + MessageProvider.STUDENT_ENTRY_FORMAT + "%n", student.getName(), student.getId());
                    System.out.println(MessageProvider.ENROLLED_COURSES_HEADER);

                    for (Enrollment enrollment : enrollments) {
                        Course course = enrollment.getCourse();
                        System.out.printf(MessageProvider.COURSE_ENTRY + "%n", course.getName(), course.getId());
                    }
                }

                isValidId = false;
                MessageProvider.displayEnrollmentsMenu();

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.INVALID_ID);
                SCANNER.nextLine();
            } catch (StudentNotFoundException _) {
                System.out.println(MessageProvider.getStudentNotFoundMessage(studentId));
                MessageProvider.displayViewReports();
                return;
            }
        }
    }
}