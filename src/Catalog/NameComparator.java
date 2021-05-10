package Catalog;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2)
    {
        int result =  student1.getStudentLastName().compareTo(student2.getStudentLastName());
        if(result == 0)
        {
            return student1.getStudentFirstName().compareTo(student2.getStudentFirstName());
        }
        else {
            return result;
        }

    }
}
