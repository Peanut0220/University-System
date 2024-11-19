/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Lim Yi Jie
 */
public class Tutor implements Comparable<Tutor>, Serializable {

    private String id;
    private String name;
    private int age;
    private String phone;
    private double salary;
    private String type;
    private double rating;

    public Tutor() {
    }

    public Tutor(String id, String name, int age, String phone, double salary, String type, double rating) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.salary = salary;
        this.type = type;
        this.rating = rating;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Tutor other = (Tutor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Tutor o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%-7s %-15s %-5d %-12s RM%-8.2f %-10s %-3.1f", id, name, age, phone, salary, type, rating);

    }

}
