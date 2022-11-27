package com.karim.employees;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    @FXML
    private TextField textFirstName;

    @FXML
    private TextField textLastName;

    @FXML
    private TextField textPosition;

    @FXML
    private TableView<Employee> tableEmployees;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnClear;
    @FXML
    private TableColumn<Employee, Integer> coldId;
    @FXML
    private TableColumn<Employee, String> colFirstName;
    @FXML
    private TableColumn<Employee, String> colLastName;
    @FXML
    private TableColumn<Employee, String> colPosition;

    @FXML
    public void createEmployee(ActionEvent actionEvent) {
        EmployeeDB.persist(textFirstName.getText(), textLastName.getText(), textPosition.getText());
        showEmployees();
    }

    @FXML
    public void editEmployee(ActionEvent actionEvent) {
    }

    @FXML
    public void deleteEmployee(ActionEvent actionEvent) {
    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    public void showEmployees(){
        ObservableList<Employee> employeesList = EmployeeDB.getEmployees();
        tableEmployees.setItems(employeesList);
        coldId.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        colPosition.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showEmployees();
    }
}
