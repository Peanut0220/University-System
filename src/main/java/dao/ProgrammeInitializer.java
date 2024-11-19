/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.QueueInterface;
import adt.PriorityQueue;
import entity.Programme;
import entity.Tutorial;

/**
 *
 * @author Yew Zi Yu
 */

public class ProgrammeInitializer {

    public QueueInterface<Programme> initializeProgrammes(QueueInterface<Tutorial> tutorialList) {
        QueueInterface<Programme> programmeList = new PriorityQueue<>();
        programmeList.enqueue(new Programme("RSD", "Bachelor of Information Technology", "Lee Yan Yan"));
        programmeList.enqueue(new Programme("CS", "Bachelor of Computer Science", "John Doe"));
        programmeList.enqueue(new Programme("SE", "Bachelor of Software Engineering", "Jane Smith"));

        programmeList.get(1).addTutorialGroup(tutorialList.get(1));
        programmeList.get(1).addTutorialGroup(tutorialList.get(2));
        programmeList.get(1).addTutorialGroup(tutorialList.get(3));
        programmeList.get(2).addTutorialGroup(tutorialList.get(3));
        programmeList.get(3).addTutorialGroup(tutorialList.get(2));
        return programmeList;
    }

}
