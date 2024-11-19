package dao;

import adt.*;
import entity.TutorialGroup;
import java.io.*;

/**
 *
 * @author Ng Chong Jian
 */
public class TutorialGroupDAO implements Serializable{

    private String fileName = "tutorialGroup.dat"; 

    public void saveToFile(SortedListInterface<TutorialGroup> pList) {
        File file = new File(fileName);
        try {
            ObjectOutputStream ooStream 
                    = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(pList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile not found");
        } catch (IOException ex) {
            System.out.println("\nCannot save to file"+ex);
        }
    }

    public SortedListInterface<TutorialGroup> retrieveFromFile() {
        File file = new File(fileName);
        SortedListInterface<TutorialGroup> pList 
                = new SortedDoublyLinkedList<>();
        try {
            ObjectInputStream oiStream 
                    = new ObjectInputStream(new FileInputStream(file));
            pList = (SortedDoublyLinkedList<TutorialGroup>) 
                    (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nNo such file.");
        } catch (IOException ex) {
            System.out.println("\nCannot read from file.");
        } catch (ClassNotFoundException ex) {
            System.out.println("\nClass not found.");
        } finally {
            return pList;
        }
    }
}
