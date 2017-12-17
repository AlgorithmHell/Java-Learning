package application;

/**
 * Created by Helga on 12/3/2017.
 */

import exceptions.InvalidFileInfoException;
import pupil.Pupil;
import pupil.Scholar;
import pupil.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StudentInfo< T extends Pupil> {

   private ArrayList<T> pupils;

   public StudentInfo(File file)  {
       try {
           Scanner in = new Scanner(file);
           boolean isScholar;
           if(file.getName().equals("students.txt")) {
               isScholar = false;
           }
               else {
               if (file.getName().equals("scholars.txt")) {
                  isScholar = true;
               } else throw new InvalidFileInfoException("Unexpected Filename");
           }

           String surname;
           String school;
           double score;
           int grade;
           int amount = isScholar ? 5 : 4;
           pupils = new ArrayList<>();

           while(in.hasNextLine()){
               StringTokenizer stringTokenizer = new StringTokenizer(in.nextLine());
               if(stringTokenizer.hasMoreTokens())
               surname = stringTokenizer.nextToken();
               else throw new InvalidFileInfoException("Invalid File Info");
               if(stringTokenizer.hasMoreTokens())
               school = stringTokenizer.nextToken();
               else throw new InvalidFileInfoException("Invalid File Info");
               if(stringTokenizer.hasMoreTokens())
               score = Double.parseDouble(stringTokenizer.nextToken());
               else throw new InvalidFileInfoException("Invalid File Info");
               if(stringTokenizer.hasMoreTokens())
               grade = Integer.parseInt(stringTokenizer.nextToken());
               else throw new InvalidFileInfoException("Invalid File Info");
               if(isScholar) {
                   if(stringTokenizer.hasMoreTokens()) {
                       Scholar scholar = new Scholar(surname,school,score,grade,Integer.parseInt(stringTokenizer.nextToken()));
                       pupils.add((T)scholar);
                   }
                   else throw new InvalidFileInfoException("Invalid File Info");
               } else {
                   pupils.add((T)new Student(surname,school,score,grade));
               }

           }
       } catch (NumberFormatException e) {
           System.out.println("Input Mismatch: " + e.getMessage());
       }
       catch(FileNotFoundException e)
       {
           System.out.println("File not found "+e.getMessage());
       }
       catch(InputMismatchException e)
       {
           System.out.println("Incorrect Data ");
       }
       catch (InvalidFileInfoException e){
           System.out.println(e.getMessage());
       }

   }

   public void print() {

       for( T i : pupils) {
           System.out.println(i.toString());
       }
       System.out.println();
       System.out.println();
   }

   public int studyAt(String school) {

       ArrayList<String> schools = new ArrayList<>();
       for(T i : pupils) {
           schools.add(i.getSchool());
       }
       Collections.sort(schools, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return o1.compareTo(o2);
           }
       });
       if(schools.contains(school))
       return schools.lastIndexOf(school) - schools.indexOf(school) + 1;
       else return 0;
   }

   public void printInOrder() {
       Collections.sort(pupils, new Comparator<T>() {
           @Override
           public int compare(T o1, T o2) {
               if(o1.getSchool().compareTo(o2.getSchool()) == 0){
                   return o1.getSurname().compareTo(o2.getSurname());
               }else
               {
                   return o1.getSchool().compareTo(o2.getSchool());
               }
           }
       });
       print();
   }
}
