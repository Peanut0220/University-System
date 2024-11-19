/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.PriorityQueue;
import adt.QueueInterface;
import entity.Tutorial;

/**
 *
 * @author Yew Zi Yu
 */
public class TutorialGroupInitializer {

    public QueueInterface<Tutorial> initializeTutorials() {
        QueueInterface<Tutorial> tutorialList = new PriorityQueue<>();

        // Initialize tutorial groups
        tutorialList.enqueue(new Tutorial("Group 1", 23));
        tutorialList.enqueue(new Tutorial("Group 2", 20));
        tutorialList.enqueue(new Tutorial("Group 3", 25));
        // Add more tutorial groups as needed

        return tutorialList;
    }
}
