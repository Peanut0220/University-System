/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.SortedListInterface;
import entity.*;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Ng Chong Jian
 */
public class TutorialGroupManagementUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("+===========================================+");
        System.out.println("|    Tutorial Group Management Subsystem    |");
        System.out.println("+===========================================+");
        System.out.println("| 1.Add a Student to a tutorial group       |");
        System.out.println("| 2.Remove a Student from tutorial group    |");
        System.out.println("| 3.Change tutorial group for a student     |");
        System.out.println("| 4.Find a student in a tutorial group      |");
        System.out.println("| 5.List all students in a tutorial group   |");
        System.out.println("| 6.Filter tutorial groups                  |");
        System.out.println("| 7.Generate reports                        |");
        System.out.println("| 0.Exit System                             |");
        System.out.println("+===========================================+");
        int choice = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return choice;
    }

    public void listAllStudent(String outputStr) {
        System.out.println("\nList of Student: ");
        System.out.printf("+=============================================+\n");
        System.out.printf("|%-2s %-10s %-20s %-3s %-6s|\n", "No", "StudentID", "StudentName", "Age", "Gender");
        System.out.printf("+=============================================+\n");
        System.out.print(outputStr);
        System.out.printf("+=============================================+\n\n\n");

    }

    public void listAllTutorialGroup(String outputStr) {
        System.out.println("\nList of Tutorial Group: ");
        System.out.print(outputStr + "\n");

    }

    public void showReports(double totalStudent, double totalGroup, String most, String least, double aveStudent, double aveMale, double aveFemale) {
        System.out.printf("\nReports\n");
        System.out.printf("=========\n");
        System.out.printf("Total number of Students      : %2.0f\n", totalStudent);
        System.out.printf("Total number of Tutorial Group: %2.0f\n\n", totalGroup);
        
        System.out.printf("Tutorial group with the most students : %s\n", most);
        System.out.printf("Tutorial group with the least students: %s\n\n", least);
        
        System.out.printf("Average number of students per tutorial group       : %5.2f\n", aveStudent);
        System.out.printf("Average number of male students per tutorial group  : %5.2f\n", aveMale);
        System.out.printf("Average number of female students per tutorial group: %5.2f\n\n", aveFemale);

    }

    public int chooseStudent(String outputStr) {
        listAllStudent(outputStr);

        int choice = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Select the student to remove (ex:1): ");
                choice = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return choice;
    }

    public int chooseStudentEdit(String outputStr) {
        listAllStudent(outputStr);
        int choice = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Select the student to change tutorial group (ex:1): ");
                choice = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return choice;
    }

    public int chooseGroupToChange(String outputStr) {
        int choice = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Select the tutorial group to change to (ex:1): ");
                choice = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return choice;
    }

    public void findStudent(String outputStr) {
        if (outputStr == "Group Not Found!" || outputStr == "Student Not Found!" || outputStr == "Something went wrong!") {
            System.out.println(outputStr);
        } else {
            System.out.println("Student Found!");
            System.out.printf("+==========================================+\n");
            System.out.printf("|%-10s %-20s %-3s %-6s|\n", "StudentID", "StudentName", "Age", "Gender");
            System.out.printf("+==========================================+\n");
            System.out.print(outputStr);
            System.out.printf("+==========================================+\n\n\n");
        }
    }

    public void filterGroup(String outputStr) {
        System.out.println("\nList of TutorialGroup: ");
        System.out.printf("+====================================================+\n");
        System.out.printf("|%-2s %-12s %-20s %-15s|\n", "No", "TutGroupID", "Tutor", "No of Students");
        System.out.printf("+====================================================+\n");
        System.out.print(outputStr);
        System.out.printf("+====================================================+\n\n\n");

    }

    public int chooseFilter() {
        int choice = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.println("\nChoose one of the filter option");
                System.out.println("1. Number Of Student");
                System.out.println("2. Tutor of the tutorial group");
                System.out.print("Enter Choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return choice;
    }

    public int chooseFilterNoOfStudent() {
        int choice = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("\nEnter The number of Students: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return choice;
    }

    public String chooseFilterTutor() {

        String name = "";
        boolean done = false;
        while (!done) {
            try {
                System.out.print("\nEnter Tutor: ");
                name = scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                System.out.println("Tutor name must be a String!");
            }
        }

        return name.toUpperCase();
    }

    public String chooseSearchParameter() {
        String name = "";
        boolean done = false;
        while (!done) {
            try {
                System.out.print("\nEnter Student ID or Student Name to search: ");
                name = scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                System.out.println("Search parameter must be a String!");
            }
        }

        return name.toUpperCase();
    }

    public int chooseTutorialGroup() {
        int choice = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("\nSelect the Tutorial Group: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return choice;
    }

    public int chooseTutorialGroupStudent() {
        int choice = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("\nSelect the Tutorial Group where the Student belongs to: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return choice;
    }

    public String inputStudentID() {
        String id = "";
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Enter Student ID (XXWMDXX): ");
                id = scanner.nextLine();
                if (id.length() != 7) {
                    System.out.println("Student name must be only 7 characters!");
                } else {
                    done = true;
                }
            } catch (Exception ex) {
                System.out.println("Student name must be a String!");
            }
        }
        return id.toUpperCase();
    }

    public String inputStudentName() {
        String name = "";
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Enter Student name: ");
                name = scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                System.out.println("Student name must be a String!");
            }
        }

        return name.toUpperCase();
    }

    public int inputStudentAge() {
        int age = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Enter Age: ");
                age = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } catch (Exception ex) {
                System.out.println("Age must be in integer, please try again!");
                scanner.nextLine();
            }
        }
        return age;
    }

    public String inputStudentGender() {
        int choice = 0;
        String gender = "";
        boolean done = false;
        while (!done) {
            try {
                System.out.println("Select Gender: ");
                System.out.println("1. Male ");
                System.out.println("2. Female");
                System.out.print("Your Choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                done = true;
            } catch (Exception ex) {
                MessageUI.displayChoiceFormatErrorMessage();
                scanner.nextLine();
            }
        }
        return gender;
    }

    public Student inputStudentDetails() {
        String studentID = inputStudentID();
        String studentName = inputStudentName();
        int studentAge = inputStudentAge();
        String studentGender = inputStudentGender();
        return new Student(studentID, studentName, studentAge, studentGender);

    }

}
