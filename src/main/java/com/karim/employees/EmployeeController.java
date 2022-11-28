package com.karim.employees;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
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
    private TableColumn<Employee, Integer> coldId;
    @FXML
    private TableColumn<Employee, String> colFirstName;
    @FXML
    private TableColumn<Employee, String> colLastName;
    @FXML
    private TableColumn<Employee, String> colPosition;

    int employeeId = 0;

    @FXML
    public void createEmployee(ActionEvent actionEvent) {
        EmployeeDB.persist(textFirstName.getText(), textLastName.getText(), textPosition.getText());
        showEmployees();
        clearFields();
    }

    @FXML
    public void editEmployee(ActionEvent actionEvent) {
        if(employeeId != 0){
            EmployeeDB.updateEmployee(employeeId, textFirstName.getText(), textLastName.getText(), textPosition.getText());
            showEmployees();
            employeeId = 0;
            clearFields();
        }
    }

    @FXML
    public void deleteEmployee(ActionEvent actionEvent) {
        if(employeeId != 0){
            EmployeeDB.deleteEmployee(employeeId);
            showEmployees();
            employeeId = 0;
            clearFields();
        }
    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {
        clearFields();
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

    @FXML
    public void getItem(MouseEvent mouseEvent) {
        Employee employee = tableEmployees.getSelectionModel().getSelectedItem();
        employeeId = employee.getId();
        textFirstName.setText(employee.getFirstName());
        textLastName.setText(employee.getLastName());
        textPosition.setText(employee.getPosition());
        btnSave.setDisable(true);
    }

    public void clearFields(){
        textFirstName.setText(null);
        textLastName.setText(null);
        textPosition.setText(null);
        btnSave.setDisable(true);
        employeeId = 0;
    }
}
