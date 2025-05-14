package developer.ezandro.utils;

public class MessageProvider {
    private MessageProvider() {
    }

    // ========================
    // === Validation/Menus ===
    // ========================
    public static final String MAIN_MENU_INVALID_OPTION = "\nInvalid option. Please choose a number between 1 and 5.\nChoose an option: ";
    public static final String SUBMENU_STUDENT_INVALID_OPTION = "\nInvalid option. Please choose a number between 1 and 4.\nChoose an option: ";
    public static final String SUBMENU_COURSE_INVALID_OPTION = "\nInvalid option. Please choose a number between 1 and 4.\nChoose an option: ";
    public static final String SUBMENU_ENROLLMENT_INVALID_OPTION = "\nInvalid option. Please choose a number between 1 and 4.\nChoose an option: ";
    public static final String SUBMENU_REPORTS_INVALID_OPTION = "\nInvalid option. Please choose a number between 1 and 4.\nChoose an option: ";

    // ========================
    // === Students ===
    // ========================
    public static final String STUDENT_NOT_FOUND = "Student with ID: %s not found.";
    public static final String NO_REGISTERED_STUDENTS = "No students registered yet. Use 'Add Student' to begin.";
    public static final String STUDENT_REGISTRATION_SUCCESS = "Student registered successfully.";
    public static final String INPUT_STUDENT_ID_PROMPT = "Enter the student ID:";
    public static final String INPUT_STUDENT_NAME_PROMPT = "Enter the student's full name: ";
    public static final String INPUT_STUDENT_EMAIL_PROMPT = "Enter the student's email address (e.g., user@domain.com): ";
    public static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    public static final String INVALID_EMAIL = "Email must follow: username@domain.com (e.g., user@example.com).";

    // ========================
    // === Courses ===
    // ========================
    public static final String COURSE_NOT_FOUND = "Course with ID: %s not found.";
    public static final String NO_REGISTERED_COURSES = "No courses registered yet. Use 'Add Course' to begin.";
    public static final String COURSE_REGISTRATION_SUCCESS = "Course registered successfully.";
    public static final String INPUT_COURSE_ID_PROMPT = "Enter the course ID:";
    public static final String INPUT_COURSE_NAME_PROMPT = "Enter the course name: ";
    public static final String INPUT_COURSE_DESCRIPTION_PROMPT = "Enter the course description: ";
    public static final String INPUT_COURSE_WORKLOAD_PROMPT = "Enter the course workload in hours (e.g., 40): ";
    public static final String INVALID_WORKLOAD = "Workload must be a positive number. Please try again.";

    // ========================
    // === Enrollments ===
    // ========================
    public static final String ENROLLMENT_NOT_FOUND = "Enrollment with ID: %s not found.";
    public static final String NO_ENROLLMENTS_FOUND = "No enrollments found.";
    public static final String NO_ENROLLMENTS_FOR_STUDENT = "No enrollments found for this student.";
    public static final String NO_REGISTERED_ENROLLMENTS = "No enrollments registered yet. Use 'Enroll a Student' to begin.";
    public static final String ENROLLMENT_SUCCESS = "Student enrolled in course successfully.";
    public static final String ENROLLMENT_ALREADY_EXISTS = "This student is already enrolled in this course.";
    public static final String STUDENT_ALREADY_ENROLLED = "The student is already enrolled in this course.";
    public static final String ENROLLMENT_CREATION_SUCCESS = "The enrollment was successfully created!";
    public static final String INPUT_ENROLLMENT_ID_PROMPT = "Enter the enrollment ID: ";
    public static final String INPUT_ENROLLMENT_STUDENT_ID_PROMPT = "Enter the ID of the student to enroll: ";
    public static final String INPUT_ENROLLMENT_COURSE_ID_PROMPT = "Enter the ID of the course to enroll the student in: ";
    public static final String TRY_AGAIN_OR_CANCEL = "Try again or enter 0 to cancel.";
    public static final String CHECK_IDS_OR_CANCEL = "Check the IDs or enter 0 to cancel.";
    public static final String OPERATION_CANCELLED = "Operation cancelled by user.";
    public static final String CANCELLATION_HINT = "(Enter 0 at any time to cancel and return)";
    public static final String INVALID_ID = "Invalid ID. Please try again.";
    public static final String INVALID_ID_RETRY = "Invalid ID. Please try again or enter 0 to cancel.";
    public static final String EMPTY_INPUT_ERROR = "Error: Field cannot be empty. Please enter a value.";
    public static final String PROVIDE_DETAILS = "Please provide the following details:";

