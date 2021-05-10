package Catalog;
import java.util.ArrayList;

public class StudentGrades {
    private Integer SNote;
    /// protected  Student[] studentwithSNote;
    private ArrayList<Student> studentwithSNote;

    StudentGrades()
    {
        SNote = 0;
        studentwithSNote = null;
    }
    public StudentGrades(Integer SNote, ArrayList<Student> grades)
    {
        this.SNote = SNote;
        this.studentwithSNote = grades;
    }

    public Integer getSNote()
    {
        return  SNote;
    }

    public ArrayList<Student> getStudentwithSNote() {
        return studentwithSNote;
    }

    public void setStudentwithSNote(ArrayList<Student>  studentwithSNote) {
        this.studentwithSNote = studentwithSNote;
    }

    public void setSNote(Integer SNote)
    {
        this.SNote = SNote;
    }
    @Override
    public String toString()
    {
        return "Grades:" +SNote;
    }
}
