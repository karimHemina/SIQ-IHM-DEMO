package com.karim.employees;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeController {
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
    public void createEmployee(ActionEvent actionEvent) {
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
}
