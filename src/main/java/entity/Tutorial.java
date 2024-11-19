/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Yew Zi Yu
 */
public class Tutorial implements Comparable<Tutorial>{

    private String tutorialGroup;
    private int numberOfStudent;

    public Tutorial() {
    }

    public Tutorial(String tutorialGroup, int numberOfStudent) {
        this.tutorialGroup = tutorialGroup;
        this.numberOfStudent = numberOfStudent;
    }


    public String getTutorialGroup() {
        return tutorialGroup;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setTutorialGroup(String tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    @Override
    public String toString() {
        return "  "+tutorialGroup + "\t\t\t" + numberOfStudent;
    }

    @Override
    public int compareTo(Tutorial o) {
        return this.tutorialGroup.compareTo(o.tutorialGroup);
    }

}
