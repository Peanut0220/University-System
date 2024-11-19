package dao;

import adt.*;
import entity.Tutor;
import java.io.*;

/**
 *
 * @author Lim Yi Jie
 */
public class TutorDAO {

    private String fileName = "tutor.dat";

    public void saveToFile(SortedListInterface<Tutor> pList) {
        File file = new File(fileName);
        try {
            ObjectOutputStream ooStream
                    = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(pList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile not found");
        } catch (IOException ex) {
            System.out.println("\nCannot save to file" + ex);
        }
    }

    public SortedListInterface<Tutor> retrieveFromFile() {
        File file = new File(fileName);
        SortedListInterface<Tutor> pList = new SortedDoublyLinkedList<>();
        try {
            ObjectInputStream oiStream
                    = new ObjectInputStream(new FileInputStream(file));
            pList = (SortedDoublyLinkedList<Tutor>) 
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
