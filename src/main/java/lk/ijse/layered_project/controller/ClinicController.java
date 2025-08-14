package lk.ijse.layered_project.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import lk.ijse.layered_project.bo.BOFactory;
import lk.ijse.layered_project.bo.custom.ClinicBO;
import lk.ijse.layered_project.dto.ClinicDto;
import lk.ijse.layered_project.view.ClincTm;


import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClinicController implements Initializable {
    public Label Label;
    public TextField txtName;
    public TextField txtLocation;
    public TextField txtPhoneNumber;
    public TextArea txtDescription;

    public TableView<ClincTm> TableView;
    public TableColumn<ClincTm, Integer> colClinicId;
    public TableColumn<ClincTm, String> colName;
    public TableColumn<ClincTm, String> colLocation;
    public TableColumn<ClincTm, String> colPhoneNumber;
    public TableColumn<ClincTm, String> colStatus;
    public TableColumn<ClincTm, String> colAction;

    public Button btnAddClinic;
    public Button btnUpdateClinic;


   // private ClinicModel clinicModel = new ClinicModel();
    ClinicBO clinicModel = (ClinicBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CLINIC);

    public void btnChildAddOnAction(ActionEvent actionEvent) {
        final String phoneRegex = "^\\+?\\d{10,15}$";

        String Name = txtName.getText();
        String Location = colLocation.getText();
        String PhoneNumber = txtPhoneNumber.getText();
        String Description = txtDescription.getText();

        boolean isPhone = PhoneNumber.matches(phoneRegex);

        if(Name.isEmpty() || Location.isEmpty() || PhoneNumber.isEmpty() || Description.isEmpty() || !isPhone) {
            new Alert(Alert.AlertType.ERROR,"Please fill all the fields",ButtonType.OK).show();
            return;
        }


        ClinicDto clinicDto = new ClinicDto(Name, Location, PhoneNumber, Description);
        try {
            boolean isInsert = clinicModel.saveClinic(clinicDto);
            if (isInsert) {
                reset();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully added Clinic");
                alert.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to add Clinic");
                alert.show();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.show();
            e.printStackTrace();
        }
    }


    public void tableClinicOnClick(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colClinicId.setCellValueFactory(new PropertyValueFactory<>("clinic_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("clinic_name"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("action"));

        reset();


    }

    public void loadTableData() throws SQLException, ClassNotFoundException {
        TableView.setItems(FXCollections.observableArrayList(
                clinicModel.getAllClinic().stream()
                        .map(customerDTO -> {
                            // Create Edit button with ✏️ emoji
                            Button editButton = new Button("\uD83D\uDD8B");
                            editButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");


                            // Create Delete button with 🗑️ emoji
                            Button deleteButton = new Button("\uD83D\uDDD1");
                            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

                            // Add actions
                            editButton.setOnAction(e -> {
                                editClinicDataLoader(customerDTO);
                                System.out.println("Edit clicked for: " + customerDTO.getClinic_id());
                            });

                            deleteButton.setOnAction(e -> {
                                deleteClinic(Integer.toString(customerDTO.getClinic_id()));
                                System.out.println("Delete clicked for: " + customerDTO.getClinic_id());
                            });

                            // Create HBox with buttons
                            HBox actionBox = new HBox(10, editButton, deleteButton);
                            actionBox.setAlignment(Pos.CENTER);

                            return new ClincTm(
                                    customerDTO.getClinic_id(),
                                    customerDTO.getClinic_name(),
                                    customerDTO.getClinic_location(),
                                    customerDTO.getContact(),
                                    customerDTO.getStatus(),
                                    actionBox
                            );
                        }).toList()
        ));

    }

    public void reset() {
        txtName.clear();
        txtLocation.clear();
        txtDescription.clear();
        txtPhoneNumber.clear();
        btnAddClinic.setDisable(false);
        btnUpdateClinic.setDisable(true);
        try {
            loadTableData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteClinic(String clinicId) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Clinic");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete Clinic?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                boolean isDeleted = clinicModel.deleteClinic(Integer.parseInt(clinicId));
                if (isDeleted) {
                    reset();
                    new Alert(Alert.AlertType.INFORMATION, "Customer deleted successfully.").show();

                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to delete customer.").show();
                }

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

            }

        }
    }
    public void editClinicDataLoader(ClinicDto clinicDto) {
        Label.setText(Integer.toString(clinicDto.getClinic_id()));
       txtName.setText(clinicDto.getClinic_name());
       txtLocation.setText(clinicDto.getClinic_location());
       txtPhoneNumber.setText(clinicDto.getContact());
       txtDescription.setText(clinicDto.getStatus());

        btnAddClinic.setDisable(true);
        btnUpdateClinic.setDisable(false);
    }

    public void btnClinicUpdateOnAction(ActionEvent actionEvent) {
       int clinicId = Integer.parseInt(Label.getText());
       String clinicName = txtName.getText();
       String clinicLocation = txtLocation.getText();
       String contact = txtPhoneNumber.getText();
       String description = txtDescription.getText();


        ClinicDto clinicDto = new ClinicDto(
                clinicId,
                clinicName,
                clinicLocation,
                description,
                contact,
                null
        );

        try{
            boolean isUpdated = clinicModel.updateClinic(clinicDto);
            if (isUpdated) {
                reset();
                new Alert(Alert.AlertType.INFORMATION, "Customer updated successfully.").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Fail to update customer.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
