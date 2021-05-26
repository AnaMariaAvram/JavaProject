package Catalog;
import Catalog.Exceptions.FileReadingException;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromCSVFile {
    /**
     * #### O data cu citirea informatiei din fisier, creeam o lista pentru fiecare coloana din fisier
     * urmand ca informatia sa fie intoarsa sub forma unei liste de liste ####
     */
   public static ArrayList<ArrayList<String>> readFromStudentFile(String file_path) throws FileReadingException {

       ArrayList<String> studentLastNameList = new ArrayList<String>();
       ArrayList<String> studentFirstNameList= new ArrayList<String>();
       ArrayList<String> studentFatherInitialList = new ArrayList<String>();
       ArrayList<String> studentAgeList = new ArrayList<String>();
       ArrayList<ArrayList<String>> students = new ArrayList<ArrayList<String>>();
       String line = "";
       try {
           file_path = "src/Catalog/CVS_files/" + file_path;
           BufferedReader buffer = new BufferedReader(new FileReader(file_path));

           while ((line = buffer.readLine()) != null) {
               String[] column = line.split(",");

               studentLastNameList.add(column[0]);
               studentFirstNameList.add(column[1]);
               studentFatherInitialList.add(column[2]);
               studentAgeList.add(column[3]);
           }
       } catch (FileNotFoundException e) {
        throw new FileReadingException("Something went wrong in readFromStudentFile method", e);
       } catch (IOException e) {
           e.printStackTrace();
       }
       studentFirstNameList.remove(0);
       studentLastNameList.remove(0);
       studentFatherInitialList.remove(0);
       studentAgeList.remove(0);
       students.add(studentLastNameList);
       students.add(studentFirstNameList);
       students.add(studentFatherInitialList);
       students.add(studentAgeList);
       return students;
   }
    public static ArrayList<ArrayList<String>> readFromProfessorFile(String file_path) throws FileReadingException
    {
        ArrayList<String> professorLastNameList = new ArrayList<String>();
        ArrayList<String> professorFirstNameList = new ArrayList<String>();
        ArrayList<String> professorAgeList = new ArrayList<String>();
        ArrayList<String> professorSalaryList = new ArrayList<String>();
        ArrayList<ArrayList<String> > teachers = new ArrayList<ArrayList<String> >();

        String line = "";
        try {
            file_path = "src/Catalog/CVS_files/" + file_path;
            BufferedReader buffer = new BufferedReader(new FileReader(file_path));

            while ((line = buffer.readLine()) != null) {
                String[] column = line.split(",");

                professorLastNameList.add(column[0]);
                professorFirstNameList.add(column[1]);
                professorAgeList.add(column[2]);
                professorSalaryList.add(column[3]);
            }
        }catch (FileNotFoundException e)
            {throw new FileReadingException("Something went wrong in readFromProfessorFile method", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        professorLastNameList.remove(0);
        professorFirstNameList.remove(0);
        professorSalaryList.remove(0);
        professorAgeList.remove(0);
        teachers.add(professorLastNameList);
        teachers.add(professorFirstNameList);
        teachers.add(professorSalaryList);
        teachers.add(professorAgeList);
        return teachers;
    }
    public static ArrayList<ArrayList<String>> readFromStudentBudgetFile(String file_path) throws FileReadingException
    {
        ArrayList<String> studentLastNameList = new ArrayList<String>();
        ArrayList<String> studentFirstNameList= new ArrayList<String>();
        ArrayList<String> studentFatherInitialList = new ArrayList<String>();
        ArrayList<String> studentAgeList = new ArrayList<String>();
        ArrayList<String> studentTipBursaList = new ArrayList<String>();
        ArrayList<ArrayList<String>> students = new ArrayList<ArrayList<String>>();
        String line = "";
        try {
            file_path = "src/Catalog/CVS_files/"  + file_path;
            BufferedReader buffer = new BufferedReader(new FileReader(file_path));

            while ((line = buffer.readLine()) != null) {
                String[] column = line.split(",");

                studentLastNameList.add(column[0]);
                studentFirstNameList.add(column[1]);
                studentFatherInitialList.add(column[2]);
                studentAgeList.add(column[3]);
                studentTipBursaList.add(column[4]);
            }
        } catch (FileNotFoundException e) {
            throw new FileReadingException("Something went wrong in readFromStudentFile method", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        studentFirstNameList.remove(0);
        studentLastNameList.remove(0);
        studentFatherInitialList.remove(0);
        studentAgeList.remove(0);
        studentTipBursaList.remove(0);

        students.add(studentLastNameList);
        students.add(studentFirstNameList);
        students.add(studentFatherInitialList);
        students.add(studentAgeList);
        students.add(studentTipBursaList);

        return students;
    }
    public static ArrayList<ArrayList<String>> readFromStudentTaxaFile(String file_path) throws FileReadingException
    {
        ArrayList<String> studentLastNameList = new ArrayList<String>();
        ArrayList<String> studentFirstNameList= new ArrayList<String>();
        ArrayList<String> studentFatherInitialList = new ArrayList<String>();
        ArrayList<String> studentAgeList = new ArrayList<String>();
        ArrayList<String> studentTipResidanceList = new ArrayList<String>();
        ArrayList<ArrayList<String>> students = new ArrayList<ArrayList<String>>();
        String line = "";
        try {
            file_path =  "src/Catalog/CVS_files/" + file_path;
            BufferedReader buffer = new BufferedReader(new FileReader(file_path));

            while ((line = buffer.readLine()) != null) {
                String[] column = line.split(",");

                studentLastNameList.add(column[0]);
                studentFirstNameList.add(column[1]);
                studentFatherInitialList.add(column[2]);
                studentAgeList.add(column[3]);
                studentTipResidanceList.add(column[4]);
            }
        } catch (FileNotFoundException e) {
            throw new FileReadingException("Something went wrong in readFromStudentTaxaFile method", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        studentFirstNameList.remove(0);
        studentLastNameList.remove(0);
        studentFatherInitialList.remove(0);
        studentAgeList.remove(0);
        studentTipResidanceList.remove(0);

        students.add(studentLastNameList);
        students.add(studentFirstNameList);
        students.add(studentFatherInitialList);
        students.add(studentAgeList);
        students.add(studentTipResidanceList);

        return students;
    }

}