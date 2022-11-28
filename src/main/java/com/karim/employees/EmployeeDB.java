package com.karim.employees;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDB extends Employee {

    static Connection connection = Database.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static ObservableList<Employee> getEmployees(){
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        String query = "select * from employee";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String position = resultSet.getString("Position");
                Employee employee = new Employee(id, firstName, lastName, position);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public static void persist(String firstName, String lastName, String position){
        String query = "insert into employee(FirstName, LastName, Position) values(?, ?, ?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, position);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateEmployee(int id, String firstName, String lastName, String position){

        String query = "update employee set FirstName = ?, LastName = ?, Position = ? where id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, position);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteEmployee(int id){
        String query = "delete from employee where id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
