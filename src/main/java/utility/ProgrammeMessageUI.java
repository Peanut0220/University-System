/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author Yew Zi Yu
 */
public class ProgrammeMessageUI {

    public static void displayExitMessage() {
        System.out.printf("-------------------------------\n");
        System.out.printf("         Exit. Thank You.      \n");
        System.out.printf("-------------------------------\n");
    }

    public static void displayErrorMessage() {
        System.out.printf("\nInvalid choice. Please enter again.\n\n");
    }

    public static void displayProgrammeNotFound() {
        System.out.println("Programme Not Found.");
    }

    public static void displayProgrammeAdded() {
        System.out.println("Programme added successfully!");
    }

    public static void displayProgrammeExist() {
        System.out.println("This program code already exists. Please enter a different code.");
    }

    public static void displayProgrammeDeleted() {
        System.out.println("Programme deleted successfully!");
    }

    public static void displayTutorialAdded() {
        System.out.println("Tutorial groups have been added successfully.");
    }

    public static void displayTutorialAlreadyAddedMessage() {
        System.out.println("This tutorial group has already been added to the program.");
    }

    public static void displayTutorialAlreadyDeletedMessage() {
        System.out.println("This tutorial group has already been deleted from the program.");
    }

    public static void displayTutorialDeleted() {
        System.out.println("Tutorial groups have been deleted successfully.");
    }

    public static void invalidProgramme() {
        System.out.println("Invalid programme selection. Please enter a valid number.");
    }

    public static void invalidTutorialGroup() {
        System.out.println("Invalid tutorial group selection. Please enter a valid number.");
    }

    public static void displayCodeUpdated() {
        System.out.println("Programme code updated successfully!");
    }

    public static void displayNameUpdated() {
        System.out.println("Programme name updated successfully!");
    }

    public static void displayAdvisoryUpdated() {
        System.out.println("Programme name updated successfully!");
    }

    public static void displayNewCodeExist() {
        System.out.println("New program code is the same as the existing one. Please enter a different code.");
    }

    public static void displayNewNameExist() {
        System.out.println("New program name is the same as the existing one. Please enter a different name.");
    }

    public static void displayNewAdvisoryExist() {
        System.out.println("New advisory name is the same as the existing one. Please enter a different advisory name.");
    }

    public static void displayInvalidCodeFormat() {
        System.out.println("Programme code must be alphabetic characters only.Please re-enter.");
    }

    public static void displayInvalidNameFormat() {
        System.out.println("Programme name should not exceed 50 characters.Please re-enter.");
    }

    public static void displayInvalidAdvisoryFormat() {
        System.out.println("Advisory name should not exceed 26 characters.Please re-enter.");
    }

    public static void displayNameFormat() {
        System.out.println("Name must be alphabetic characters only. Please re-enter.");
    }
}
