//LimShiLei
package control;

import adt.LinkedMap;
import adt.MapInterface;
import boundary.CourseMaintenanceUI;
import entity.Course;
import utility.CourseMessageUI;
import dao.CourseInitializer;
import entity.ProgrammeV2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CourseMaintenance {

    private CourseInitializer courseInit = new CourseInitializer();
    private MapInterface<String, Course> courseMap = new LinkedMap<>();
    private LinkedMap<String, ProgrammeV2> programmeMap = courseInit.initializeProgrammes();
    private CourseMaintenanceUI courseUI = new CourseMaintenanceUI();

    private int addCount = 0;
    private int removeCount = 0;
    private int findCount = 0;
    private int amendCount = 0;
    private int listCount = 0;
    private int addProgToCourseCount = 0;
    private int removeProgFromCourseCount = 0;

    Scanner scanner = new Scanner(System.in);

    public CourseMaintenance() {
        this.courseMap = courseInit.initializeCourses();
    }

    public void runCourseMaintenance() {
        int choice = 0;
        do {
            choice = courseUI.getMenuChoice();
            switch (choice) {
                case 0:
                    CourseMessageUI.displayExitMessage();
                    break;
                case 1:
                    addNewCourse();
                    courseUI.listAllCourses(getAllCourses());
                    break;
                case 2:
                    removeByCode();
                    courseUI.listAllCourses(getAllCourses());
                    break;
                case 3:
                    findCourse();
                    break;
                case 4:
                    editByCode();
                    courseUI.listAllCourses(getAllCourses());
                    break;
                case 5:
                    courseUI.listAllCourses(getAllCourses());
                    break;
                case 6:
                    addProgrammeToCourse();
                    courseUI.listAllCourses(getAllCourses());
                    break;
                case 7:
                    removeProgrammeFromCourse();
                    courseUI.listAllCourses(getAllCourses());
                    break;
                case 8:
                    generateReport();
                    break;
                default:
                    CourseMessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void addNewCourse() {
        CourseMessageUI.addNewCourseMessage();
        Course newCourse;

        do {
            newCourse = courseUI.inputCourseDetails();
            if (!isValidCourseCode(newCourse.getCourseCode())) {
                CourseMessageUI.displayInvalidCourseCodeMessage();
            } else if (!isValidString(newCourse.getCourseName())) {
                CourseMessageUI.displayInvalidCourseNameMessage();
            } else {
            }
        } while (!isValidCourseCode(newCourse.getCourseCode()) || !isValidString(newCourse.getCourseName()));
        if (!courseMap.containsKey(newCourse.getCourseCode())) {
            courseMap.put(newCourse.getCourseCode(), newCourse);
            CourseMessageUI.displayNewCourseAdded();
            addCount++;
        } else {
            CourseMessageUI.displayDuplicateCourseCode();
        }
    }

    private boolean isValidCourseCode(String courseCode) {
        return courseCode.length() == 8 && courseCode.matches(".*[a-zA-Z].*") && courseCode.matches(".*\\d.*");
    }

    private boolean isValidString(String input) {
        return input.matches("^[a-zA-Z ]+$");
    }

    public void removeByCode() {
        CourseMessageUI.displayRemoveCode();
        String courseId;

        do {
            courseId = courseUI.inputCourseCode();

            if (!courseMap.containsKey(courseId)) {
                CourseMessageUI.displayCodeNotFound(courseId);
            }
        } while (!courseMap.containsKey(courseId));

        courseMap.remove(courseId);
        removeCount++;

        CourseMessageUI.displayIsRemoveMessage(courseId);
    }

    public void findCourse() {
        CourseMessageUI.displayFindCourseMessage();
        String courseId = courseUI.inputCourseCode();
        LinkedMap<String, Course> matchingCourses = new LinkedMap<>();

        for (LinkedMap.Entry<String, Course> entry : courseMap.entrySet()) {
            if (entry.getKey().contains(courseId)) {
                matchingCourses.put(entry.getKey(), entry.getValue());
            }
        }

        if (!matchingCourses.isEmpty()) {
            CourseMessageUI.displayMatchingCourseMessage();

            for (LinkedMap.Entry<String, Course> entry : matchingCourses.entrySet()) {
                Course course = entry.getValue();
                String outputStr = "";

                for (LinkedMap.Entry<String, ProgrammeV2> entry1 : entry.getValue().getProgrammeList().entrySet()) {
                    outputStr += entry1.getValue().getProgrammeCode() + " ";
                }

                CourseMessageUI.displayMatchingCourseDetailsMessage(course, outputStr);
                findCount++;
            }

            CourseMessageUI.displayBlankMessage();
        } else {
            CourseMessageUI.displayCodeNotFoundMessage(courseId);
        }
    }

    public void editByCode() {
        int choice;
        String courseId;

        do {
            CourseMessageUI.displayEditMessage();
            courseId = courseUI.inputCourseCode();

            if (courseMap.containsKey(courseId)) {
                Course course = courseMap.get(courseId);
                CourseMessageUI.displayEditCourseName(course);

                do {
                    choice = courseUI.editCourseDetails();

                    switch (choice) {
                        case 1:
                            amendCourseName(course);
                            break;
                        case 2:
                            System.out.println("");
                            runCourseMaintenance();
                            break;
                    }
                } while (choice != 1 && choice != 2);

            } else {
                CourseMessageUI.displayCodeNotFoundMessage(courseId);
                choice = -1;
            }
        } while (choice == -1);
    }

    private void amendCourseName(Course course) {
        String newName = courseUI.amendCourseName();

        if (!newName.equals(course.getCourseName())) {
            course.setCourseName(newName);
            CourseMessageUI.courseNameAmendedMessage();
            amendCount++;
        } else {
            CourseMessageUI.noChangerMessage();
        }
    }

    public String getAllCourses() {
        StringBuilder outputStr = new StringBuilder();

        for (LinkedMap.Entry<String, Course> entry : courseMap.entrySet()) {
            Course course = entry.getValue();
            String outputStr1 = "";
            for (LinkedMap.Entry<String, ProgrammeV2> entry1 : entry.getValue().getProgrammeList().entrySet()) {
                outputStr1 += entry1.getValue().getProgrammeCode() + " ";
            }
            outputStr.append(String.format("%-15s", course.getCourseCode())).append(String.format("%-50s", course.getCourseName())).append(String.format("%-20s", outputStr1)).append("\n");
        }

        listCount++;
        return outputStr.toString();
    }

    public void displayCourses() {
        CourseMessageUI.displayBlankMessage();
        courseUI.listAllCourses(getAllCourses());
    }

    public void addProgrammeToCourse() {
        CourseMessageUI.addNewProgrammeToCourseMessage();
        CourseMessageUI.displayBlankMessage();
        courseUI.listAllCourses(getAllCourses());
        courseUI.listAllProgrammes(getAllProgrammes());

        String courseCode = courseUI.inputCourseCode();

        if (courseMap.containsKey(courseCode)) {
            Course selectedCourse = courseMap.get(courseCode);
            boolean continueAddingPrograms = true;

            while (continueAddingPrograms) {
                String programCode = courseUI.inputProgrammeInCharge();

                if (programmeMap.containsKey(programCode)) {
                    ProgrammeV2 selectedProgramme = programmeMap.get(programCode);

                    selectedCourse.getProgrammeList().put(programCode, selectedProgramme);

                    CourseMessageUI.displayProgramCodeAddedMessage(programCode);
                    addProgToCourseCount++;
                } else {
                    CourseMessageUI.displayProgramCodeNotFoundMessage(programCode);
                }

                String addAnother = courseUI.progValidation();

                if (!addAnother.equals("y")) {
                    CourseMessageUI.displayBlankMessage();
                    continueAddingPrograms = false;
                }
            }
        } else {
            CourseMessageUI.displayCodeNotFoundMessage(courseCode);
        }
    }

    public void removeProgrammeFromCourse() {
        CourseMessageUI.removeProgramMessage();
        CourseMessageUI.displayBlankMessage();
        courseUI.listAllCourses(getAllCourses());
        courseUI.listAllProgrammes(getAllProgrammes());

        String courseCode = courseUI.inputCourseCode();

        if (courseMap.containsKey(courseCode)) {
            Course selectedCourse = courseMap.get(courseCode);

            if (!selectedCourse.getProgrammeList().isEmpty()) {
                boolean continueRemovingPrograms = true;

                while (continueRemovingPrograms) {
                    String programCode = courseUI.codeToRemove();

                    if (selectedCourse.getProgrammeList().containsKey(programCode)) {
                        selectedCourse.getProgrammeList().remove(programCode);
                        removeProgFromCourseCount++;
                        CourseMessageUI.programRemovedMessage(programCode);
                    } else {
                        CourseMessageUI.programRemovedNotFoundMessage(programCode);
                    }

                    String removeAnother = courseUI.progRemoveValidation();

                    if (!removeAnother.equals("y")) {
                        CourseMessageUI.displayBlankMessage();
                        continueRemovingPrograms = false;
                    }
                }
            } else {
                CourseMessageUI.noProgramFoundMessage(courseCode);
            }
        } else {
            CourseMessageUI.displayCodeNotFoundMessage(courseCode);
        }
    }

    public String getAllProgrammes() {
        StringBuilder outputStr = new StringBuilder();

        for (LinkedMap.Entry<String, ProgrammeV2> entry : programmeMap.entrySet()) {
            ProgrammeV2 prog = entry.getValue();
            outputStr.append(String.format("%-21s", prog.getProgrammeCode())).append(String.format("%-50s", prog.getProgrammeName())).append(String.format("%-20s", prog.getProgrammeDescription())).append("\n");
        }

        return outputStr.toString();
    }

    public void displayProgrammes() {
        courseUI.listAllProgrammes(getAllProgrammes());
    }

    public void generateReport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());

        CourseMessageUI.reportMessage();
        courseUI.displayReportCount(addCount, removeCount, findCount, amendCount, listCount, addProgToCourseCount, removeProgFromCourseCount);

        int totalCourses = courseMap.size();
        int totalProgrammes = programmeMap.size();
        int totalActivities = addCount + removeCount + findCount + amendCount + listCount + addProgToCourseCount + removeProgFromCourseCount;

        courseUI.displayReportFormatMessage(totalCourses, totalProgrammes, totalActivities, currentTime);
    }

    public static void start() {
        CourseMaintenance courseMaintenance = new CourseMaintenance();
        courseMaintenance.runCourseMaintenance();
    }

    public static void main(String[] args) {
        CourseMaintenance courseMaintenance = new CourseMaintenance();
        courseMaintenance.runCourseMaintenance();
    }
}
