package entity;

import adt.SortedDoublyLinkedList;
import adt.SortedListInterface;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ng Chong Jian
 */
public class TutorialGroup implements Comparable<TutorialGroup>, 
        Serializable {

    private String groupID;
    private String tutor;
    private SortedListInterface<Student> studentList;

    public TutorialGroup() {
        this.studentList = new SortedDoublyLinkedList<>();
    }

    public TutorialGroup(String groupID, String tutor, 
            SortedListInterface<Student> studentList) {
        this.groupID = groupID;
        this.tutor = tutor;
        this.studentList = studentList;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public SortedListInterface<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(SortedListInterface<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.groupID);
        return hash;
    }

    @Override
    public String toString() {
        String str = "";
        str = String.format("Tutorial Group: %-6s \nTutor: %-20s "
                + "\nNo Of Students: %-3d\n", groupID, tutor, 
                studentList.getNumberOfEntries());
        str += String.
                format("+==========================================+\n");
        str += String.format("|%-10s %-20s %-3s %-6s|\n", "StudentID", 
                "StudentName", "Age", "Gender");
        str += String.
                format("+==========================================+\n");
        str += studentList.display();
        str += String.
                format("+==========================================+\n");
        return str;
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
        final TutorialGroup other = (TutorialGroup) obj;
        return Objects.equals(this.groupID, other.groupID);
    }

    @Override
    public int compareTo(TutorialGroup o) {
        return this.groupID.compareTo(o.groupID);
    }

}
