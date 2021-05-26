package Catalog.Repository;
import java.sql.*;

import Catalog.AuditService;
import Catalog.Student;
import Catalog.config.DatabaseConfiguration;
;

public class ProfessorDatabaseServices {
    public void dropTable() {

        String createTableSql = "DROP TABLE professors";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            System.out.println("Table professors dropped");

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table professors dropped");

        } catch (SQLException e) {
            System.out.println("You cannot drop the professors table!");
        }


    }
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS professors" +
                "(id_professor int PRIMARY KEY AUTO_INCREMENT, name varchar(30),surname varchar(30)," +
                "age int, salary int )";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( " **** TABLE PROFESSORS **** ");
    }

    public void insertProfessor(String name, String surname, int age, int salary) {
        String insertPersonSql = "INSERT INTO professors(name,surname,age,salary)  VALUES(?,?,?,?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(insertPersonSql);
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, surname);
            prepareStatement.setInt(3, age);
            prepareStatement.setInt(4, salary);
            prepareStatement.executeUpdate();
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row inserted in professors");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProfessor( int id_professor){
        String deleteSql = "DELETE FROM professors WHERE id_professor =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id_professor);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row deleted in professors ");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateProfessor(String name,String surname, int age, int salary,int id_professor) {
        String updateNameSql = "UPDATE professors SET name =?,surname=?,age=?,salary=? WHERE id_professor=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, salary);
            preparedStatement.setInt(5, id_professor);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row updated in professors ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayProfessor(int id_professor) {
        String selectSql = "SELECT * FROM professors WHERE id_professor=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id_professor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("################");
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Name:" + resultSet.getString(2));
                System.out.println("Surame:" + resultSet.getString(3));
                System.out.println("Age:" + resultSet.getString(4));
                System.out.println("Salary:" + resultSet.getString(5));
                System.out.println("################\n");
            }
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Professor displayed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayAllProfessors() {
        String selectSql = "SELECT * FROM professors";
        String output = "";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                output += "Id: " + resultSet.getString(1) + "\n";
                output += "Name: " + resultSet.getString(2) + "\n";
                output += "Surame: " + resultSet.getString(3) + "\n";
                output += "Age: " + resultSet.getString(4) + "\n";
                output += "Salary: " + resultSet.getString(5) + "\n";
                output += "#######################\n";
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("All professors displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(output);
    }
}
