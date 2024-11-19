package control;

import adt.*;
import boundary.TutorMaintenanceUI;
import dao.TutorDAO;
import entity.Tutor;
import java.util.Iterator;
import utility.MessageUI;

/**
 *
 * @author Lim Yi Jie
 */
public class TutorMaintenance {

    private SortedListInterface<Tutor> tutorList
            = new SortedDoublyLinkedList<>();
    private TutorDAO tutorDAO = new TutorDAO();
    private TutorMaintenanceUI tutorUI = new TutorMaintenanceUI();

    public TutorMaintenance() {
        tutorList = tutorDAO.retrieveFromFile();
    }

    public void runTutorMaintenance() {
        int choice = 0;
        do {
            choice = tutorUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;

                case 1:
                    addNewTutor();
                    break;

                case 2:
                    removeTutor();
                    break;

                case 3:
                    findTutor();
                    break;

                case 4:
                    amendTutor();
                    break;

                case 5:
                    displayTutor();
                    break;

                case 6:
                    filterTutor();
                    break;

                case 7:
                    report();
                    break;

                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public String getAllTutor() {
        String outputStr = "";
        for (int i = 0; i < tutorList.getNumberOfEntries(); i++) {
            outputStr += tutorList.getEntry(i) + "\n";
        }
        return outputStr;
    }

    //case 5 display tutor
    public void displayTutor() {
        tutorUI.listAllTutor(getAllTutor());
    }

    //case 1 add tutor
    public void addNewTutor() {
        Tutor newTutor = tutorUI.inputTutorDetails();
        tutorList.add(newTutor);
        tutorDAO.saveToFile(tutorList);
        MessageUI.displaySuccessfulAddMessage();
        displayTutor();
    }

    //case 2 remove tutor
    private Tutor searchTutor1() {
        String find = tutorUI.inputSearchDetails();
        Tutor foundtutor = null;
        Iterator<Tutor> iterator = tutorList.getIterator();
        int found = 0;
        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();
            if (tutor.getId().equals(find) 
                    || tutor.getName().equals(find)) {
                found = 1;
                foundtutor = tutor;
            }

        }
        if (found == 1) {
            return foundtutor;
        }
        MessageUI.displayTutorNotFoundMessage();
        return null;

    }

    private void removeTutor() {
        Tutor outputStr = searchTutor1();

        if (outputStr != null) {
            System.out.println(outputStr);
            int confirm = tutorUI.confirmOperation();

            if (confirm == 1) {
                tutorList.remove(outputStr);
                tutorDAO.saveToFile(tutorList);
                MessageUI.displaySuccessfulDeleteMessage();
            } else {
                MessageUI.displayUnsuccessfulDeleteMessage();
            }

        }
    }

    //case 3 findTutor
    private String searchTutor() {
        String outputStr = "";
        String find = tutorUI.inputSearchDetails();
        Tutor foundtutor = null;
        Iterator<Tutor> iterator = tutorList.getIterator();
        int found = 0;
        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();
            if (tutor.getId().equals(find) 
                    || tutor.getName().equals(find)) {
                found = 1;
                foundtutor = tutor;
            }

        }
        if (found == 1) {
            outputStr += foundtutor.toString();
            return outputStr;
        }
        MessageUI.displayTutorNotFoundMessage();
        return null;

    }

    private void findTutor() {
        tutorUI.listAllTutor(searchTutor());
    }

    //case 4 amend tutor details
    private void amendTutor() {
        Tutor outputStr = searchTutor1();
        if (outputStr != null) {
            System.out.println(outputStr);
            int confirm = tutorUI.confirmOperation();
            if (confirm == 1) {
                Tutor newTutor = tutorUI.inputTutorDetails();
                tutorList.replace(outputStr, newTutor);
                tutorDAO.saveToFile(tutorList);
                MessageUI.displaySuccessfulAmendMessage();
            } else {
                MessageUI.displayUnsuccessfulAmendMessage();
            }

        }
    }

    //case 6 filter tutor 
    private String filterCriteria() {

        int filter = tutorUI.filterChoice();
        int minAge = 0;
        int maxAge = 0;
        double minRate = 0;
        double maxRate = 0;
        String outputStr = "";
        Tutor foundtutor = null;
        int found = 0;

        if (filter == 1) {
            int age[] = tutorUI.filterAge();
            minAge = age[0];
            maxAge = age[1];
        } else if (filter == 2) {
            double rate[] = tutorUI.filterRate();
            minRate = rate[0];
            maxRate = rate[1];

        } else {
            MessageUI.displayInvalidChoiceMessage();
        }
        Iterator<Tutor> iterator = tutorList.getIterator();
        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();
            if ((tutor.getAge() >= minAge
                    && tutor.getAge() <= maxAge)
                    || (tutor.getRating() >= minRate
                    && tutor.getRating() <= maxRate)) {
                found = 1;
                foundtutor = tutor;
                outputStr += foundtutor.toString() + "\n";
            }

        }
        if (found == 1) {
            return outputStr;
        } else {
            MessageUI.displayTutorNotFoundMessage();

        }
        return null;

    }

    public void filterTutor() {
        tutorUI.listAllTutor(filterCriteria());
    }

    //case 7 generate report
    public int[] report1() {
        int[] count = new int[3];
        int partTime = 0;
        int fullTime = 0;

        Iterator<Tutor> iterator = tutorList.getIterator();
        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();
            if (tutor.getType().equals("FullTime")) {
                fullTime++;

            } else {
                partTime++;
            }
        }
        count[0] = tutorList.getNumberOfEntries();
        count[1] = partTime;
        count[2] = fullTime;

        return count;
    }

    public double[] report2() {
        double partTimeAge = 0;
        double fullTimeAge = 0;
        double partTime = 0.0;
        double fullTime = 0.0;
        double[] count = new double[9];
        double partTimeRate = 0.0;
        double fullTimeRate = 0.0;
        double partTimeSalary = 0.0;
        double fullTimeSalary = 0.0;
        Iterator<Tutor> iterator = tutorList.getIterator();
        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();
            if (tutor.getType().equals("FullTime")) {
                fullTimeAge += tutor.getAge();
                fullTimeRate += tutor.getRating();
                fullTimeSalary += tutor.getSalary();
                fullTime++;
            } else {
                partTimeAge += tutor.getAge();
                partTimeRate += tutor.getRating();
                partTimeSalary += tutor.getSalary();
                partTime++;

            }
        }
        count[0] = (partTimeRate + fullTimeRate)
                / tutorList.getNumberOfEntries();
        count[1] = partTimeRate / partTime;
        count[2] = fullTimeRate / fullTime;
        count[3] = (partTimeSalary + fullTimeSalary)
                / tutorList.getNumberOfEntries();
        count[4] = partTimeSalary / partTime;
        count[5] = fullTimeSalary / fullTime;
        count[6] = (fullTimeAge + partTimeAge)
                / tutorList.getNumberOfEntries();
        count[7] = fullTimeAge / fullTime;
        count[8] = partTimeAge / partTime;
        return count;
    }

    private void report() {
        tutorUI.generateReport(report1(), report2());
    }

    public static void start() {
        TutorMaintenance tutorMaintenance = new TutorMaintenance();
        tutorMaintenance.runTutorMaintenance();
    }

    public static void main(String[] args) {
        TutorMaintenance tutorMaintenance = new TutorMaintenance();
        tutorMaintenance.runTutorMaintenance();
    }

}
