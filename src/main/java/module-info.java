module lk.ijse.layered_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lk.ijse.layered_project to javafx.fxml;
    exports lk.ijse.layered_project;
}