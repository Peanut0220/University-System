package utility;

/**
 *
 * @author Ng Chong Jian, Lim Yi Jie
 */
public class MessageUI {

    public static void displayInvalidChoiceMessage() {
        System.out.println("\nInvalid choice\n");
    }

    public static void displayExitMessage() {
        System.out.println("\nExiting system\n");
    }

    public static void displayDeleteMessage() {
        System.out.println("\nSuccessful Delete\n");
    }

    public static void displayAddMessage() {
        System.out.println("\nSuccessful Added\n");
    }

    public static void displayNotFoundMessage() {
        System.out.println("\nID is not found!\n");
    }

    public static void displayUnsuccessfulDeleteMessage() {
        System.out.println("\nUnsuccessfully deleted, please try again!\n");
    }

    public static void displayChoiceFormatErrorMessage() {
        System.out.println("\nchoice should be integer!\n");
    }

    public static void displayListErrorMessage() {
        System.out.println("\nDisplay Error Occured!\n");
    }

    public static void displayFilterErrorMessage() {
        System.out.println("\nFilter unsuccessfully!\n");
    }

    public static void displayAddErrorMessage() {
        System.out.println("\nUnsuccesfully added, please try again!\n");
    }

    public static void displayChangeErrorMessage() {
        System.out.println("\nUnsuccesfully changed, please try again!\n");
    }

    public static void displayStudentNotFoundMessage() {
        System.out.println("\nStudent Not Found!\n");
    }

    public static void displayChangeMessage() {
        System.out.println("\nSuccessfully changed!\n");
    }


    public static void displayTutorNotFoundMessage() {
        System.out.println("Tutor is not found !");
    }

    public static void displaySuccessfulAddMessage() {
        System.out.println("Successful Added !");
    }

    public static void displayUnsuccessfulAddMessage() {
        System.out.println("Unsuccessful Added !");
    }

    public static void displaySuccessfulDeleteMessage() {
        System.out.println("Successful Deleted !");
    }

    public static void displaySuccessfulAmendMessage() {
        System.out.println("Successful Amend !");
    }

    public static void displayUnsuccessfulAmendMessage() {
        System.out.println("Unsuccessful Amend !");
    }
 
    public static void displayInvalidRate() {
        System.out.println("Maximum rate must be equal greater than minimum rate. Please re-enter.");
    }

    public static void displayInvalidAge() {
        System.out.println("Maximum age must be equal or greater than minimum age. Please re-enter.");
    }

    public static void displayErrorMessage(){
         System.out.printf("\nInvalid choice. Please enter again.\n\n");
    }

   

}
