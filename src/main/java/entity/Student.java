package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ng Chong Jian
 */
public class Student implements Comparable<Student>, Serializable {

    private String id;
    private String name;
    private int age;
    private String gender;

    public Student() {
    }

    public Student(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Student other = (Student) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-3d %-6s",id,name,age,gender);
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }

}
