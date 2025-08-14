package lk.ijse.layered_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardLayoutController implements Initializable {

    public AnchorPane ancDashboardLayoutContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loader("/view/DashBoard.fxml");
    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) {
        loader("/view/DashBoard.fxml");
    }

    public void btnClinicOnAction(ActionEvent actionEvent) {
        loader("/view/clinic.fxml");
    }

    public void btnFamilyManageOnAction(ActionEvent actionEvent) {
        loader("/view/FamilyManage.fxml");
    }

    public void btnMedicalStaffOnAction(ActionEvent actionEvent) {
        loader( "/view/ MedicalStaff.fxml");

    }

    public void btnSessionOnAction(ActionEvent actionEvent) {
        loader("/view/Session.fxml");
    }

    public void btnReportOnAction(ActionEvent actionEvent) {
        loader("/view/Report.fxml");
    }

    public void loader(String path) {
        // Clear previous content
        ancDashboardLayoutContainer.getChildren().clear();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            AnchorPane pane = loader.load();

            // Remove any existing bindings (not strictly necessary for a new node, but safe)
            pane.prefWidthProperty().unbind();
            pane.prefHeightProperty().unbind();

            // Bind pane size to the container

            // Anchor to all sides (ensures full stretch in an AnchorPane)
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);


            ancDashboardLayoutContainer.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong while loading: " + path).show();
        } catch (NullPointerException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "FXML file not found at path: " + path).show();
        }
    }

    public void btnTestOnAction(ActionEvent actionEvent) {loader("/view/Test.fxml");
    }
}
