/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Ng Chong Jian
 */
public class MainUI {
     Scanner scanner = new Scanner(System.in);
     public int getMenuChoice() {
        int choice = -1;
        while (true) {
            System.out.println("+======================================================+");
            System.out.println("|                        Main Menu                     |");
            System.out.println("+======================================================+");
            System.out.println("| 1.Programme Management Subsystem (Yew Zi Yu)         |");
            System.out.println("| 2.Tutorial Group Management Subsystem (Ng Chong Jian)|");
            System.out.println("| 3.Tutor Management Subsystem (Lim Yi Jie)            |");
            System.out.println("| 4.Course Management Subsystem (Lim Shi Lei)          |");
            System.out.println("| 0.Exit System                                        |");
            System.out.println("+======================================================+");
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 0 && choice <= 4) {
                    break;
                } else {
                    MessageUI.displayInvalidChoiceMessage();
                }
            } catch (NumberFormatException e) {
                MessageUI.displayInvalidChoiceMessage();
            }
        }
        return choice;
    }
}
