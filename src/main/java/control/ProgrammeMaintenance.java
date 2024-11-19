/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.PriorityQueue;
import adt.QueueInterface;
import boundary.ProgrammeMaintenanceUI;
import dao.ProgrammeInitializer;
import dao.TutorialGroupInitializer;
import entity.Programme;
import entity.Tutorial;
import java.util.Scanner;
import utility.ProgrammeMessageUI;

/**
 *
 * @author Yew Zi Yu
 */
public class ProgrammeMaintenance {

    private QueueInterface<Programme> programmeList = new PriorityQueue<>();
    private QueueInterface<Tutorial> tutorialList = new PriorityQueue<>();
    private ProgrammeMaintenanceUI programmeUI = new ProgrammeMaintenanceUI();

    public ProgrammeMaintenance() {
        ProgrammeInitializer programme = new ProgrammeInitializer();
        TutorialGroupInitializer tutorial = new TutorialGroupInitializer();
        tutorialList = tutorial.initializeTutorials();
        programmeList = programme.initializeProgrammes(tutorialList);
    }

    public void runProgrammeMaintenance() {
        int select;
        int choice;
        do {
            select = programmeUI.getProgrammeMenu();
            switch (select) {
                case 0:
                    ProgrammeMessageUI.displayExitMessage();
                    break;
                case 1:
                    addProgramme();
                    programmeUI.printProgrammeDetails(getAllProgrammes());
                    break;
                case 2:
                    updateProgramme();
                    programmeUI.printProgrammeDetails(getAllProgrammes());
                    break;
                case 3:
                    removeProgramme();
                case 4:
                    if (programmeList.isEmpty()) {
                        ProgrammeMessageUI.displayProgrammeNotFound();
                    } else {
                        programmeUI.printProgrammeDetails(getAllProgrammes());
                    }
                    break;
                case 5:
                    searchProgramme();
                    break;
                case 6:
                    choice = programmeUI.getTutorialMenu();
                    switch (choice) {
                        case 0:
                            ProgrammeMessageUI.displayExitMessage();
                            break;
                        case 1:
                            String inputContinue;
                            do {
                                addTutorialGroup();
                                inputContinue = programmeUI.continueAdding();
                            } while (inputContinue.equalsIgnoreCase("yes"));

                            ProgrammeMessageUI.displayTutorialAdded();
                            programmeUI.printProgrammeDetails(getAllProgrammes());
                            break;
                        case 2:
                            String input;
                            do {
                                deleteTutorialGroup();
                                input = programmeUI.continueDelete();
                            } while (input.equalsIgnoreCase("yes"));

                            ProgrammeMessageUI.displayTutorialDeleted();
                            programmeUI.printProgrammeDetails(getAllProgrammes());
                            break;
                        case 3:
                            programmeUI.printProgrammeDetails(getAllProgrammes());
                            break;
                        default:
                            ProgrammeMessageUI.displayErrorMessage();
                            break;
                    }
                    break;
                case 7:
                    generateReport();
                    break;
                default:
                    ProgrammeMessageUI.displayErrorMessage();
            }
        } while (select != 0);
    }

    public void addProgramme() {
        Programme newProgramme = programmeUI.inputProgrammeDetails();

        boolean isDuplicate = false;
        for (int i = 1; i <= programmeList.size(); i++) {
            Programme existingProgramme = programmeList.get(i);
            if (existingProgramme.getProgCode().equalsIgnoreCase(newProgramme.getProgCode())) {
                isDuplicate = true;
                break;
            }
        }

        if (isDuplicate) {
            ProgrammeMessageUI.displayProgrammeExist();
        } else {
            programmeList.enqueue(newProgramme);
            ProgrammeMessageUI.displayProgrammeAdded();
        }
    }

    public String getAllProgrammes() {
        String outputStr = "";
        for (int i = 1; i <= programmeList.size(); i++) {
            outputStr += i + ".\t" + programmeList.get(i) + "\n";
        }
        return outputStr;
    }

