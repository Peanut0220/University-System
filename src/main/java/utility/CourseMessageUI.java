//LimShiLei
package utility;

import entity.Course;

public class CourseMessageUI {

    public static void displayInvalidChoiceMessage() {
        System.out.println("Invalid Choice. Please select again.\n");
    }

    public static void displayExitMessage() {
        System.out.println("Exit Successfully.");
    }

    public static void addNewCourseMessage() {
        System.out.println("Add new course");
    }

    public static void displayInvalidCourseCodeMessage() {
        System.out.println("Invalid course code. It must have 8 characters and include at least one letter and one digit.\n");
    }

    public static void displayInvalidCourseNameMessage() {
        System.out.println("Invalid course name. It must consist only of characters.\n");
    }

    public static void displayNewCourseAdded() {
        System.out.println("New course added.\n");
    }

    public static void displayDuplicateCourseCode() {
        System.out.println("Duplicate course code.\n");
    }

    public static void displayRemoveCode() {
        System.out.println("Remove course\n");
    }

    public static void displayCodeNotFoundMessage(String courseId) {
        System.out.println("\nCourse with this code [" + courseId + "] is not found.\n");
    }

    public static void displayCodeNotFound(String courseId) {
        System.out.println("\nCourse with this code [" + courseId + "] is not found. Please re-enter.\n");
    }

    public static void displayIsRemoveMessage(String courseId) {
        System.out.println("\nCourse with this code [" + courseId + "] is removed.\n");
    }

    public static void displayFindCourseMessage() {
        System.out.println("Find existing course");
    }

    public static void displayMatchingCourseMessage() {
        System.out.printf("\n%-15s %-50s %-20s\n", "Course Code", "Course Title", "Programme In Charge");
    }

    public static void displayMatchingCourseDetailsMessage(Course course, String outputStr) {
        System.out.printf("%-15s %-50s %-20s\n", course.getCourseCode(), course.getCourseName(), outputStr);
    }

    public static void displayBlankMessage() {
        System.out.println("");
    }

    public static void displayEditMessage() {
        System.out.println("Amend course details");
    }

    public static void displayEditCourseName(Course course) {
        System.out.println("\nCourse Name:\n" + course.getCourseName() + "\n");
    }

    public static void courseNameAmendedMessage() {
        System.out.println("\nCourse name amended successfully.\n");
    }

    public static void noChangerMessage() {
        System.out.println("\nNo changes made to course name.\n");
    }

    public static void addNewProgrammeToCourseMessage() {
        System.out.println("Add new programme to course");
    }

    public static void displayProgramCodeAddedMessage(String programCode) {
        System.out.println("\nProgramme with code [" + programCode + "] added to the course.\n");
    }

    public static void displayProgramCodeNotFoundMessage(String programCode) {
        System.out.println("\nProgramme with code [" + programCode + "] not found.\n");
    }

    public static void removeProgramMessage() {
        System.out.println("Remove programme from course");
    }

    public static void programRemovedMessage(String programCode) {
        System.out.println("\nProgramme with code [" + programCode + "] removed from the course.\n");
    }

    public static void programRemovedNotFoundMessage(String programCode) {
        System.out.println("\nProgramme with code [" + programCode + "] not found in the course.\n");
    }

    public static void noProgramFoundMessage(String programCode) {
        System.out.println("\nNo programmes found in the course.\n");
    }

    public static void reportMessage() {
        System.out.println("Activity Report:");
        System.out.println("---------------------------------------");
        System.out.println("Activity                          Count");
    }
}
