package Catalog.Repository;
import java.sql.*;

import Catalog.AuditService;
import Catalog.ReadFromCSVFile;
import Catalog.WriteToFile;

import Catalog.config.DatabaseConfiguration;

public class StudentDatabaseServices {

    public void dropTable() {

        String createTableSql = "DROP TABLE students";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            System.out.println("Table students dropped");

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table students dropped");

        } catch (SQLException e) {
            System.out.println("You cannot drop the students table!");
        }


    }
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS students" +
                "(id_student int PRIMARY KEY AUTO_INCREMENT, name varchar(30),surname varchar(30)," +
                "initial varchar(2),age int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( " **** TABLE STUDENTS **** ");
    }

    public void insertStudent(String name, String surname, String initial, int age) {
        String insertPersonSql = "INSERT INTO students(name,surname,initial,age)  VALUES(?,?,?,?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(insertPersonSql);
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, surname);
            prepareStatement.setString(3, initial);
            prepareStatement.setInt(4, age);
            prepareStatement.executeUpdate();
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row inserted in students");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent( int id_student){
        String deleteSql = "DELETE FROM students WHERE id_student =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id_student);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row deleted in students ");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateStudent(String name,String surname, String initial,int age,int id_student) {
        String updateNameSql = "UPDATE students SET name =?,surname=?,initial=?,age=? WHERE id_student=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, initial);
            preparedStatement.setInt(4, age);
            preparedStatement.setInt(5, id_student);

            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row updated in students ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayStudent(int id_student) {
        String selectSql = "SELECT * FROM students WHERE id_student=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id_student);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("################");
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Name:" + resultSet.getString(2));
                System.out.println("Surame:" + resultSet.getString(3));
                System.out.println("Initial:" + resultSet.getString(4));
                System.out.println("Age:" + resultSet.getString(5));
                System.out.println("################\n");
            }
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Student displayed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayAllStudents() {
        String selectSql = "SELECT * FROM students";
        String output = "";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                output += "Id: " + resultSet.getString(1) + "\n";
                output += "Name: " + resultSet.getString(2) + "\n";
                output += "Surame: " + resultSet.getString(3) + "\n";
                output += "Initial: " + resultSet.getString(4) + "\n";
                output += "Age: " + resultSet.getString(5) + "\n";
                output += "#######################\n";
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("All students displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(output);
    }

}