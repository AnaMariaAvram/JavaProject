package Catalog.Repository;

import Catalog.AuditService;
import Catalog.config.DatabaseConfiguration;

import java.sql.*;

public class ClassDatabaseService {
    public void dropTable() {

        String createTableSql = "DROP TABLE classes";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            System.out.println("Table classes dropped");

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table classes dropped");

        } catch (SQLException e) {
            System.out.println("You cannot drop the classes table!");
        }


    }
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS classes" +
                "(id_class int PRIMARY KEY AUTO_INCREMENT, nr_class varchar(30) )";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( " **** TABLE CLASSES **** ");
    }

    public void insertClass(String nr_class) {
        String insertPersonSql = "INSERT INTO classes(nr_class)  VALUES(?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(insertPersonSql);
            prepareStatement.setString(1, nr_class);

            prepareStatement.executeUpdate();
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row inserted in classes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteClass( int id_professor){
        String deleteSql = "DELETE FROM classes WHERE id_class =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id_professor);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row deleted in classes ");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateClass(String nr_class,int id_class) {
        String updateNameSql = "UPDATE classes SET nr_class =? WHERE id_class=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, nr_class);
            preparedStatement.setInt(2, id_class);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row updated in classes ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayClass(int id_class) {
        String selectSql = "SELECT * FROM classes WHERE id_class=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id_class);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("################");
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("NrClass:" + resultSet.getString(2));
                System.out.println("################\n");
            }
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Classes displayed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayAllClasses() {
        String selectSql = "SELECT * FROM classes";
        String output = "";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                output += "Id: " + resultSet.getString(1) + "\n";
                output += "NrClass: " + resultSet.getString(2) + "\n";
                output += "#############\n";
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("All classes displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(output);
    }
}
