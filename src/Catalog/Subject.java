package Catalog;
enum SubjectList{
    ENGLISH,
    MATHEMATICS,
    GEOGRAPHY,
    MUSIC,
    CHEMISTRY,
    SPORT,
    HISTORY
}
public class Subject {
    private SubjectList SubjectName;
    private Professor ProfessorS;
    public Subject(SubjectList SubjectName, Professor ProfessorS)
    {
        this.SubjectName = SubjectName;
        this.ProfessorS = ProfessorS;
    }

    public SubjectList getSubjectName() {
        return SubjectName;
    }
    public Professor getProfessor()
    {
        return ProfessorS;
    }
    public void setSubjectName(SubjectList subjectName) {
        SubjectName = subjectName;
    }
    @Override
    public String toString()
    {
        return SubjectName + " is teached by " + ProfessorS.getProfessorLastName() + " " +ProfessorS.getProfessorLastName() + ".\n";
    }
}
