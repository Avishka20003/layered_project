module lk.ijse.layered_project {
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires com.jfoenix;
    requires javafx.controls;
    requires mysql.connector.j;


    opens lk.ijse.layered_project to javafx.fxml;
    exports lk.ijse.layered_project;
    opens lk.ijse.layered_project.controller to javafx.fxml;
    opens lk.ijse.layered_project.view to javafx.base;
}