    public void updateProgramme() {
        programmeUI.printProgrammeDetails(getAllProgrammes());
        int choice;
        Programme selectedProgramme = null;
        do {
            choice = programmeUI.inputChoice();
            if (choice < 1 || choice > programmeList.size()) {
                ProgrammeMessageUI.invalidProgramme();
            } else {
                selectedProgramme = programmeList.get(choice);
            }
        } while (choice < 1 || choice > programmeList.size());
        int select;

        do {
            select = programmeUI.selectUpdate();
            switch (select) {
                case 1:
                    String newCode;
                    boolean isCodeUpdated = false;

                    do {
                        newCode = programmeUI.updateProgCode();
                        if (selectedProgramme.getProgCode().equalsIgnoreCase(newCode)) {
                            ProgrammeMessageUI.displayNewCodeExist();
                        } else {
                            selectedProgramme.setProgCode(newCode);
                            ProgrammeMessageUI.displayCodeUpdated();
                            isCodeUpdated = true;
                        }
                    } while (!isCodeUpdated);
                    break;
                case 2:
                    String newName;
                    boolean isNameUpdated = false;

                    do {
                        newName = programmeUI.updateProgName();
                        if (selectedProgramme.getProgName().equalsIgnoreCase(newName)) {
                            ProgrammeMessageUI.displayNewNameExist();
                        } else {
                            selectedProgramme.setProgName(newName);
                            ProgrammeMessageUI.displayNameUpdated();
                            isNameUpdated = true;
                        }
                    } while (!isNameUpdated);
                    break;
                case 3:
                    String newAdvisory;
                    boolean isAdvisoryUpdated = false;

                    do {
                        newAdvisory = programmeUI.updateAdvisoryName();
                        if (selectedProgramme.getAdvisoryName().equalsIgnoreCase(newAdvisory)) {
                            ProgrammeMessageUI.displayNewAdvisoryExist();
                        } else {
                            selectedProgramme.setAdvisoryName(newAdvisory);
                            ProgrammeMessageUI.displayAdvisoryUpdated();
                            isAdvisoryUpdated = true;
                        }
                    } while (!isAdvisoryUpdated);
                    break;
                default:
                    ProgrammeMessageUI.displayErrorMessage();
                    break;
            }
        } while (select < 1 || select > 3);

    }

    public void removeProgramme() { //adt
        programmeUI.printProgrammeDetails(getAllProgrammes());
        String progCode = programmeUI.inputProgCode();
        boolean removed = false;

        QueueInterface<Programme> programsToKeep = new PriorityQueue<>();

        while (!programmeList.isEmpty()) {
            Programme programme = programmeList.dequeue();
            if (!programme.getProgCode().equalsIgnoreCase(progCode)) {
                programsToKeep.enqueue(programme);
            } else {
                removed = true;
            }
        }

        //clear the original queue
        programmeList.clear();

        //add the programme back to the original queue
        while (!programsToKeep.isEmpty()) {
            programmeList.enqueue(programsToKeep.dequeue());
        }
        if (removed) {
            ProgrammeMessageUI.displayProgrammeDeleted();
        } else {
            ProgrammeMessageUI.displayProgrammeNotFound();
        }
    }

    public void searchProgramme() {
        String searchProgramme = programmeUI.search();

        boolean programmeFound = false;

        for (int i = 1; i <= programmeList.size(); i++) {
            Programme foundProgramme = programmeList.get(i);
            if (foundProgramme != null) {
                boolean codeMatch = foundProgramme.getProgCode() != null && foundProgramme.getProgCode().trim().equalsIgnoreCase(searchProgramme.trim());
                boolean nameMatch = foundProgramme.getProgName() != null && foundProgramme.getProgName().trim().equalsIgnoreCase(searchProgramme.trim());
                if (codeMatch || nameMatch) {
                    programmeFound = true;
                    programmeUI.printFoundProgramme(foundProgramme);
                }
            }
        }
        if (!programmeFound) {
            programmeUI.printProgrammeNotFoundDetails(searchProgramme);
        }
    }

