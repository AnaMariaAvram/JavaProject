package Catalog;

public class StudentTaxa extends Student{
    public Integer TipResidence;
    //1-Camin
    //2-Chirie
    //3-Acasa
    StudentTaxa()
    {
        TipResidence = 0;
    }
    public StudentTaxa(String StudentLastName, String StudentFirstName, char StudentFatherInitial, Integer StudentAge, Integer TipResidance)
    {
        super(StudentLastName,StudentFirstName,StudentFatherInitial,StudentAge);
        this.TipResidence = TipResidance;
    }
    public Integer getTipResidence()
    {
        return TipResidence;
    }

    public void setTipResidence(Integer TipResidence)
    {
        TipResidence = TipResidence;
    }
    @Override
    public String toString()
    {
        if(TipResidence == 3)
        return StudentLastName + " " + StudentFatherInitial + ". " + StudentFirstName + " have " + StudentAge + " years old and lives at home. " ;
        else if(TipResidence == 2)
            return StudentLastName + " " + StudentFatherInitial + ". " + StudentFirstName + " have " + StudentAge + " years old and lives in rent. " ;
        else  return StudentLastName + " " + StudentFatherInitial + ". " + StudentFirstName + " have " + StudentAge + " years old and lives in the dormitory. " ;


    }
}