    // ========================
    // === Display Formatting ===
    // ========================
    public static final String STUDENT_ENTRY_FORMAT = "Student: %s (ID: %d)";
    public static final String COURSE_LABEL = "Course: %s (ID: %d)";
    public static final String COURSE_ENTRY = "- Course: %s (ID: %d)";
    public static final String COURSE_ENTRY_FORMAT = "- %s (ID: %d)";
    public static final String STUDENT_ENTRY_WITH_ENROLLMENT = "- %s (Student ID: %d, Enrollment ID: %d)";
    public static final String ENROLLED_STUDENTS_HEADER = "Enrolled Students:";
    public static final String ENROLLED_COURSES_HEADER = "Enrolled Courses:";

    // ========================
    // === Headers ===
    // ========================
    public static final String STUDENT_LIST_HEADER = """
            
            ╔══════════════════════════╗
            ║      LIST OF STUDENTS    ║
            ╚══════════════════════════╝
            """;

    public static final String COURSE_LIST_HEADER = """
            
            ╔════════════════════════╗
            ║      LIST OF COURSES   ║
            ╚════════════════════════╝
            """;

    public static final String ENROLLMENT_LIST_HEADER = """
            
            ╔════════════════════════════════╗
            ║       LIST OF ENROLLMENTS      ║
            ╚════════════════════════════════╝
            """;

    public static final String COURSES_WITH_STUDENTS_HEADER = """
            
            ╔════════════════════════════════════════╗
            ║     LIST OF COURSES WITH STUDENTS      ║
            ╚════════════════════════════════════════╝
            """;

    public static final String STUDENTS_WITH_COURSES_HEADER = """
            
            ╔═════════════════════════════════════╗
            ║     LIST OF STUDENTS WITH COURSES   ║
            ╚═════════════════════════════════════╝
            """;

    public static final String ENROLLMENTS_FOR_STUDENT_HEADER = """
            
            ╔═══════════════════════════════════╗
            ║     ENROLLMENTS BY STUDENT ID     ║
            ╚═══════════════════════════════════╝
            """;

    public static final String PROGRAM_EXIT_MESSAGE = """
            
            === Program terminated ===
            Thank you for using Student Course Manager.
            Have a great day!
            """;

    // ========================
    // === Menus ===
    // ========================
    public static void displayMainMenu() {
        System.out.print("""
                
                === Student Course Manager ===
                1. Manage Students
                2. Manage Courses
                3. Enroll Students in Courses
                4. View Reports
                5. Exit
                Choose an option:
                """);
    }

    public static void displayStudentsMenu() {
        System.out.print("""
                
                === Students Management ===
                1. Add Student
                2. List All Students
                3. Find Student by ID
                4. Back to Main Menu
                Choose an option:
                """);
    }

    public static void displayCoursesMenu() {
        System.out.print("""
                
                === Courses Management ===
                1. Add Course
                2. List All Courses
                3. Find Course by ID
                4. Back to Main Menu
                Choose an option:
                """);
    }

    public static void displayEnrollmentsMenu() {
        System.out.print("""
                
                === Enrollment Management ===
                1. Enroll a Student
                2. View Enrollments
                3. Find Enrollment by ID
                4. Back to Main Menu
                Choose an option:
                """);
    }

    public static void displayViewReports() {
        System.out.print("""
                
                === Reports ===
                1. View All Courses with Enrolled Students
                2. View All Students with Their Courses
                3. View Enrollments by Student ID
                4. Back to Main Menu
                Choose an option:
                """);
    }

    // ========================
    // === Helper Methods ===
    // ========================
    public static String getStudentNotFoundMessage(long id) {
        return String.format(STUDENT_NOT_FOUND, id);
    }

    public static String getCourseNotFoundMessage(long id) {
        return String.format(COURSE_NOT_FOUND, id);
    }

    public static String getEnrollmentNotFoundMessage(long id) {
        return String.format(ENROLLMENT_NOT_FOUND, id);
    }

    public static String getEnrollmentAlreadyExistsMessage() {
        return ENROLLMENT_ALREADY_EXISTS;
    }

    public static String getEnrollmentCreationSuccessMessage() {
        return ENROLLMENT_CREATION_SUCCESS;
    }

    public static String getEnrollmentListEmptyMessage() {
        return NO_REGISTERED_ENROLLMENTS;
    }
}