package Catalog;

public class ProfessorClass extends Professor {
    ///Fiecare profesor este diriginte la o clasa
    //IdClass este clasa la care profesorul este diriginte
    private String IdClass;


    public ProfessorClass(String ProfessorLastName, String PorfessorFirstName, Integer ProfessorAge, Integer ProfessorSalary, String idClass) {
        super(ProfessorLastName, PorfessorFirstName, ProfessorAge, ProfessorSalary);
        IdClass = idClass;
    }

    public String getIdClass() {
        return IdClass;
    }

    public void setIdClass(String idClass)
    {
        this.IdClass = idClass;
    }
    public String toString()
    {
        return "** Professor is a class teacher " + IdClass + ".**";
    }
}
