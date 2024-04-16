package edu.ntudp.fit.silakov.lab3.controllers;

import edu.ntudp.fit.silakov.lab3.models.Sex;
import edu.ntudp.fit.silakov.lab3.models.Student;

public class StudentCreator {
    public Student createStudent(String lastName, String firstName, String patronymicName, Sex sex) {
        return new Student(lastName, firstName, patronymicName, sex);
    }
}