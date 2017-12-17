package main;

import application.StudentInfo;
import pupil.Student;

import java.io.File;

/**
 * Created by Helga on 12/3/2017.
 */
public class Main {

    public static void main(String[] args) {
        StudentInfo studentInfo = new StudentInfo(new File("scholars.txt"));
        studentInfo.print();
        studentInfo.printInOrder();
        System.out.println("How many study at Gymnasium#50 : "+studentInfo.studyAt("Gymnasium#50"));

        System.out.println("\n***   ***   ***   ***   ***  *** ***\n");

        StudentInfo studentInfo2 = new StudentInfo(new File("students.txt"));
        studentInfo2.print();
        studentInfo2.printInOrder();
        System.out.println("How many study at BSU : "+studentInfo2.studyAt("BSU"));

    }
}
