package Catalog;

public class StudentBudget extends Student {
    protected Integer TipBursa;

    ///1 are bursa de merit
    ///2 nu are bursa de merit
    StudentBudget() {
        TipBursa = 0;
    }

    public StudentBudget(String StudentLastName, String StudentFirstName,String StudentFatherInitial, int StudentAge, Integer TipBursa) {
        super(StudentLastName, StudentFirstName, StudentFatherInitial, StudentAge);
        this.TipBursa = TipBursa;
    }

    public Integer getTipBursa() {
        return TipBursa;
    }

    public void setTipBursa(Integer TipBursa) {
        TipBursa = TipBursa;
    }

    @Override
    public String toString() {
        if (TipBursa == 1) {
            //TODO:se recomanda acolade si ptr o singura instructiune
            return StudentLastName + " " + StudentFatherInitial + ". " + StudentFirstName + " have " + StudentAge + " years old and has a scholarship. ";
        }
        else {
            return StudentLastName + " " + StudentFatherInitial + ". " + StudentFirstName + " have " + StudentAge + " years old and has no a merit scholarship. ";
        }

    }
}
