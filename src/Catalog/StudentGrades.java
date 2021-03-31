package Catalog;

public class StudentGrades {
    public Integer SNote;
    protected  Student[] studentwithSNote;

    StudentGrades()
    {
        SNote = 0;
        studentwithSNote = null;
    }
    public StudentGrades(Integer SNote,Student[] grades)
    {
        this.SNote = SNote;
        this.studentwithSNote = grades;
    }
    public Integer getSNote()
    {
        return  SNote;
    }

    public Student[] getStudentwithSNote() {
        return studentwithSNote;
    }

    public void setStudentwithSNote(Student[] studentwithSNote) {
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
