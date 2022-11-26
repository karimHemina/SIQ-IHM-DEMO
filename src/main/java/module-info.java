module com.karim.employees {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.karim.employees to javafx.fxml;
    exports com.karim.employees;
}