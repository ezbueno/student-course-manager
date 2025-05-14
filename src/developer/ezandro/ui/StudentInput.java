package developer.ezandro.ui;

import developer.ezandro.domain.Student;
import developer.ezandro.utils.MessageProvider;

import java.util.Objects;
import java.util.Scanner;

public class StudentInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    private StudentInput() {
    }

    public static Student readStudentData() {
        boolean checkEmail = true;
        boolean checkName = true;
        String name = "";

        System.out.println(MessageProvider.CANCELLATION_HINT);
        System.out.println(MessageProvider.PROVIDE_DETAILS);

        while (checkName) {
            System.out.println(MessageProvider.INPUT_STUDENT_NAME_PROMPT);
            name = SCANNER.nextLine();

            if (Objects.equals(name, "0")) {
                return null;
            } else if (Objects.equals(name, "")) {
                System.out.println(MessageProvider.EMPTY_INPUT_ERROR);
            } else {
                checkName = false;
            }
        }

        String email = "";

        while (checkEmail) {
            System.out.println(MessageProvider.INPUT_STUDENT_EMAIL_PROMPT);
            email = SCANNER.nextLine();

            if (Objects.equals(email, "0")) {
                return null;
            } else if (Objects.equals(email, "")) {
                System.out.println(MessageProvider.EMPTY_INPUT_ERROR);
            } else if (!email.matches(MessageProvider.EMAIL_REGEX)) {
                System.out.println(MessageProvider.INVALID_EMAIL);
            } else {
                checkEmail = false;
            }
        }

        return new Student(name, email);
    }
}