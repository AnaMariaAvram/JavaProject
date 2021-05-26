package Catalog.Repository;
import java.sql.*;

import Catalog.AuditService;
import Catalog.config.DatabaseConfiguration;

public class SubjectDatabaseServices {

    public void dropTable() {
        String createTableSql = "DROP TABLE SUBJECTS";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            System.out.println("Table Subjects dropped");
        } catch (SQLException e) {
            System.out.println("You cannot drop the Subject table!");
        }
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("Table SUBJECTS dropped");
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS subjects(id_subject int PRIMARY KEY AUTO_INCREMENT, " +
                "names varchar(30),id_professor int,"+
                "foreign key(id_professor) references professors(id_professor))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table SUBJECTS created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(" ** Table SUBJECT **");
    }
    public void insertSubject(String names, int id_professor) {
        String insertPersonSql = "INSERT INTO subjects (names,id_professor) VALUES(?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, names);
            preparedStatement.setInt(2, id_professor);

            preparedStatement.executeUpdate();
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row inserted in SUBJECTS ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubject(String names,int id_professor,int id_subject) {
        String updateNameSql = "UPDATE subjects SET names=?, id_professor=? WHERE id_professor=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, names);
            preparedStatement.setInt(2, id_professor);
            preparedStatement.setInt(3, id_subject);

            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row updated in SUBJECTS ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displaySubject(int id_professor) {
        String selectSql = "SELECT id_subject,names, P.name\n" +
                "FROM  subjects S, professors P\n" +
                "WHERE S.id_professor = P.id_professor\n" +
                "AND id_subject= ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id_professor);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                System.out.println("##################");
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Professor : " + resultSet.getString(3));
                System.out.println("##################\n");
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Subject displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void displayAllSubjects() {
        String selectSql =
                "SELECT id_subject,names, P.name\n" +
                        "FROM  subjects S, professors P\n" +
                        "WHERE S.id_professor = P.id_professor";
        String output = "";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        ProfessorDatabaseServices professorDatabaseServices = new ProfessorDatabaseServices();

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {


                output += "Id: " + resultSet.getString(1) + "\n";
                output += "Name: " + resultSet.getString(2)+"\n";
                output += "Professor: " + resultSet.getString(3) +"\n";
                output += "##################\n";
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("All subjects displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(output);
    }

}
