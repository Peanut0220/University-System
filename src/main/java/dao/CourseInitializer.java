//LimShiLei
package dao;

import adt.LinkedMap;
import entity.Course;
import entity.ProgrammeV2;

public class CourseInitializer {

    public LinkedMap<String, Course> initializeCourses() {
        LinkedMap<String, Course> courseMap = new LinkedMap<>();
        LinkedMap<String, ProgrammeV2> programme = new LinkedMap<>();
        LinkedMap<String, ProgrammeV2> programme1 = new LinkedMap<>();
        LinkedMap<String, ProgrammeV2> programme2 = new LinkedMap<>();
        LinkedMap<String, ProgrammeV2> programme3 = new LinkedMap<>();
        LinkedMap<String, ProgrammeV2> programme4 = new LinkedMap<>();
        LinkedMap<String, ProgrammeV2> programme5 = new LinkedMap<>();
        ProgrammeV2 prog = new ProgrammeV2("DFT", "Diploma in Information Technology", "Graduates will have the skills needed for a successful career in the IT industry.");
        ProgrammeV2 prog1 = new ProgrammeV2("DRT", "Diploma in Fine Arts", "Students explore various forms of visual and performing arts in this creative program.");
        ProgrammeV2 prog2 = new ProgrammeV2("DSI", "Diploma in Science Exploration", "This program covers a wide range of scientific disciplines, from biology to physics.");
        ProgrammeV2 prog3 = new ProgrammeV2("DEG", "Diploma in Engineering", "This engineering program covers a wide range of engineering disciplines.");
        ProgrammeV2 prog4 = new ProgrammeV2("BBA", "Bachelor of Business Administration", "This program focuses on business management, leadership, and entrepreneurship.");
        ProgrammeV2 prog5 = new ProgrammeV2("BCS", "Bachelor of Computer Science", "This program covers advanced topics in computer science, including artificial intelligence and machine learning.");
        ProgrammeV2 prog6 = new ProgrammeV2("BFA", "Bachelor of Finance and Accounting", "This program equips students with financial analysis and accounting skills for careers in finance.");

        programme.put("DFT", prog);
        programme.put("DRT", prog1);
        programme1.put("DSI", prog2);
        programme1.put("DEG", prog3);
        programme2.put("BBA", prog4);
        programme2.put("BCS", prog5);
        programme3.put("BFA", prog6);
        courseMap.put("BACS2063", new Course("BACS2063", "Data Structure and Algorithm", programme));
        courseMap.put("BACS2053", new Course("BACS2053", "Object Oriented Analysis and Design", programme2));
        courseMap.put("BASC2042", new Course("BASC2042", "Research Method", programme3));
        courseMap.put("BAIT2203", new Course("BAIT2203", "Human Computer Interaction", programme4));
        courseMap.put("AJEL1013", new Course("AJEL1013", "English for Tertiary Studies", programme5));
        courseMap.put("AAMS1623", new Course("AAMS1623", "Calculus and Algebra", programme1));
        return courseMap;
    }

    public LinkedMap<String, ProgrammeV2> initializeProgrammes() {
        LinkedMap<String, ProgrammeV2> programmeMap = new LinkedMap<>();
        programmeMap.put("DFT", new ProgrammeV2("DFT", "Information Technology", "Graduates will have the skills needed for a successful career in the IT industry."));
        programmeMap.put("DRT", new ProgrammeV2("DRT", "Diploma in Fine Arts", "Students explore various forms of visual and performing arts in this creative program."));
        programmeMap.put("DSI", new ProgrammeV2("DSI", "Diploma in Science Exploration", "This program covers a wide range of scientific disciplines, from biology to physics."));
        programmeMap.put("DEG", new ProgrammeV2("DEG", "Diploma in Engineering", "This engineering program covers a wide range of engineering disciplines."));
        programmeMap.put("BBA", new ProgrammeV2("BBA", "Bachelor of Business Administration", "This program focuses on business management, leadership, and entrepreneurship."));
        programmeMap.put("BCS", new ProgrammeV2("BCS", "Bachelor of Computer Science", "This program covers advanced topics in computer science, including artificial intelligence and machine learning."));
        programmeMap.put("BFA", new ProgrammeV2("BFA", "Bachelor of Finance and Accounting", "This program equips students with financial analysis and accounting skills for careers in finance."));
        return programmeMap;
    }
}
