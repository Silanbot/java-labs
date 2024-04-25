package edu.ntudp.fit.silakov.lab5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SQLManager {

    public String selectQuery(Scanner scanner){
        System.out.print("Enter the month, 0 for print all, 1-12 for print by month: ");
        try {
            int choice = scanner.nextInt();
            if (choice == 0) {
                return "SELECT * FROM students";
            } else if (choice >= 1 && choice <= 12) {
                return "SELECT * FROM students WHERE MONTH(birth_date) =" + choice + " ;";
            } else {
                return null;
            }
        } catch (InputMismatchException e){
            scanner.next();
            return selectQuery(scanner);
        }
    }


    public void printResultSet(Connection connection, String readyQuery) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(readyQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.printf("%-3s %-13s %-13s %-13s %-13s %-13s %-13s%n",
                "ID", "Last name", "First name", "Middle name", "Birth date", "Student id", "Gradebook id"
        );
        while (resultSet.next()) {
            System.out.printf("%-3s %-13s %-13s %-13s %-13s %-13s %-13s%n",
                    resultSet.getInt("id"),
                    resultSet.getString("last_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("middle_name"),
                    resultSet.getDate("birth_date"),
                    resultSet.getString("student_id"),
                    resultSet.getString("gradebook_id")
            );
        }
    }

}