    public void addTutorialGroup() {
        int choice;
        int tutorialGroup;
        Programme selectedProgramme = null;

        do {
            programmeUI.printProgrammeDetails(getAllProgrammes());
            choice = programmeUI.inputChoice();
            if (choice < 1 || choice > programmeList.size()) {
                ProgrammeMessageUI.invalidProgramme();
            } else {
                selectedProgramme = programmeList.get(choice);
            }
        } while (choice < 1 || choice > programmeList.size());

        do {
            programmeUI.printTutorialDetails(getAllTutorialGroup());

            tutorialGroup = programmeUI.inputTutorialGroup();

            if (tutorialGroup >= 1 && tutorialGroup <= tutorialList.size()) {
                Tutorial selectedTutorial = tutorialList.get(tutorialGroup);

                // Check if the tutorial group has already been added to the selected program
                if (selectedProgramme.getTutorialGroup().contains(selectedTutorial)) {
                    ProgrammeMessageUI.displayTutorialAlreadyAddedMessage();
                } else {
                    selectedProgramme.addTutorialGroup(selectedTutorial);
                    programmeUI.printProgrammeDetails(getAllProgrammes());
                }
            } else {
                ProgrammeMessageUI.invalidTutorialGroup();
            }

        } while (tutorialGroup < 1 || tutorialGroup > tutorialList.size());
    }

    public void deleteTutorialGroup() {
        int choice;
        int tutorialGroup;
        Programme selectedProgramme = null;
        do {
            programmeUI.printProgrammeDetails(getAllProgrammes());
            choice = programmeUI.inputChoice();
            if (choice < 1 || choice > programmeList.size()) {
                ProgrammeMessageUI.invalidProgramme();
            } else {
                selectedProgramme = programmeList.get(choice);
            }
        } while (choice < 1 || choice > programmeList.size());

        do {
            programmeUI.printTutorialDetails(getAllTutorialGroup());

            tutorialGroup = programmeUI.inputTutorialGroup();

            if (tutorialGroup >= 1 && tutorialGroup <= tutorialList.size()) {
                Tutorial selectedTutorial = tutorialList.get(tutorialGroup);
                if (!selectedProgramme.getTutorialGroup().contains(selectedTutorial)) {
                    ProgrammeMessageUI.displayTutorialAlreadyDeletedMessage();
                } else {
                    selectedProgramme.deleteTutorialGroup(selectedTutorial);
                    programmeUI.printProgrammeDetails(getAllProgrammes());
                }
            } else {
                ProgrammeMessageUI.invalidTutorialGroup();
            }

        } while (tutorialGroup < 1 || tutorialGroup > tutorialList.size());
    }

    public String getAllTutorialGroup() {
        String outputStr = "";
        for (int i = 1; i <= tutorialList.size(); i++) {
            outputStr += i + ".\t" + tutorialList.get(i) + "\n";
        }
        return outputStr;
    }

    public void generateReport() {
        programmeUI.printReportDetails();
        programmeUI.printProgrammeDetails(getAllProgrammes());

        for (int i = 1; i <= programmeList.size(); i++) {
            Programme programme = programmeList.get(i);
            int sumOfGroups = programme.getTutorialGroup().size();
            programmeUI.printProgrammes(programme);
            programmeUI.printGroupOfProgramme(sumOfGroups);
        }

        int totalProgrammes = getTotalProgrammes();
        int totalTutorialGroups = getTotalTutorialGroups();

        programmeUI.printTotalProgrammes(totalProgrammes);
        programmeUI.printTotalTutorialGroups(totalTutorialGroups);
    }

    private int getTotalProgrammes() {
        return programmeList.size();
    }

    private int getTotalTutorialGroups() {
        int sumOfGroups = 0;
        for (int i = 1; i <= programmeList.size(); i++) {
            Programme programme = programmeList.get(i);
            sumOfGroups += programme.getTutorialGroup().size();
        }
        return sumOfGroups;
    }

    public static void start() {
        ProgrammeMaintenance programmeMaintenance = new ProgrammeMaintenance();
        programmeMaintenance.runProgrammeMaintenance();
    }

    public static void main(String[] args) {
        ProgrammeMaintenance programmeMaintenance = new ProgrammeMaintenance();
        programmeMaintenance.runProgrammeMaintenance();
    }

}
