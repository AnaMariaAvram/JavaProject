package Catalog;

public class Professor {
    // TODO: Business logic related: de ce ai o proprietate pentru a stoca varsta si nimic legat de materia pe care o preda respectivul profesor
    //  #Am ales ca materia sa fie predata de o lista de profesori,iar noi sa verificam daca respectivul preda materia accesand lista#
    // Foloseste incapsularea -> atribute protected pentru ca aceasta clasa este parinte pentru ProfesorClass
    protected  String ProfessorLastName;
    protected  String PorfessorFirstName;
    protected  Integer ProfessorAge;
    protected  Integer ProfessorSalary;

    public Professor(String ProfessorLastName, String PorfessorFirstName, Integer ProfessorAge, Integer ProfessorSalary )
    {
        this.PorfessorFirstName = PorfessorFirstName;
        this.ProfessorLastName = ProfessorLastName;
        this.ProfessorAge = ProfessorAge;
        this.ProfessorSalary = ProfessorSalary;
    }


    public Integer getProfessorAge() {
        return ProfessorAge;
    }

    public Integer getProfessorSalary() {
        return ProfessorSalary;
    }

    public String getPorfessorFirstName() {
        return PorfessorFirstName;
    }

    public String getProfessorLastName() {
        return ProfessorLastName;
    }

    public void setPorfessorFirstName(String porfessorFirstName) {
        PorfessorFirstName = porfessorFirstName;
    }

    public void setProfessorAge(Integer professorAge) {
        ProfessorAge = professorAge;
    }

    public void setProfessorLastName(String professorLastName) {
        ProfessorLastName = professorLastName;
    }

    public void setProfessorSalary(Integer professorSalary) {
        ProfessorSalary = professorSalary;
    }
    @Override
    public String toString()
    {
        return PorfessorFirstName + " " + ProfessorLastName + " have " + ProfessorAge + " years old and her salary is " +ProfessorSalary +".";
    }
}
