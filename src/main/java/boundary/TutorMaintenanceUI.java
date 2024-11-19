/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Tutor;
import static java.lang.Math.floor;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Lim Yi Jie
 */
public class TutorMaintenanceUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        int choice = -1;
        while (true) {
            System.out.println("+=====================================+");
            System.out.println("|   Tutor Management Subsystem        |");
            System.out.println("+=====================================+");
            System.out.println("| 1.Add a new tutor                   |");
            System.out.println("| 2.Remove a tutor                    |");
            System.out.println("| 3.Find tutor                        |");
            System.out.println("| 4.Amend tutor details               |");
            System.out.println("| 5.List all tutors                   |");
            System.out.println("| 6.Filter tutors based on criteria   |");
            System.out.println("| 7.Generate relevant reports         |");
            System.out.println("| 0.Exit Subsystem                    |");
            System.out.println("+=====================================+");
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 0 && choice <= 7) {
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

    public void listAllTutor(String outputStr) {
        if (outputStr != null) {
            System.out.println("Tutor Details");
            System.out.println("=============");
            System.out.printf("%-7s %-15s %-5s %-12s %-10s %-10s %-5s\n", "Id", "Name", "Age", "Phone", "Salary", "Type", "Rating");
            System.out.println(outputStr);
        }
    }

    public void generateReport(int[] report1, double[] report2) {
        System.out.println("\nTutor Report Details");
        System.out.println("======================");
        System.out.println("Total of Tutor:" + report1[0]);
        System.out.printf("Average Age of Tutor: %-3.0f\n", floor(report2[6]));
        System.out.printf("Average Rating of Tutor: %-5.1f\n", report2[0]);
        System.out.printf("Average Salary of Tutor: RM %-10.2f\n", report2[3]);

        System.out.println("\nFullTime Tutor Report Details");
        System.out.println("===============================");
        System.out.println("Total of FullTime Time Tutor:" + report1[2]);
        System.out.printf("Average Age of FullTime Tutor:%-3.0f\n", floor(report2[7]));
        System.out.printf("Average Rating of FullTime Tutor: %-5.1f\n", report2[2]);
        System.out.printf("Average Salary of FullTime Tutor: RM %-10.2f\n", report2[5]);

        System.out.println("\nPartTime Tutor Report Details");
        System.out.println("===============================");
        System.out.println("Total of PartTime Tutor:" + report1[1]);
        System.out.printf("Average Age of PartTime Tutor:%-3.0f\n", floor(report2[8]));
        System.out.printf("Average Rating of PartTime Tutor: %-5.1f\n", report2[1]);
        System.out.printf("Average Salary of PartTime Tutor: RM %-10.2f \n\n", report2[4]);
        
    }

    public void printTutorDetails(Tutor tutor) {
        System.out.println("Tutor Details");
        System.out.println("Tutor ID:" + tutor.getId());
        System.out.println("Tutor name: " + tutor.getName());
        System.out.println("Age: " + tutor.getAge());
        System.out.println("Phone: " + tutor.getPhone());
        System.out.println("Salary: " + tutor.getSalary());
        System.out.println("Type: " + tutor.getType());
        System.out.println("Rating: " + tutor.getRating());
    }

    public String inputSearchDetails() {
        System.out.print("Enter Tutor ID or Name: ");
        String id = scanner.nextLine();
        return id.toUpperCase();
    }

    public int confirmOperation() {
        int confirm = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Confirm your Operation? (1=YES/2=NO): ");
                confirm = scanner.nextInt();
                scanner.nextLine();

                if (confirm == 1 || confirm == 2) {
                    isValid = true;
                } else {
                    MessageUI.displayInvalidChoiceMessage();
                }
            } catch (java.util.InputMismatchException e) {
                MessageUI.displayInvalidChoiceMessage();
                scanner.nextLine();
            }
        }

        return confirm;
    }

    public int filterChoice() {
        int confirm = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("1. Based on Age");
                System.out.println("2. Based on Rate");
                System.out.print("Enter your choice: ");
                confirm = scanner.nextInt();
                scanner.nextLine();

                if (confirm == 1 || confirm == 2) {
                    isValid = true;
                } else {
                    MessageUI.displayInvalidChoiceMessage();
                }
            } catch (java.util.InputMismatchException e) {
                MessageUI.displayInvalidChoiceMessage();
                scanner.nextLine();
            }
        }

        return confirm;
    }

    public double[] filterRate() {
        double[] rate = new double[2];
        boolean isValidMinRate = false;
        boolean isValidMaxRate = false;

        while (!isValidMinRate || !isValidMaxRate || rate[0] > rate[1]) {
            try {
                System.out.print("Enter minimum Rate: ");
                String minRateInput = scanner.nextLine();

                rate[0] = Double.parseDouble(minRateInput);
                isValidMinRate = true;

                System.out.print("Enter maximum Rate: ");
                String maxRateInput = scanner.nextLine();

                rate[1] = Double.parseDouble(maxRateInput);
                isValidMaxRate = true;

                if (rate[0] > rate[1] || rate[1] > 5) {
                    MessageUI.displayInvalidRate();
                    isValidMinRate = false;
                    isValidMaxRate = false;
                }
            } catch (NumberFormatException e) {
                MessageUI.displayInvalidChoiceMessage();
            }
        }

        return rate;
    }

    public int[] filterAge() {
        int[] age = new int[2];
        boolean isValidMinAge = false;
        boolean isValidMaxAge = false;

        while (!isValidMinAge || !isValidMaxAge || age[0] > age[1]) {
            try {
                System.out.print("Enter minimum Age: ");
                String minAgeInput = scanner.nextLine();

                age[0] = Integer.parseInt(minAgeInput);
                isValidMinAge = true;

                System.out.print("Enter maximum Age: ");
                String maxAgeInput = scanner.nextLine();

                age[1] = Integer.parseInt(maxAgeInput);
                isValidMaxAge = true;

                if (age[0] > age[1]) {
                    MessageUI.displayInvalidAge();
                    isValidMinAge = false;
                    isValidMaxAge = false;
                }
            } catch (NumberFormatException e) {
                MessageUI.displayInvalidChoiceMessage();
            }
        }

        return age;
    }
    


    public String inputTutorID() {
        System.out.print("Enter Tutor ID: ");
        String id = scanner.nextLine();
        return id;
    }

    public String inputTutorName() {
        System.out.print("Enter Tutor Name: ");
        String name = scanner.nextLine();
        return name.toUpperCase();
    }

    public int inputAge() {
        int age = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter Age: ");
                String ageInput = scanner.nextLine();

                age = Integer.parseInt(ageInput);

                if (age >= 21 && age <= 60) {
                    isValid = true;
                } else {
                    System.out.println("Age must be between 21 and 60.");
                }
            } catch (NumberFormatException e) {
                MessageUI.displayInvalidChoiceMessage();
            }
        }

        return age;
    }

    public String inputPhone() {
        String phone = "";

        while (true) {
            System.out.print("Enter Tutor Phone: ");
            phone = scanner.nextLine();

            try {
                if (isValidPhoneNumber(phone)) {
                    return phone;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                MessageUI.displayInvalidChoiceMessage();
            }
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\s", "");

        if (phoneNumber.matches("[0-9]+") && phoneNumber.length() >= 10 && phoneNumber.length() <= 11) {
            return true;
        }
        return false;
    }

    public double inputSalary() {
        double salary = 0.0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter Tutor Salary: ");
                String salaryInput = scanner.nextLine();

                salary = Double.parseDouble(salaryInput);

                if (salary >= 0.0) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input for salary. Please enter a valid non-negative number.");
                }
            } catch (NumberFormatException e) {
                MessageUI.displayInvalidChoiceMessage();
            }
        }

        return salary;
    }

    public String inputType() {
        String outputStr = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter Type (1=PartTime/2=FullTime): ");
                int type = scanner.nextInt();
                scanner.nextLine();

                if (type == 1 || type == 2) {
                    outputStr = (type == 1) ? "PartTime" : "FullTime";
                    isValid = true;
                } else {
                    MessageUI.displayInvalidChoiceMessage();
                }
            } catch (java.util.InputMismatchException e) {
                MessageUI.displayInvalidChoiceMessage();
                scanner.nextLine();
            }
        }

        return outputStr;
    }

    public double inputRating() {
        double rating = 0.0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter Rating: ");
                String ratingInput = scanner.nextLine();

                rating = Double.parseDouble(ratingInput);

                if (rating >= 0.0) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input for rating. Please enter a valid non-negative number.");
                }
            } catch (NumberFormatException e) {
                MessageUI.displayInvalidChoiceMessage();
            }
        }

        return rating;
    }

    public Tutor inputTutorDetails() {
        String tutorId = inputTutorID().toUpperCase();
        String tutorName = inputTutorName().toUpperCase();
        int age = inputAge();
        String phone = inputPhone();
        double salary = inputSalary();
        String type = inputType();
        double rate = inputRating();
        System.out.println();
        return new Tutor(tutorId, tutorName, age, phone, salary, type, rate);

    }

}
