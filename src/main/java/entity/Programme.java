/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.PriorityQueue;
import adt.QueueInterface;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Yew Zi Yu
 */
public class Programme implements Comparable<Programme>{

    //private static int idCounter = 0;
    private String progCode;
    private String progName; //RSD
    private String advisoryName;
    private QueueInterface<Tutorial> tutorialGroup;

    public Programme() {
    }

    public Programme(String progCode, String progName, String advisoryName) {
        this.progCode = progCode;
        this.progName = progName;
        this.advisoryName = advisoryName;
        this.tutorialGroup = new PriorityQueue<>();
    }

    public void setProgCode(String progCode) {
        this.progCode = progCode;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public void setAdvisoryName(String advisoryName) {
        this.advisoryName = advisoryName;
    }

    public String getProgCode() {
        return progCode;
    }

    public String getProgName() {
        return progName;
    }

    public String getAdvisoryName() {
        return advisoryName;
    }

    public QueueInterface<Tutorial> getTutorialGroup() {
        return tutorialGroup;
    }

    public void setTutorialGroup(QueueInterface<Tutorial> tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public void addTutorialGroup(Tutorial tutorial) {
        tutorialGroup.enqueue(tutorial);
    }

    public void deleteTutorialGroup(Tutorial tutorial) {
        QueueInterface<Tutorial> tempQueue = new PriorityQueue<>();

        while (!tutorialGroup.isEmpty()) {
            Tutorial currentTutorial = tutorialGroup.dequeue();

            if (!currentTutorial.equals(tutorial)) {
                // If it's not the tutorial to delete, enqueue it in the tempQueue
                tempQueue.enqueue(currentTutorial);
            }
        }

        // Replace the original tutorialGroup with the tempQueue
        tutorialGroup = tempQueue;
    }

    private String displayTutorialGroup() {
        String outputStr = "";
        outputStr += "\nTutorial Group:\n";
        for (int i = 1; i <= tutorialGroup.size(); i++) {
            outputStr += i + ". " + tutorialGroup.get(i) + " students" + "\n";
        }
        return outputStr;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programme other = (Programme) obj;
        return Objects.equals(this.progCode, other.progCode);
    }

    @Override
    public int compareTo(Programme o) {
        return this.progCode.compareTo(o.progCode);
    }

    @Override
    public String toString() {
        return String.format("%-22s %-30s %20s %20s", progCode, progName, advisoryName, displayTutorialGroup());
    }

}
