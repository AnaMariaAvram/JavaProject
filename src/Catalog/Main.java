package Catalog;
import Exceptions.FileReadingException;
import Exceptions.FileWritingException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws FileReadingException, FileWritingException
    {
        ArrayList<ArrayList<String>> myProfessors = new ArrayList<ArrayList<String>>();
        myProfessors = ReadFromCSVFile.readFromStudentFile("Professor.csv");
        System.out.println(myProfessors);

        Professor professor1 = new Professor(myProfessors.get(0).get(0),myProfessors.get(1).get(0),Integer.parseInt(myProfessors.get(2).get(0)),Integer.parseInt(myProfessors.get(3).get(0)));
        Professor professor2 = new Professor(myProfessors.get(0).get(1),myProfessors.get(1).get(1),Integer.parseInt(myProfessors.get(2).get(1)),Integer.parseInt(myProfessors.get(3).get(1)));
        Professor professor3 = new Professor(myProfessors.get(0).get(2),myProfessors.get(1).get(2),Integer.parseInt(myProfessors.get(2).get(2)),Integer.parseInt(myProfessors.get(3).get(2)));
        Professor professor4 = new ProfessorClass("Pop", "Mihai",22,2700, "094");
        ProfessorClass professor5 = new ProfessorClass("Balan" , "Lucretia", 42,5320, "103");

        Class class1 = new Class("021");
        Class class2 =  new Class("304");

        Subject subject1 = new Subject(SubjectList.ENGLISH,professor1);
        Subject subject2 = new Subject(SubjectList.CHEMISTRY,professor1);
        Subject subject3 = new Subject(SubjectList.GEOGRAPHY,professor3);
        Subject subject4 = new Subject(SubjectList.MATHEMATICS,professor2);

        System.out.println(professor1);
        ArrayList<ArrayList<String>> myStudents = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> myStudentsTaxa = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> myStudentsBudget = new ArrayList<ArrayList<String>>();

        ///#incarcam datele in fisier folosind clasa serviciu#
        myStudents = ReadFromCSVFile.readFromStudentFile("Student.csv");
        myStudentsTaxa = ReadFromCSVFile.readFromStudentFile("StudentTaxa.csv");
        myStudentsBudget = ReadFromCSVFile.readFromStudentFile("StudentBudget.csv");

        System.out.println(myStudents);
        System.out.println(myStudentsTaxa);
        System.out.println(myStudentsBudget);

        Student student1 = new Student(myProfessors.get(0).get(0),myProfessors.get(1).get(0),(myProfessors.get(2).get(0)).charAt(0),Integer.parseInt(myProfessors.get(3).get(0)));
        Student student2 = new Student("Avram","Ana",'G',18);
        Student student3 = new StudentTaxa("Avram","Larisa",'O',21,1);
        Student student4 = new StudentTaxa("Vilceanu","Cristina",'L',23,2);
        Student student5 = new StudentBudget("Popa","Miruna",'S',23,1);

        ///cu ajutorul clasei catalog service putem face diverse modificari
        CatalogService catalogService = new CatalogService();

        System.out.println("\n"+ professor5);
        catalogService.changeProfessorClass(professor5,class2);
        System.out.println(professor5+"\n");


        ///sa se afiseze ce materii preda profesorul ales de mine
        ArrayList<Subject> subjects = new ArrayList<>(Arrays.asList(subject1,subject2,subject3,subject4));

        catalogService.displaySubjectProf(subjects,professor1);
        catalogService.displaySubjectProf(subjects,professor4);
        System.out.println();

        ///calculam si afisam anul nasterii unui student
        catalogService.displayYearOfBirthStudent(student2);

        ///verificam daca un profesor este profesor sau nu
        ///il consideram profesor daca are peste 24 de ani,la varsta aceasta are studii terminate,cel mai probabil
        catalogService.calculateSeniorityTeacher(professor1);
        catalogService.calculateSeniorityTeacher(professor4);

        ArrayList<Student> studentts = new ArrayList<>(Arrays.asList(student1,student4,student2,student3));

        ///afisam studentii care au initiala tatalui  vocala
        catalogService.displayFatherV(studentts);

        ///sortam alfabetic studentii
        catalogService.sortStudentsAlphabetically(studentts);
        StudentGrades studentGrades1 = new StudentGrades(5,studentts);
        StudentGrades studentGrades2 = new StudentGrades(10,studentts);
        StudentGrades studentGrades3 = new StudentGrades(9,studentts);

        ArrayList<StudentGrades> studentsGradesArray = new ArrayList<>(Arrays.asList(studentGrades1,studentGrades2,studentGrades3));

         ///adaugam un student in lista de studenti care au obtinut nota respectiva
        catalogService.addStudentAtNote(student4,studentGrades1);

        ///Stergem ultimul student din lista de studenti care a obtinut nota respectiva
        catalogService.removeStudentAtNote(studentGrades1);

        ///stergem toti studentii care au obtinut nota respectiva
        catalogService.removeAllStudentAtNote(studentGrades3);


    }

}
