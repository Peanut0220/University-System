package control;

import adt.*;
import boundary.*;
import dao.TutorialGroupDAO;
import entity.*;
import java.util.Iterator;
import utility.MessageUI;

/**
 *
 * @author Ng Chong Jian
 */
public class TutorialGroupMaintenance {

    private SortedListInterface<TutorialGroup> groupList
            = new SortedDoublyLinkedList<>();
    private TutorialGroupDAO groupDAO = new TutorialGroupDAO();
    private TutorialGroupManagementUI groupUI 
            = new TutorialGroupManagementUI();

    public TutorialGroupMaintenance() {
        groupList = groupDAO.retrieveFromFile();
    }

    public void runTutorialGroupMaintenance() {

        int choice = 0;
        do {
            choice = groupUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    changeTutorialGroup();
                    break;
                case 4:
                    groupUI.findStudent(findStudentInGroup());
                    break;
                case 5:
                    groupUI.listAllStudent(listAllStudentInTutGroup());
                    break;
                case 6:
                    groupUI.filterGroup(filterTutorialGroup());
                    break;
                case 7:
                    generateReports();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void addNewStudent() {
        try {
            groupUI.listAllTutorialGroup(getAllTutorialGroup());
            TutorialGroup group
                    = groupList.
                            getEntry(groupUI.chooseTutorialGroup() - 1);
            if (group != null) {
                Student newStudent = groupUI.inputStudentDetails();
                TutorialGroup groupAfter = group;
                groupAfter.addStudent(newStudent);
                groupList.replace(group, groupAfter);
                groupDAO.saveToFile(groupList);
                MessageUI.displayAddMessage();
            } else {
                MessageUI.displayNotFoundMessage();
            }
        } catch (Exception ex) {
            MessageUI.displayAddErrorMessage();
        }
    }

    private String getAllStudentsInGroup(
            SortedListInterface<Student> studentList) {
        String outputStr = "";
        int i = 1;
        Iterator<Student> iterator = studentList.getIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            outputStr += "|" + i + ". " + student.toString() + "|\n";
            i++;
        }
        return outputStr;
    }

    private void changeTutorialGroup() {
        try {
            Student foundStudent = null;
            groupList = groupDAO.retrieveFromFile();

            groupUI.listAllTutorialGroup(getAllTutorialGroup());
            int groupID = groupUI.chooseTutorialGroupStudent();

            TutorialGroup oriGroupBefore 
                    = groupList.getEntry(groupID - 1);
            TutorialGroup oriGroupAfter = oriGroupBefore;

            if (oriGroupBefore != null) {
                SortedListInterface<Student> OriStudentList
                        = new SortedDoublyLinkedList<>();
                SortedListInterface<Student> ChangeStudentList
                        = new SortedDoublyLinkedList<>();
                OriStudentList = oriGroupBefore.getStudentList();
                String outputStr = getAllStudentsInGroup(OriStudentList);
                int choice = groupUI.chooseStudentEdit(outputStr);
                foundStudent = OriStudentList.getEntry(choice - 1);

                if (foundStudent != null) {
                    groupUI.listAllTutorialGroup(getAllTutorialGroup());
                    int groupEntry = groupUI.chooseGroupToChange(outputStr);
                    TutorialGroup changeGroupBefore
                            = groupList.getEntry(groupEntry - 1);
                    TutorialGroup changeGroupAfter = changeGroupBefore;

                    ChangeStudentList = changeGroupBefore.getStudentList();
                    OriStudentList.remove(foundStudent);
                    ChangeStudentList.add(foundStudent);
                    oriGroupAfter.setStudentList(OriStudentList);

                    changeGroupAfter.setStudentList(ChangeStudentList);
                    groupList.replace(oriGroupBefore, oriGroupAfter);
                    groupList.replace(changeGroupBefore, changeGroupAfter);

                    groupDAO.saveToFile(groupList);
                    MessageUI.displayChangeMessage();
                } else {
                    MessageUI.displayStudentNotFoundMessage();
                }
            } else {
                MessageUI.displayNotFoundMessage();
            }
        } catch (Exception ex) {
            MessageUI.displayChangeErrorMessage();
        }

    }

    private void removeStudent() {
        try {
            Student foundStudent = null;
            groupList = groupDAO.retrieveFromFile();
            groupUI.listAllTutorialGroup(getAllTutorialGroup());
            int groupID = groupUI.chooseTutorialGroup();

            TutorialGroup group = groupList.getEntry(groupID - 1);
            TutorialGroup groupChange = group;
            if (group != null) {
                SortedListInterface<Student> studentList
                        = new SortedDoublyLinkedList<>();
                studentList = group.getStudentList();
                String outputStr = getAllStudentsInGroup(studentList);
                int choice = groupUI.chooseStudent(outputStr);
                foundStudent = studentList.getEntry(choice - 1);
                if (foundStudent != null) {
                    studentList.remove(foundStudent);
                    group.setStudentList(studentList);
                    groupList.replace(group, groupChange);
                    groupDAO.saveToFile(groupList);
                    MessageUI.displayDeleteMessage();
                } else {
                    MessageUI.displayStudentNotFoundMessage();
                }
            } else {
                MessageUI.displayNotFoundMessage();
            }
        } catch (Exception ex) {
            MessageUI.displayUnsuccessfulDeleteMessage();
        }

    }

    private String filterGroup1(int no) {
        String outputStr = "";
        try {
            groupList = groupDAO.retrieveFromFile();
            Iterator<TutorialGroup> iterator = groupList.getIterator();
            int i = 1;
            while (iterator.hasNext()) {
                TutorialGroup tutorialGroup = iterator.next();
                int noOfStudents
                        = tutorialGroup.
                                getStudentList().getNumberOfEntries();
                if (noOfStudents == no) {
                    outputStr += "|" + i + ". "
                            + String.format("%-12s %-20s %-15d|\n",
                                    tutorialGroup.getGroupID(),
                                    tutorialGroup.getTutor(), 
                                    noOfStudents);
                    i++;
                }
            }
            if (outputStr == "") {
                outputStr += "Group Not Found!\n";
            }
            return outputStr;
        } catch (Exception ex) {
            MessageUI.displayFilterErrorMessage();
            return outputStr;
        }
    }

    private String filterGroup2(String tutor) {
        String outputStr = "";
        try {
            groupList = groupDAO.retrieveFromFile();
            Iterator<TutorialGroup> iterator = groupList.getIterator();
            int i = 1;
            while (iterator.hasNext()) {
                TutorialGroup tutorialGroup = iterator.next();
                int noOfStudents
                        = tutorialGroup.
                                getStudentList().getNumberOfEntries();
                if (tutorialGroup.getTutor().equals(tutor)) {
                    outputStr += "|" + i + ". "
                            + String.format("%-12s %-20s %-15d|\n",
                                    tutorialGroup.getGroupID(),
                                    tutorialGroup.getTutor(), 
                                    noOfStudents);
                    i++;
                }
            }
            if (outputStr == "") {
                outputStr += "Group Not Found!\n";
            }
            return outputStr;
        } catch (Exception ex) {
            MessageUI.displayFilterErrorMessage();
            return outputStr;
        }
    }

    public String filterTutorialGroup() {
        String filterTutor = "";
        int numberOfStudent = 0;
        String outputStr = "";

        int choice = groupUI.chooseFilter();
        groupList = groupDAO.retrieveFromFile();
        if (choice == 1) {
            numberOfStudent = groupUI.chooseFilterNoOfStudent();
            outputStr = filterGroup1(numberOfStudent);
        } else {
            filterTutor = groupUI.chooseFilterTutor();
            outputStr = filterGroup2(filterTutor);
        }

        return outputStr;

    }

    public String findStudentInGroup() {
        groupList = groupDAO.retrieveFromFile();
        groupUI.listAllTutorialGroup(getAllTutorialGroup());
        int groupID = groupUI.chooseTutorialGroup();
        String searchParameter = "";
        String outputStr = "";
        Student foundStudent = null;
        try {
            TutorialGroup group = groupList.getEntry(groupID - 1);
            if (group != null) {
                searchParameter = groupUI.chooseSearchParameter();
                Iterator<Student> iterator
                        = group.getStudentList().getIterator();
                int found = 0;
                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    if (student.getId().equals(searchParameter)
                            || student.getName().equals(searchParameter)) {
                        found = 1;
                        foundStudent = student;
                    }
                }
                if (found == 1) {
                    outputStr += "|" + foundStudent.toString() + "|\n";
                    return outputStr;
                } else {
                    outputStr = "Student Not Found!";
                }
            } else {
                outputStr = "Group Not Found!";
            }

        } catch (Exception ex) {
            outputStr = "Something went wrong!";
        }
        return outputStr;
    }

