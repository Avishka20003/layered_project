module lk.ijse.layered_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens lk.ijse.layered_project to javafx.fxml;
    opens lk.ijse.layered_project.controller to javafx.graphics;
    opens lk.ijse.layered_project.view to javafx.fxml;

    exports lk.ijse.layered_project;
    exports lk.ijse.layered_project.controller;
}