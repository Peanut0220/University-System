/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Programme;
import java.util.Scanner;
import utility.ProgrammeMessageUI;

/**
 *
 * @author Yew Zi Yu
 */
public class ProgrammeMaintenanceUI {

    Scanner scanner = new Scanner(System.in);

    public int getProgrammeMenu() {
        displayProgrammeMenu();
        int select = scanner.nextInt();
        scanner.nextLine();
        return select;
    }

    public static void displayProgrammeMenu() {
        System.out.println();
        System.out.println("Programme Management Main Menu ");
        System.out.println("*******************************");
        System.out.println("    0. Exit");
        System.out.println("    1. Add New Programme");
        System.out.println("    2. Update Programme");
        System.out.println("    3. Delete Programme");
        System.out.println("    4. List All Programme");
        System.out.println("    5. Search Programme");
        System.out.println("    6. Manage Tutorial Group");
        System.out.println("    7. Generate Report");
        System.out.printf("     >> Enter Your Option: ");
    }

    public int getTutorialMenu() {
        displayTutorialMenu();
        int select = scanner.nextInt();
        scanner.nextLine();
        return select;
    }

    public static void displayTutorialMenu() {
        System.out.println();
        System.out.println("Tutorial Group Management Main Menu");
        System.out.println("************************************");
        System.out.println("    0. Exit");
        System.out.println("    1. Add Tutorial Group to Programme");
        System.out.println("    2. Delete Tutorial Group from Programme");
        System.out.println("    3. List All Tutorial Group of Programme");
        System.out.print("     >> Enter Your Option: ");
    }

    public void printProgrammeDetails(String outputStr) {
        System.out.println("\n****************************************** List of Programmes ******************************************");
        System.out.println("No.\tProgramme Code\t\tProgramme Name\t\t\t\tAdvisory Name\n");
        System.out.print(outputStr);
    }

    public void printFoundProgramme(Programme foundProgramme) {
        System.out.println("\n****************************************** List of Programmes ******************************************");
        System.out.println("Programme Code\t\tProgramme Name\t\t\t\tAdvisory Name");
        System.out.print(foundProgramme);
    }

    public void printProgrammeNotFoundDetails(String searchProgramme) {
        System.out.println("Programme " + searchProgramme + " not found.");
    }

    public void printTutorialDetails(String outputStr) {
        System.out.println("**************************************** List of Tutorial Group ****************************************");
        System.out.println("No.\tTutorial Group\t\tNumber Of Student\n" + outputStr);
    }

    public String search() {
        System.out.print("Search programme:");
        String searchItem = scanner.nextLine().trim();
        return searchItem;
    }

    public String inputProgCode() {
        System.out.print("Enter programme code: ");
        String code = scanner.nextLine();

        // Check if the code contains alphabetic characters only
        if (!code.matches("[a-zA-Z]+")) {
            ProgrammeMessageUI.displayInvalidCodeFormat();
            return inputProgCode(); // Recursively call the method to re-enter the code
        }

        return code.toUpperCase();
    }