    public String getAllTutorialGroup() {
        String outputStr = "";
        int i = 1;
        groupList = groupDAO.retrieveFromFile();
        Iterator<TutorialGroup> iterator = groupList.getIterator();
        while (iterator.hasNext()) {
            TutorialGroup tutorialGroup = iterator.next();
            outputStr += "\n" + i + ". " + tutorialGroup.getGroupID();
            i++;
        }
        return outputStr;
    }

    public String listAllStudentInTutGroup() {
        try {
            groupList = groupDAO.retrieveFromFile();
            groupUI.listAllTutorialGroup(getAllTutorialGroup());
            int groupID = groupUI.chooseTutorialGroup();
            String outputStr = "";

            SortedListInterface<Student> studentList
                    = new SortedDoublyLinkedList<>();
            TutorialGroup group = groupList.getEntry(groupID - 1);
            studentList = group.getStudentList();

            outputStr += getAllStudentsInGroup(studentList);

            return outputStr;
        } catch (Exception ex) {
            return "Display Error Occured!\n";
        }
    }

    public void generateReports() {
        groupList = groupDAO.retrieveFromFile();
        double most = 0;
        double least = 10000;
        double male = 0;
        double female = 0;
        double totalStudent = 0;
        double totalGroup = 0;
        double aveStudent = 0;
        double aveMale = 0;
        double aveFemale = 0;
        String mostStudent = "";
        String leastStudent = "";
        Iterator<TutorialGroup> iterator = groupList.getIterator();
        while (iterator.hasNext()) {
            TutorialGroup tutorialGroup = iterator.next();
            totalGroup += 1;
            Iterator<Student> iteratorStudent
                    = tutorialGroup.getStudentList().getIterator();
            while (iteratorStudent.hasNext()) {
                Student student = iteratorStudent.next();
                if (student.getGender().equals("Male")) {
                    male += 1;
                } else {
                    female += 1;
                }
            }
            int numberOfStudents
                    = tutorialGroup.getStudentList().getNumberOfEntries();
            totalStudent += numberOfStudents;

            if (numberOfStudents > most) {
                mostStudent = tutorialGroup.getGroupID();
                most = numberOfStudents;
            } else if (numberOfStudents < least) {
                leastStudent = tutorialGroup.getGroupID();
                least = numberOfStudents;
            } else {

            }
        }

        aveStudent = totalStudent / totalGroup;
        aveMale = male / totalGroup;
        aveFemale = female / totalGroup;

        groupUI.showReports(totalStudent, totalGroup,
                mostStudent, leastStudent, aveStudent, aveMale, aveFemale);
    }

    public static void start() {
        TutorialGroupMaintenance tutorMaintenance
                = new TutorialGroupMaintenance();
        tutorMaintenance.runTutorialGroupMaintenance();
    }

    public static void main(String[] args) {
        TutorialGroupMaintenance tutorMaintenance
                = new TutorialGroupMaintenance();
        tutorMaintenance.runTutorialGroupMaintenance();
    }

}
