package Catalog;

public class StudentBudget extends Student  {
    public Integer TipBursa;
    ///1 are bursa de merit
    ///2 nu are bursa de merit
    StudentBudget()
    {
        TipBursa = 0;
    }
    public StudentBudget(String StudentLastName, String StudentFirstName, char StudentFatherInitial, Integer StudentAge, Integer TipBursa)
    {
        super(StudentLastName,StudentFirstName,StudentFatherInitial,StudentAge);
        this.TipBursa = TipBursa;
    }
    public Integer getTipBursa()
    {
        return TipBursa;
    }

    public void setTipBursa(Integer TipBursa)
    {
        TipBursa = TipBursa;
    }
    @Override
    public String toString()
    {
        if(TipBursa==1)
            return StudentLastName + " " + StudentFatherInitial + ". " + StudentFirstName + " have " + StudentAge + " years old and has a scholarship. ";
        else   return StudentLastName + " " + StudentFatherInitial + ". " + StudentFirstName + " have " + StudentAge + " years old and has no a merit scholarship. ";

    }
}
