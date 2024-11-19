/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import boundary.MainUI;
import utility.MessageUI;

/**
 *
 * @author Ng Chong Jian
 */
public class MainMaintenance {

    private MainUI mainUI = new MainUI();

    public static void main(String[] args) {
        MainMaintenance mainMaintenance = new MainMaintenance();
        mainMaintenance.runMainMaintenance();
    }

    public void runMainMaintenance() {
        int choice = 0;
        do {
            choice = mainUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;

                case 1:
                    ProgrammeMaintenance.start();
                    break;

                case 2:
                    TutorialGroupMaintenance.start();
                    break;

                case 3:
                    TutorMaintenance.start();
                    break;

                case 4:
                    CourseMaintenance.start();
                    break;

                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

}
