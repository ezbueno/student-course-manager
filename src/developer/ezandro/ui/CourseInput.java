package developer.ezandro.ui;

import developer.ezandro.domain.Course;
import developer.ezandro.utils.MessageProvider;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class CourseInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    private CourseInput() {
    }

    public static Course readCourseData() {
        String name = "";
        String description = "";
        int workload = 0;
        boolean checkName = true;
        boolean checkDescription = true;
        boolean checkWorkload = true;

        System.out.println(MessageProvider.CANCELLATION_HINT);
        System.out.println(MessageProvider.PROVIDE_DETAILS);

        while (checkName) {
            System.out.println(MessageProvider.INPUT_COURSE_NAME_PROMPT);
            name = SCANNER.nextLine();

            if (Objects.equals(name, "0")) {
                return null;
            } else if (Objects.equals(name, "")) {
                System.out.println(MessageProvider.EMPTY_INPUT_ERROR);
            } else {
                checkName = false;
            }
        }

        while (checkDescription) {
            System.out.println(MessageProvider.INPUT_COURSE_DESCRIPTION_PROMPT);
            description = SCANNER.nextLine();

            if (Objects.equals(description, "0")) {
                return null;
            } else if (Objects.equals(description, "")) {
                System.out.println(MessageProvider.EMPTY_INPUT_ERROR);
            } else {
                checkDescription = false;
            }
        }

        while (checkWorkload) {
            try {
                System.out.println(MessageProvider.INPUT_COURSE_WORKLOAD_PROMPT);
                workload = SCANNER.nextInt();

                while (workload <= 0) {
                    System.out.println(MessageProvider.INVALID_WORKLOAD);
                    System.out.println(MessageProvider.INPUT_COURSE_WORKLOAD_PROMPT);
                    workload = SCANNER.nextInt();
                }

                checkWorkload = false;

            } catch (InputMismatchException | IllegalArgumentException _) {
                System.out.println(MessageProvider.INVALID_WORKLOAD);
                SCANNER.nextLine();
            }
        }

        return new Course(name, description, workload);
    }
}