package Catalog;

public class Professor {
    public    String ProfessorLastName;
    public    String PorfessorFirstName;
    public Integer ProfessorAge;
    public Integer ProfessorSalary;

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
