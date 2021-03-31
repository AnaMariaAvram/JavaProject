package Catalog;

public class main {

    public static void main(String[] args)
    {

        Professor professor1 = new Professor("Popescu","Dana",35,4300);
        ProfessorClass professor2 = new ProfessorClass("Balan" , "Lucretia", 42,5320, "103");
        Professor professor3 = new ProfessorClass("Barbu", "Carmen",25,2700, "301");
        Professor professor4 = new ProfessorClass("Pop", "Mihai",22,2700, "094");

        Class class1 = new Class("021");
        Class class2 =  new Class("304");

        Subject subject1 = new Subject(SubjectList.ENGLISH,professor1);
        Subject subject2 = new Subject(SubjectList.CHEMISTRY,professor1);
        Subject subject3 = new Subject(SubjectList.GEOGRAPHY,professor3);
        Subject subject4 = new Subject(SubjectList.MATHEMATICS,professor2);

        Subject subjects[] = new Subject[]{subject1,subject3,subject2};


        Student student1 = new Student("Avram","Ana",'G',18);
        Student student2 = new StudentTaxa("Diaconescu","Larisa",'O',21,1);
        Student student3 = new StudentTaxa("Vilceanu","Cristina",'L',23,2);
        Student student4 = new StudentBudget("Popa","Miruna",'S',23,1);
        StudentBudget student5 = new StudentBudget("Voicu","Carmen",'M',22,2);
        Student student6 = new Student("Ion","Ana",'A',18);


        CatalogService catalogService = new CatalogService();

        ///cu ajutorul clasei catalog service putem face diverse modificari
        ///ChangeProfessorClass schimba clasa la care profesorule este diriginte
        System.out.println("\n"+ professor2);
        catalogService.changeProfessorClass(professor2,class2);
        System.out.println(professor2+"\n");

        ///sa se afiseze ce materii preda profesorul ales de mine
        catalogService.displaySubjectProf(subjects,professor1);
        catalogService.displaySubjectProf(subjects,professor4);
        System.out.println();

        ///calculam si afisam anul nasterii unui student
        catalogService.displayYearOfBirthStudent(student1);

        ///verificam daca un profesor este profesor sau nu
        ///il consideram profesor daca are peste 24 de ani,la varsta aceasta are studii terminate,cel mai probabil
        catalogService.calculateSeniorityTeacher(professor1);
        catalogService.calculateSeniorityTeacher(professor4);


        Student studentss[] = new Student[]{student1,student3,student6};


        ///afisam studentii care au initiala tatalui  vocala
        catalogService.displayFatherV(studentss);

        StudentGrades studentGrades1 = new StudentGrades(5,studentss);
        StudentGrades studentGrades2 = new StudentGrades(10,studentss);
        StudentGrades studentGrades3 = new StudentGrades(9,studentss);

        StudentGrades studentsGradesArray[] = new StudentGrades[]{studentGrades1,studentGrades2,studentGrades3};

        ///sortam alfabetic studentii
        catalogService.sortStudentsAlphabetically(studentss);

        System.out.println("\n **Add**");
        ///adaugam un student in lista de studenti care au obtinut nota respectiva
        catalogService.AddStudentAtNote(student4,studentGrades1);

        System.out.println("\n **Remove**");
        ///Stergem ultimul student din lista de studenti care a obtinut nota respectiva
        catalogService.removeStudent(studentGrades1);


        ///stergem toti studentii care au obtinut nota respectiva
        catalogService.removeAllStudent(studentGrades3);

        ///

    }
}
