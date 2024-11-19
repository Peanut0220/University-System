//LimShiLei
package entity;

import adt.LinkedMap;
import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable{

    private String courseCode;
    private String courseName;
    private LinkedMap<String, ProgrammeV2> programmeList;

    public Course() {
    }

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.programmeList = new LinkedMap<>();
    }

    public Course(String courseCode, String courseName, LinkedMap<String, ProgrammeV2> programmeList) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.programmeList = programmeList;
    }

    @Override
    public String toString() {
        String outputStr = "";
        outputStr += courseCode + "\t" + courseName + "\t";
        for (LinkedMap.Entry<String, ProgrammeV2> entry : programmeList.entrySet()) {
            ProgrammeV2 prog = entry.getValue();
            outputStr += prog.getProgrammeCode() + "\t";
        }
        return outputStr;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.courseCode);
        return hash;
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
        final Course other = (Course) obj;
        return Objects.equals(this.courseCode, other.courseCode);
    }

    public LinkedMap<String, ProgrammeV2> getProgrammeList() {
        return programmeList;
    }

    public void setProgrammeList(LinkedMap<String, ProgrammeV2> programmeList) {
        this.programmeList = programmeList;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
