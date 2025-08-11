module lk.ijse.layered_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens lk.ijse.layered_project to javafx.fxml;
    exports lk.ijse.layered_project;
}