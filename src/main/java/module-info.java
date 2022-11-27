module com.karim.employees {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    opens com.karim.employees to javafx.fxml;
    exports com.karim.employees;
}