    public String inputProgName() {
        boolean isValidInput = false;
        String name = "";

        while (!isValidInput) {
            System.out.print("Enter programme name: ");
            name = scanner.nextLine();

            if (name.length() > 50) {
                ProgrammeMessageUI.displayInvalidNameFormat();
            } else if (!name.matches("^[a-zA-Z ]+$")) {
                ProgrammeMessageUI.displayNameFormat();
            } else {
                // Split the input into words
                String[] words = name.split(" ");
                StringBuilder formattedName = new StringBuilder();

                // Capitalize the first character of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        formattedName.append(word.substring(0, 1).toUpperCase())
                                .append(word.substring(1)).append(" ");
                    }
                }

                // Remove trailing space and set the formatted name
                name = formattedName.toString().trim();
                isValidInput = true;
            }
        }

        return name;
    }

    public String inputAdvisoryName() {
        boolean isValidInput = false;
        String advName = "";

        while (!isValidInput) {
            System.out.print("Enter advisory name: ");
            advName = scanner.nextLine();

            if (advName.length() > 50) {
                ProgrammeMessageUI.displayInvalidNameFormat();
            } else if (!advName.matches("^[a-zA-Z ]+$")) {
                ProgrammeMessageUI.displayNameFormat();
            } else {
                // Split the input into words
                String[] words = advName.split(" ");
                StringBuilder formattedName = new StringBuilder();

                // Capitalize the first character of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        formattedName.append(word.substring(0, 1).toUpperCase())
                                .append(word.substring(1)).append(" ");
                    }
                }

                // Remove trailing space and set the formatted name
                advName = formattedName.toString().trim();
                isValidInput = true;
            }
        }

        return advName;
    }

    public Programme inputProgrammeDetails() {
        String progCode = inputProgCode();
        String progName = inputProgName();
        String advisoryName = inputAdvisoryName();
        System.out.println();
        return new Programme(progCode, progName, advisoryName);
    }

    public void updateMenu() {
        System.out.println("    Select one to update:   ");
        System.out.println("*******************************");
        System.out.println("    1. Programme Code");
        System.out.println("    2. Programme Name");
        System.out.println("    3. Advisory Name");
        System.out.print("    Enter your option>> ");
    }

    public int selectUpdate() {
        updateMenu();
        int select = scanner.nextInt();
        scanner.nextLine();
        return select;
    }

    public String updateProgCode() {
        System.out.print("Enter new programme code: ");
        String code = scanner.nextLine();

        // Check if the code contains alphabetic characters only
        if (!code.matches("[a-zA-Z]+")) {
            ProgrammeMessageUI.displayInvalidCodeFormat();
            return updateProgCode();
        }

        return code.toUpperCase();
    }

    public String updateProgName() {
        boolean isValidInput = false;
        String progName = "";

        while (!isValidInput) {
            System.out.print("Enter new programme name: ");
            progName = scanner.nextLine();

            if (progName.length() > 50) {
                ProgrammeMessageUI.displayInvalidNameFormat();
            } else if (!progName.matches("^[a-zA-Z ]+$")) {
                ProgrammeMessageUI.displayNameFormat();
            } else {
                // Split the input into words
                String[] words = progName.split(" ");
                StringBuilder formattedName = new StringBuilder();

                // Capitalize the first character of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        formattedName.append(word.substring(0, 1).toUpperCase())
                                .append(word.substring(1)).append(" ");
                    }
                }

                // Remove trailing space and set the formatted name
                progName = formattedName.toString().trim();
                isValidInput = true;
            }
        }

        return progName;
    }

    public String updateAdvisoryName() {
        boolean isValidInput = false;
        String advName = "";

        while (!isValidInput) {
            System.out.print("Enter new advisory name: ");
            advName = scanner.nextLine();

            if (advName.length() > 50) {
                ProgrammeMessageUI.displayInvalidNameFormat();
            } else if (!advName.matches("^[a-zA-Z ]+$")) {
                ProgrammeMessageUI.displayNameFormat();
            } else {
                // Split the input into words
                String[] words = advName.split(" ");
                StringBuilder formattedName = new StringBuilder();

                // Capitalize the first character of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        formattedName.append(word.substring(0, 1).toUpperCase())
                                .append(word.substring(1)).append(" ");
                    }
                }

                // Remove trailing space and set the formatted name
                advName = formattedName.toString().trim();
                isValidInput = true;
            }
        }

        return advName;
    }

    public int inputChoice() {
        System.out.print("Choose your programme: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public int inputTutorialGroup() {
        System.out.print("Select tutorial group: ");
        int tutorialGroup = scanner.nextInt();
        scanner.nextLine();
        return tutorialGroup;
    }

    public String continueAdding() {
        System.out.print("Do you want to continue adding tutorial groups? (yes/no): ");
        String input = scanner.nextLine();
        return input;
    }

    public String continueDelete() {
        System.out.print("Do you want to continue delete tutorial groups? (yes/no): ");
        String input = scanner.nextLine();
        return input;
    }

    public void printReportDetails() {
        System.out.println("\n========================================================================================================");
        System.out.println("\t\t\t\t\tProgramme Report");
        System.out.println("========================================================================================================\n");
    }

    public void printTotalProgrammes(int totalProgrammes){
        System.out.println("\nTotal of Programmes          : " + totalProgrammes);
    }
    
    public void printTotalTutorialGroups(int totalGroups) {
        System.out.println("Total of Tutorial Groups     : " + totalGroups);
    }
    
    
    public void printProgrammes(Programme programme){
        System.out.print("Programme " + programme.getProgCode() + "       : " );
    }
    
    public void printGroupOfProgramme(int sumGroups){
        System.out.print(sumGroups + " tutorial groups" + "\n" );
    }
}
