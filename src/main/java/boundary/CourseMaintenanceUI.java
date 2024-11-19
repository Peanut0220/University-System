//LimShiLei
package boundary;

import entity.Course;
import entity.ProgrammeV2;
import java.util.Scanner;

public class CourseMaintenanceUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("Course Main Menu\n");
        System.out.println("1. Add a new course.");
        System.out.println("2. Remove a course.");
        System.out.println("3. Find course.");
        System.out.println("4. Amend course details.");
        System.out.println("5. List all courses.");
        System.out.println("6. Add programme to a course.");
        System.out.println("7. Remove a programme from a course.");
        System.out.println("8. Generate relevant reports.");
        System.out.println("0. Exit.\n");
        System.out.print("Enter choice(1-0): ");
        String choice = scanner.nextLine();

        try {
            int finalChoice = Integer.parseInt(choice);
            System.out.println();
            return finalChoice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void listAllCourses(String outputStr) {
        System.out.printf("%-14s %-49s %-18s\n", "Course Code", "Course Title", "Programme Code\n" + outputStr);
    }

    public void listAllProgrammes(String outputStr) {
        System.out.printf("%-20s %-49s %-18s\n", "Programme Code", "Programme Name", "Programme Description\n" + outputStr);
    }

    public int editCourseDetails() {
        System.out.println("1. Course Name");
        System.out.println("2. Quit this page");
        System.out.print("You are only allowed to amend course name: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public String inputCourseCode() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        return courseCode;
    }

    public String inputCourseName() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        return courseName;
    }

    public String inputProgrammeInCharge() {
        System.out.print("Enter programme code: ");
        String progCode = scanner.nextLine();
        return progCode;
    }

    public String inputProgrammeName() {
        System.out.print("Enter programme name: ");
        String progName = scanner.nextLine();
        return progName;
    }

    public String inputProgrammeDesc() {
        System.out.print("Enter programme description: ");
        String progDesc = scanner.nextLine();
        return progDesc;
    }

    public Course inputCourseDetails() {
        String courseCode = inputCourseCode();
        String courseName = inputCourseName();
        System.out.println();
        return new Course(courseCode, courseName);
    }

    public ProgrammeV2 inputProgrammeDetails() {
        String programmeCode = inputProgrammeInCharge();
        String programmeName = inputProgrammeName();
        String programmeDesc = inputProgrammeDesc();
        System.out.println("");
        return new ProgrammeV2(programmeCode, programmeName, programmeDesc);
    }

    public String amendCourseName() {
        System.out.print("\nEnter new name: ");
        String newName = scanner.nextLine();
        return newName;
    }

    public String progValidation() {
        System.out.print("Do you want to add another programme? (y/n): ");
        String addAnother = scanner.nextLine().toLowerCase();
        return addAnother;
    }

    public String codeToRemove() {
        System.out.print("Enter program code to remove: ");
        String programCode = scanner.nextLine();
        return programCode;
    }

    public String progRemoveValidation() {
        System.out.print("Do you want to remove another programme from the course? (y/n): ");
        String removeAnother = scanner.nextLine().toLowerCase();
        return removeAnother;
    }

    public static void displayReportMessage(String activity, int count) {
        System.out.printf("%-35s %-12d\n", activity, count);
    }

    public static void displayReportCount(int c1, int c2, int c3, int c4, int c5, int c6, int c7) {
        System.out.printf("%-35s %-12d\n", "Add a new course.", c1);
        System.out.printf("%-35s %-12d\n", "Remove a course.", c2);
        System.out.printf("%-35s %-12d\n", "Find course.", c3);
        System.out.printf("%-35s %-12d\n", "Amend course details.", c4);
        System.out.printf("%-35s %-12d\n", "List all courses.", c5);
        System.out.printf("%-35s %-12d\n", "Add programme to a course.", c6);
        System.out.printf("%-35s %-12d\n", "Remove a programme from a course.", c7);
    }

    public static void displayReportFormatMessage(int totalCourses, int totalProgrammes, int totalActivities, String currentTime) {
        System.out.printf("\n%-35s %-12d\n", "Total Courses", totalCourses);
        System.out.printf("%-35s %-12d\n", "Total Programmes", totalProgrammes);
        System.out.println("\nTotal Activities: " + totalActivities);
        System.out.println("Report generated on: " + currentTime + "\n");
    }
}
