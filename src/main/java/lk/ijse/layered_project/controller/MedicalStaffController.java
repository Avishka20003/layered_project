package lk.ijse.layered_project.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import lk.ijse.layered_project.bo.BOFactory;
import lk.ijse.layered_project.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.layered_project.dto.EmployeeDto;
import lk.ijse.layered_project.view.EmployeeTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class MedicalStaffController implements Initializable {

    public Text txtDoctorId;
    public TextField txtDoctorName;
    public TextField txtDoctorAddress;
    public TextField txtDoctorContactNumber;
    public TextField txtDoctorSpecialise;
    public Button btnDoctorRefashId;
    public Button btnDoctorAddId;
    public Button btnDoctorUpdateId;

    public TableView<EmployeeTm> tableDoctor;
    public TableColumn<EmployeeTm, Integer> colDoctorId;
    public TableColumn<EmployeeTm, String> colDoctorName;
    public TableColumn<EmployeeTm, String> colDoctorAddress;
    public TableColumn<EmployeeTm, String> colDoctorContactNumber;
    public TableColumn<EmployeeTm, String> colDoctorSpecialise;
    public TableColumn<EmployeeTm, String> colDoctorAction;

    public Text txtMidwifeId;
    public TextField txtMidwifeName;
    public TextField txtMidwifeAddress;
    public TextField txtMidwifeContactNumber;
    public Button btnMidwifeRefashId;
    public Button btnMidwifeAdd;
    public Button btnMidwifeUpdate;

    public TableView<EmployeeTm> tableMidwife;
    public TableColumn<EmployeeTm, Integer> colMidwifeId;
    public TableColumn<EmployeeTm, String> colMidwifeName;
    public TableColumn<EmployeeTm, String> colMidwifeAddress;
    public TableColumn<EmployeeTm, String> colMidwifeContactNumber;
    public TableColumn<EmployeeTm, String> colMidwifeAction;

    public Text txtCashierId;
    public TextField txtCashierName;
    public TextField txtCashierAddress;
    public TextField txtCashierContactNumber;
    public Button txtCashierRefash;
    public Button txtCashierAdd;
    public Button txtCashierUpdate;

    public TableView<EmployeeTm> tableCashier;
    public TableColumn<EmployeeTm, Integer> colCashierId;
    public TableColumn<EmployeeTm, String> colCashierName;
    public TableColumn<EmployeeTm, String> colCashierAddress;
    public TableColumn<EmployeeTm, String> colCashierContactNumber;
    public TableColumn<EmployeeTm, String> colCashierAction;

//    private EmployeeModel employeeModel = new EmployeeModel();
    private EmployeeBOImpl employeeBO = (EmployeeBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colDoctorId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colDoctorName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDoctorAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDoctorContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colDoctorSpecialise.setCellValueFactory(new PropertyValueFactory<>("specialist"));
        colDoctorAction.setCellValueFactory(new PropertyValueFactory<>("action"));

        colMidwifeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colMidwifeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMidwifeAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colMidwifeContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colMidwifeAction.setCellValueFactory(new PropertyValueFactory<>("action"));

        colCashierId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colCashierName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCashierAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCashierContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colCashierAction.setCellValueFactory(new PropertyValueFactory<>("action"));


        refreshPage();
    }

    public void btnDoctorAddOnAction(ActionEvent event) {
        String doctorName = txtDoctorName.getText();
        String doctorAddress = txtDoctorAddress.getText();
        String doctorContact = txtDoctorContactNumber.getText();
        String doctorSpecialise = txtDoctorSpecialise.getText();

        if (doctorName.isEmpty() || doctorAddress.isEmpty() || doctorContact.isEmpty() || doctorSpecialise.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields").show();
            return;
        }

        EmployeeDto doctorDto = new EmployeeDto(
                doctorName,
                doctorContact,
                doctorAddress,
                "Doctor",
                doctorSpecialise,
                "Active",
                "123456"
        );

        try {
            boolean insert = employeeBO.addEmployee(doctorDto);
            if (insert) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Doctor Added Successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Add Doctor").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Doctor: " + e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void btnDoctorUpdateOnAction(ActionEvent event) {
        int doctorId = Integer.parseInt(txtDoctorId.getText());
        String doctorName = txtDoctorName.getText();
        String doctorAddress = txtDoctorAddress.getText();
        String doctorContact = txtDoctorContactNumber.getText();
        String doctorSpecialise = txtDoctorSpecialise.getText();

        if (doctorName.isEmpty() || doctorAddress.isEmpty() || doctorContact.isEmpty() || doctorSpecialise.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields").show();
            return;
        }

        EmployeeDto doctorDto = new EmployeeDto(
                doctorId,
                doctorName,
                doctorContact,
                doctorAddress,
                "Doctor",
                doctorSpecialise,
                "Active",
                null
        );

        try {
            boolean isUpdated = employeeBO.updateEmployee(doctorDto);
            if (isUpdated) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Doctor updated successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update doctor").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    public void btnDoctorRefashOnAction(ActionEvent event) {
        refreshDoctor();
        btnDoctorAddId.setDisable(false);
        btnDoctorUpdateId.setDisable(true);
    }

    public void btnMidwifeAddOnAction(ActionEvent event) {
        String midwifeName = txtMidwifeName.getText();
        String midwifeAddress = txtMidwifeAddress.getText();
        String midwifeContact = txtMidwifeContactNumber.getText();

        if (midwifeName.isEmpty() || midwifeAddress.isEmpty() || midwifeContact.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields").show();
            return;
        }

        EmployeeDto midwifeDto = new EmployeeDto(
                midwifeName,
                midwifeContact,
                midwifeAddress,
                "Midwife",
                null,
                null,
                "123456"
        );

        try {
            boolean insert = employeeBO.addEmployee(midwifeDto);
            if (insert) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Midwife Added Successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Add Midwife").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Midwife: " + e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void btnMidwifeUpdateOnAction(ActionEvent event) {
        int midwifeId = Integer.parseInt(txtMidwifeId.getText());
        String midwifeName = txtMidwifeName.getText();
        String midwifeAddress = txtMidwifeAddress.getText();
        String midwifeContact = txtMidwifeContactNumber.getText();

        if (midwifeName.isEmpty() || midwifeAddress.isEmpty() || midwifeContact.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields").show();
            return;
        }

        EmployeeDto midwifeDto = new EmployeeDto(
                midwifeId,
                midwifeName,
                midwifeContact,
                midwifeAddress,
                "Midwife",
                null,
                null,
                null
        );

        try {
            boolean isUpdated = employeeBO.updateEmployee(midwifeDto);
            if (isUpdated) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Midwife updated successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update midwife").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    public void btnMidwifeRefashOnAction(ActionEvent event) {
        refreshMidwife();
        btnMidwifeAdd.setDisable(false);
        btnMidwifeUpdate.setDisable(true);
    }

    public void btnCashierAddOnAction(ActionEvent event) {
        String cashierName = txtCashierName.getText();
        String cashierAddress = txtCashierAddress.getText();
        String cashierContact = txtCashierContactNumber.getText();

        if (cashierName.isEmpty() || cashierAddress.isEmpty() || cashierContact.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields").show();
            return;
        }

        EmployeeDto cashierDto = new EmployeeDto(
                cashierName,
                cashierContact,
                cashierAddress,
                "Cashier",
                null,
                null,
                "123456"
        );

        try {
            boolean insert = employeeBO.addEmployee(cashierDto);
            if (insert) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Cashier Added Successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Add Cashier").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Cashier: " + e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void btnCashierUpdateOnAction(ActionEvent event) {
        int cashierId = Integer.parseInt(txtCashierId.getText());
        String cashierName = txtCashierName.getText();
        String cashierAddress = txtCashierAddress.getText();
        String cashierContact = txtCashierContactNumber.getText();

        if (cashierName.isEmpty() || cashierAddress.isEmpty() || cashierContact.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields").show();
            return;
        }

        EmployeeDto cashierDto = new EmployeeDto(
                cashierId,
                cashierName,
                cashierContact,
                cashierAddress,
                "Cashier",
                null,
                null,
                null
        );

        try {
            boolean isUpdated = employeeBO.updateEmployee(cashierDto);
            if (isUpdated) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Cashier updated successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update cashier").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    public void btnCashierRefashOnAction(ActionEvent event) {
        refreshCashier();
        txtCashierAdd.setDisable(false);
        txtCashierUpdate.setDisable(true);
    }

    public void loadDoctorTableData() throws SQLException, ClassNotFoundException {
//        tableDoctor.setItems(FXCollections.observableArrayList(
//                employeeBO.getAllDoctors().stream()
//                        .map(dto -> {
//                            // Create Edit button with ✏️ emoji
//                            Button updateButton = new Button("\uD83D\uDD8B");
//                            updateButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
//
//
//                            // Create Delete button with 🗑️ emoji
//                            Button deleteButton = new Button("\uD83D\uDDD1");
//                            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
//
//                            updateButton.setOnAction(e -> {
//                                editDoctorDataLoader(dto);
//                            });
//
//                            deleteButton.setOnAction(e -> {
//                                deleteEmployee(dto.getEmployeeId(), "Doctor");
//                            });
//
//                            HBox actionBox = new HBox(5, updateButton, deleteButton);
//                            actionBox.setAlignment(Pos.CENTER);
//
//                            return new EmployeeTm(
//                                    dto.getEmployeeId(),
//                                    dto.getName(),
//                                    dto.getContactNumber(),
//                                    dto.getAddress(),
//                                    dto.getRole(),
//                                    dto.getSpecialist(),
//                                    dto.getStatus(),
//                                    actionBox
//                            );
//                        }).toList()
//        ));
    }

    public void loadMidwifeTableData() throws SQLException, ClassNotFoundException {
//        tableMidwife.setItems(FXCollections.observableArrayList(
//                employeeModel.getAllMidwives().stream()
//                        .map(dto -> {
//                            // Create Edit button with ✏️ emoji
//                            Button updateButton = new Button("\uD83D\uDD8B");
//                            updateButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
//
//
//                            // Create Delete button with 🗑️ emoji
//                            Button deleteButton = new Button("\uD83D\uDDD1");
//                            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
//
//
//                            updateButton.setOnAction(e -> {
//                                editMidwifeDataLoader(dto);
//                            });
//
//                            deleteButton.setOnAction(e -> {
//                                deleteEmployee(dto.getEmployeeId(), "Midwife");
//                            });
//
//                            HBox actionBox = new HBox(5, updateButton, deleteButton);
//                            actionBox.setAlignment(Pos.CENTER);
//
//                            return new EmployeeTm(
//                                    dto.getEmployeeId(),
//                                    dto.getName(),
//                                    dto.getContactNumber(),
//                                    dto.getAddress(),
//                                    dto.getRole(),
//                                    dto.getSpecialist(),
//                                    dto.getStatus(),
//                                    actionBox
//                            );
//                        }).toList()
//        ));
    }

    public void loadCashierTableData() throws SQLException, ClassNotFoundException {
//        tableCashier.setItems(FXCollections.observableArrayList(
//                employeeModel.getAllCashiers().stream()
//                        .map(dto -> {
//                            // Create Edit button with ✏️ emoji
//                            Button updateButton= new Button("\uD83D\uDD8B");
//                          updateButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
//
//
//                            // Create Delete button with 🗑️ emoji
//                            Button deleteButton = new Button("\uD83D\uDDD1");
//                            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
//
//
//                            updateButton.setOnAction(e -> {
//                                editCashierDataLoader(dto);
//                            });
//
//                            deleteButton.setOnAction(e -> {
//                                deleteEmployee(dto.getEmployeeId(), "Cashier");
//                            });
//
//                            HBox actionBox = new HBox(5, updateButton, deleteButton);
//                            actionBox.setAlignment(Pos.CENTER);
//
//                            return new EmployeeTm(
//                                    dto.getEmployeeId(),
//                                    dto.getName(),
//                                    dto.getContactNumber(),
//                                    dto.getAddress(),
//                                    dto.getRole(),
//                                    dto.getSpecialist(),
//                                    dto.getStatus(),
//                                    actionBox
//                            );
//                        }).toList()
//        ));
    }

    public void editDoctorDataLoader(EmployeeDto employeeDto) {
        txtDoctorId.setText(Integer.toString(employeeDto.getEmployeeId()));
        txtDoctorName.setText(employeeDto.getName());
        txtDoctorAddress.setText(employeeDto.getAddress());
        txtDoctorContactNumber.setText(employeeDto.getContactNumber());
        txtDoctorSpecialise.setText(employeeDto.getSpecialist());

        btnDoctorAddId.setDisable(true);
        btnDoctorUpdateId.setDisable(false);
    }

    public void editMidwifeDataLoader(EmployeeDto employeeDto) {
        txtMidwifeId.setText(Integer.toString(employeeDto.getEmployeeId()));
        txtMidwifeName.setText(employeeDto.getName());
        txtMidwifeAddress.setText(employeeDto.getAddress());
        txtMidwifeContactNumber.setText(employeeDto.getContactNumber());

        btnMidwifeAdd.setDisable(true);
        btnMidwifeUpdate.setDisable(false);
    }

    public void editCashierDataLoader(EmployeeDto employeeDto) {
        txtCashierId.setText(Integer.toString(employeeDto.getEmployeeId()));
        txtCashierName.setText(employeeDto.getName());
        txtCashierAddress.setText(employeeDto.getAddress());
        txtCashierContactNumber.setText(employeeDto.getContactNumber());

        txtCashierAdd.setDisable(true);
        txtCashierUpdate.setDisable(false);
    }

    public void deleteEmployee(int id, String employeeType) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete " + employeeType);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this " + employeeType + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                boolean isDeleted = employeeBO.deleteEmployee(id);
                if (isDeleted) {
                    refreshPage();
                    new Alert(Alert.AlertType.INFORMATION, employeeType + " deleted successfully").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to delete " + employeeType).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
            }
        }
    }

    public void refreshDoctor() {
        txtDoctorName.clear();
        txtDoctorAddress.clear();
        txtDoctorContactNumber.clear();
        txtDoctorSpecialise.clear();
        txtDoctorId.setText("");
    }

    public void refreshMidwife() {
        txtMidwifeName.clear();
        txtMidwifeAddress.clear();
        txtMidwifeContactNumber.clear();
        txtMidwifeId.setText("");
    }

    public void refreshCashier() {
        txtCashierName.clear();
        txtCashierAddress.clear();
        txtCashierContactNumber.clear();
        txtCashierId.setText("");
    }

    public void refreshPage() {
        refreshDoctor();
        refreshMidwife();
        refreshCashier();

        btnDoctorAddId.setDisable(false);
        btnDoctorUpdateId.setDisable(true);
        btnMidwifeAdd.setDisable(false);
        btnMidwifeUpdate.setDisable(true);
        txtCashierAdd.setDisable(false);
        txtCashierUpdate.setDisable(true);

        try {
            loadDoctorTableData();
            loadMidwifeTableData();
            loadCashierTableData();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error loading data: " + e.getMessage()).show();
        }
    }

    public void tableDoctorOnClicked(MouseEvent event) {
        EmployeeTm selectedDoctor = tableDoctor.getSelectionModel().getSelectedItem();
        if (selectedDoctor != null) {
            EmployeeDto dto = new EmployeeDto(
                    selectedDoctor.getEmployeeId(),
                    selectedDoctor.getName(),
                    selectedDoctor.getContactNumber(),
                    selectedDoctor.getAddress(),
                    selectedDoctor.getRole(),
                    selectedDoctor.getSpecialist(),
                    selectedDoctor.getStatus(),
                    null
            );
            editDoctorDataLoader(dto);
        }
    }

    public void tableMidwifeOnClicked(MouseEvent event) {
        EmployeeTm selectedMidwife = tableMidwife.getSelectionModel().getSelectedItem();
        if (selectedMidwife != null) {
            EmployeeDto dto = new EmployeeDto(
                    selectedMidwife.getEmployeeId(),
                    selectedMidwife.getName(),
                    selectedMidwife.getContactNumber(),
                    selectedMidwife.getAddress(),
                    selectedMidwife.getRole(),
                    selectedMidwife.getSpecialist(),
                    selectedMidwife.getStatus(),
                    null
            );
            editMidwifeDataLoader(dto);
        }
    }

    public void tableCashierOnClicked(MouseEvent event) {
        EmployeeTm selectedCashier = tableCashier.getSelectionModel().getSelectedItem();
        if (selectedCashier != null) {
            EmployeeDto dto = new EmployeeDto(
                    selectedCashier.getEmployeeId(),
                    selectedCashier.getName(),
                    selectedCashier.getContactNumber(),
                    selectedCashier.getAddress(),
                    selectedCashier.getRole(),
                    selectedCashier.getSpecialist(),
                    selectedCashier.getStatus(),
                    null
            );
            editCashierDataLoader(dto);
        }
    }
}