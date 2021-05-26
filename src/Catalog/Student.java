package Catalog;

public class Student {
    //TODO: Name convention!! -> https://github.com/soaregeorgiana/pao-labs/blob/master/lab%202/lab2/src/ro/unibuc/lab/basics/Naming.java
    // # mi-am dat seama prea tarziu si am considerat ca nu are rost sa mai modific#

    protected String StudentLastName;
    protected String StudentFirstName;
    protected String StudentFatherInitial;
    protected int StudentAge;

    public Student()
    {
        this.StudentLastName = "";
        this.StudentFirstName = "";
        this.StudentFatherInitial = "";
        this.StudentAge = 0;
    }
    public Student(String StudentLastName,String StudentFirstName, String StudentFatherInitial,int StudentAge )
    {
        this.StudentLastName = StudentLastName;
        this.StudentFirstName = StudentFirstName;
        this.StudentFatherInitial = StudentFatherInitial;
        this.StudentAge = StudentAge;
    }

    public String getStudentLastName()
    {
        return  StudentLastName;
    }
    public String getStudentFirstName()
    {
        return StudentFirstName;
    }
    public String getStudentFatherInitial()
    {
        return  StudentFatherInitial;
    }
    public double getStudentAge()
    {
        return StudentAge;
    }

    public void setStudentLastName(String StudentLastName)
    {
        StudentLastName = StudentLastName;
    }
    public void setStudentFirstName(String StudentFirstName)
    {
        StudentFirstName = StudentFirstName;
    }
    public void setStudentFatherInitial(String StudentFatherInitial)
    {
        StudentFatherInitial = StudentFatherInitial;
    }

    public void setStudentAge(int StudentAge)
    {
        this.StudentAge = StudentAge;
    }
    @Override
    public String toString()
    {
        return StudentLastName + " " + StudentFatherInitial + ". " + StudentFirstName + " have " + StudentAge + " years old.";
    }
}

