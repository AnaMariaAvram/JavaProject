package Catalog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CatalogService {

    /** Array-urile din etapa anterioara cu colectii*/
    public void addStudentAtNote( Student student, StudentGrades studentGrades) {
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("addStudentAtNote");
        ArrayList<Student> students = studentGrades.getStudentwithSNote();
        students.add(student);
        studentGrades.setStudentwithSNote(students);
    }

    public void displaySubjectProf( ArrayList<Subject> subjects, Professor professor)
    {
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("displaySubjectProfessor");
        int gasit = 0;
        System.out.println("The " + professor.getProfessorLastName()+ " teachers teaches:");

        for (int i = 0; i < subjects.size(); i++)
        {
            Subject subject = subjects.get(i);
           if (subject.getProfessor().getProfessorLastName() == professor.getProfessorLastName()
                && subject.getProfessor().getPorfessorFirstName()  == professor.getPorfessorFirstName()) {
               System.out.println("- " + subject.getSubjectName() + " ");
               gasit = 1;
           }
        }
        if(gasit == 0) System.out.println("NONE!");
    }
    public void removeStudentAtNote( StudentGrades studentGrades)
    {
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("removeStudentAtNote");
        ArrayList<Student> students = studentGrades.getStudentwithSNote();
        int cnt = students.size();

        ///stergem ultimul student adaugat
        students.remove(cnt-1);
        studentGrades.setStudentwithSNote(students);
    }
    public void removeAllStudentAtNote( StudentGrades studentGrades)
    {
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("removeAllStudentAtNote");
        ArrayList<Student> students = studentGrades.getStudentwithSNote();

        ///stergem tot studentii
        students.clear();
        studentGrades.setStudentwithSNote(students);
    }

    public void sortStudentsAlphabetically(  ArrayList<Student> students)
    {
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("sortAlphabeticallyStudent");

        ///sortam toti studentii alfabetic
        Collections.sort(students, new NameComparator());
    }

    public void displayFatherV( ArrayList<Student> students)
    {
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("displayFatherVocal");
        int gasit = 0;
        System.out.println("Students with the father's name that begin with AEIOU are: ");

        String [] allowedInitials = new String[]{"A", "E", "I", "O", "U"};
        for(int i = 0; i < students.size(); i++) {
            String charKey =  students.get(i).getStudentFatherInitial();
            if (Arrays.binarySearch(allowedInitials, charKey)>=0)
                {
                    gasit = 1;
                    System.out.println(students.get(i).getStudentLastName());
                }
        }
        if(gasit != 1)
        System.out.println("None!");
    }
    public void calculateSeniorityTeacher( Professor professorr)
    //In medie un profesor profeseaza pentru prima data la 24 de ani
    {
        AuditService writeService = new AuditService();
        writeService.WriteActionsToCSVFile("calculateSeniorityTeacher");
        int yearr = professorr.getProfessorAge() - 24;
        if(yearr > 0 )
        System.out.println( professorr.getPorfessorFirstName() + " " + professorr.getProfessorLastName() + " has been practicing for " + yearr + " years.");
        else
            System.out.println(professorr.getPorfessorFirstName() + " " + professorr.getProfessorLastName() + " is not yet a teacher!");
    }

    public void displayYearOfBirthStudent(Student student)
    {
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("displayYearOfBirthStudent");
        int year = 2021 - (int)student.getStudentAge();
        System.out.println( student.getStudentFirstName() + " " + student.getStudentLastName() + " was born in " + year + ".");
    }
    public void changeProfessorClass( ProfessorClass professor, Class clasa)
    {
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("changeProfessorClass");
        System.out.println("This professor has been moved from the " + professor.getIdClass() +" class to the " + clasa + " class." );
        professor.setIdClass(clasa.getNrClass());
    }

}
