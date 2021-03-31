package Catalog;
import java.sql.SQLOutput;
import java.util.Arrays;
public class CatalogService {

    public void AddStudentAtNote( Student student, StudentGrades studentGrades)
    {

        Student[] studentGradesArray = studentGrades.getStudentwithSNote();
        System.out.println();
        System.out.println("The initial vector of student is:");
        for(int i = 0; i < studentGradesArray.length; i++)
            System.out.println(studentGradesArray[i] + " ");
        int n = studentGradesArray.length;
        Student[] new_StudentGrades = new Student[n+1];

        for(int i = 0; i < n; i++) {
            new_StudentGrades[i] = studentGradesArray[i];
        }
        new_StudentGrades[n] = student;

        System.out.println();
        System.out.println("The final vector of student is:");
        for(int i = 0; i < new_StudentGrades.length; i++)
            System.out.println(new_StudentGrades[i] + " ");

        studentGrades.setStudentwithSNote(new_StudentGrades);
    }
    public void displaySubjectProf( Subject subjects[], Professor professor)
    {
        int gasit = 0;
        System.out.println("The " + professor.getProfessorLastName()+ " teachers teaches:");

        for (int i = 0; i < subjects.length; i++)
        {
            Subject subject = subjects[i];
           if (subject.getProfessor().getProfessorLastName() == professor.getProfessorLastName()
                && subject.getProfessor().getPorfessorFirstName()  == professor.getPorfessorFirstName()) {
               System.out.println("- " + subject.getSubjectName() + " ");
               gasit = 1;
           }
        }
        if(gasit == 0) System.out.println("NONE!");
    }

    public void removeStudent( StudentGrades studentGrades)
    {
        Student[] studentGradesArray = studentGrades.getStudentwithSNote();

        System.out.println();
        System.out.println("The initial vector of student is:");
        for(int i = 0; i < studentGradesArray.length; i++)
            System.out.println(studentGradesArray[i] + " ");

        int n = studentGradesArray.length;
        Student[] new_StudentGrades = new Student[n-1];

        for(int i = 0; i < n-1; i++) {
            new_StudentGrades[i] = studentGradesArray[i];
        }

        System.out.println();
        System.out.println("The final vector of student is:");
        for(int i = 0; i < new_StudentGrades.length; i++)
            System.out.println(new_StudentGrades[i] + " ");

        studentGrades.setStudentwithSNote(new_StudentGrades);
    }
    public void removeAllStudent( StudentGrades studentGrades)
    {
        Student[] studentGradesArray = studentGrades.getStudentwithSNote();

        int n = studentGradesArray.length;
        Student[] new_StudentGrades = new Student[0];
        studentGrades.setStudentwithSNote(new_StudentGrades);
        System.out.println("\nEmpty!");
    }
    public void sortStudentsAlphabetically( Student  students[])
    {
        NameComparator nameComparator = new NameComparator();
        Arrays.sort(students,nameComparator);
    }

    public void displayFatherV(Student students[])
    {
        int gasit = 0;
        System.out.println("Students with the father's name that begin with AEIOU are: ");
        for(int i = 0; i < students.length; i++)
            if(students[i].getStudentFatherInitial() == 'A' || students[i].getStudentFatherInitial() == 'E' || students[i].getStudentFatherInitial() == 'I' || students[i].getStudentFatherInitial() == 'O' || students[i].getStudentFatherInitial() == 'U' )
            {
                gasit = 1;
                System.out.println(students[i].getStudentLastName());
            }
        if(gasit != 1)
        System.out.println("None!");
    }
    public void calculateSeniorityTeacher( Professor professorr)
    //In medie un profesor profeseaza pentru prima data la 24 de ani
    {
        int yearr = professorr.getProfessorAge() - 24;
        if(yearr > 0 )
        System.out.println( professorr.getPorfessorFirstName() + " " + professorr.getProfessorLastName() + " has been practicing for " + yearr + " years.");
        else
            System.out.println(professorr.getPorfessorFirstName() + " " + professorr.getProfessorLastName() + " is not yet a teacher!");
    }

    public void displayYearOfBirthStudent(Student student)
    {
        int year = 2021 - student.getStudentAge();
        System.out.println( student.getStudentFirstName() + " " + student.getStudentLastName() + " was born in " + year + ".");
    }
    public void changeProfessorClass( ProfessorClass professor, Class clasa)
    {
        System.out.println("This professor has been moved from the " + professor.getIdClass() +" class to the " + clasa + " class." );
        professor.setIdClass(clasa.getNrClass());
    }

}
