package edu.ntudp.fit.silakov.lab5;

import java.util.Scanner;
import java.sql.*;


public class Run {
    private static final String URL_SQL_JDBC_CONNECTION = "jdbc:mysql://localhost:3306/java_database";
    private static final String USER_SQL_JDBC_CONNECTION = "root";
    private static final String PASSWORD_SQL_JDBC_CONNECTION = "silakov";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                URL_SQL_JDBC_CONNECTION,
                USER_SQL_JDBC_CONNECTION,
                PASSWORD_SQL_JDBC_CONNECTION
        );
             Scanner scanner = new Scanner(System.in)
        ){
            SQLManager sqlManager = new SQLManager();

            String readyQuery = sqlManager.selectQuery(scanner);
            if (readyQuery == null) {
                System.out.println("Error");
                return;
            }
            sqlManager.printResultSet(connection,readyQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}