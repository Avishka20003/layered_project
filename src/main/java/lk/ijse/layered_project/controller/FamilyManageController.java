package lk.ijse.layered_project.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import lk.ijse.layered_project.bo.BOFactory;
import lk.ijse.layered_project.bo.custom.*;
import lk.ijse.layered_project.dto.ChildDto;
import lk.ijse.layered_project.dto.FamilyDto;
import lk.ijse.layered_project.dto.FatherDto;
import lk.ijse.layered_project.dto.MotherDto;
import lk.ijse.layered_project.view.ChildTm;
import lk.ijse.layered_project.view.FatherTm;
import lk.ijse.layered_project.view.MotherTm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class FamilyManageController implements Initializable {

    public GridPane gridFamily;

    // Mother table section Start

    public Label lableId;

    public TextField txtMotherName;
    public TextField txtMotherAddress;
    public TextField txtMotherNic;
    public TextField txtMotherDob;
    public TextField txtMotherOccupation;
    public TextField txtMotherEmail;
    public TextField txtMotherPhoneNumber;
    public TextField txtMotherWeight;
    public TextField txtMotherHeight;
    public TextField txtMotherAllergies;
    public TextArea txtMotherMedicalHistory;
    public TextArea txtMotherNote;
    public ComboBox<String> cmbMotherBloodType;


    public Button btnAddMother;
    public Button btnUpdateMother;

    public TableView<MotherTm> tblMother;
    public TableColumn<MotherTm, Integer> colMotherId;
    public TableColumn<MotherTm, String> colMotherName;
    public TableColumn<MotherTm, String> colMotherAddress;
    public TableColumn<MotherTm, String> colMotherNic;
    public TableColumn<MotherTm, String> colMotherEmail;
    public TableColumn<MotherTm, String> colMotherPhoneNumber;
    public TableColumn<MotherTm, HBox> colMotherAction;

    // Mother table section End

    // Father table section Start

    public TextField txtFatherName;
    public TextField txtFatheraddress;
    public TextField txtFatherNic;
    public TextField txtFatherDob;
    public TextField txtFatherOccupation;
    public TextField txtFatherEmail;
    public TextField txtFatherPhoneNumber;


    public Button btnAddFather;
    public Button btnUpdateFather;

    public TableView<FatherTm> tableFather;
    public TableColumn<FatherTm, Integer> colFatherId;
    public TableColumn<FatherTm, String> colFatherName;
    public TableColumn<FatherTm, String> colFatherAddress;
    public TableColumn<FatherTm, String> colFatherNic;
    public TableColumn<FatherTm, String> colFatherEmail;
    public TableColumn<FatherTm, String> colFatherPhoneNumber;
    public TableColumn<FatherTm, String> colFatherAction;

// Father table section End


// Child table section Start


    public TextField txtChildFullName;
    public TextField txtChildAddress;
    public TextField txtChildBirthPlace;
    public TextField txtChildGender;
    public TextField txtChildDob;
    public TextField txtChildWeight;
    public TextField txtChildHeight;
    public TextField txtChildNote;
    public ComboBox cmbChildBloodType;

    public Button btnChildAdd;
    public Button btnUpdateChild;

    public TableView<ChildTm> tableChild;
    public TableColumn<ChildTm, Integer> colChildId;
    public TableColumn<ChildTm, String> colName;
    public TableColumn<ChildTm, String> colAddress;
    public TableColumn<ChildTm, String> colGender;
    public TableColumn<ChildTm, String> colDob;
    public TableColumn<ChildTm, String> colAction;
    public ComboBox cmbFatherBloodType;

    public ComboBox cmbFatherId;


    public Label lableFatherId;
    public HBox lableChildId;
    public Label txtChildId;


    // Child Section End

    MotherBO motherModel = (MotherBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MOTHER);
    FatherBO fatherModel = (FatherBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.FATHER);
    FamilyBO familyModel = (FamilyBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.FAMILY);
    ChildBO childModel = (ChildBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CHILD);

//    private MotherModel motherModel = new MotherModel();
//    private FatherModel fatherModel = new FatherModel();
//    private ChildModel childModel = new ChildModel();
//    private FamilyModel familyModel = new FamilyModel();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gridFamily.widthProperty().addListener((obs, oldVal, newVal) -> {
            loadFamilyCards(newVal.doubleValue());
        });

        initializeMotherTable();
        initializeFatherTable();
        initializeChildTable();

        motherReset();
    }

    private void loadFamilyCards(double gridWidth) {
        gridFamily.getChildren().clear();

        try {
            double cardWidth = 200;
            int columns = Math.max((int) (gridWidth / (cardWidth + 20)), 1);

            ArrayList<FamilyDto> familyCards = familyModel.allFamilyList();

            for (int i = 0; i < familyCards.size(); i++) {
                FamilyDto familyDto = familyCards.get(i);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Components/FamilyCard.fxml"));
                AnchorPane card = loader.load();

                int col = i % columns;
                int row = i / columns;

                gridFamily.add(card, col, row);
                GridPane.setMargin(card, new Insets(10));
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void btnAddMotherOnAction(ActionEvent actionEvent) {
        try {
            String name = txtMotherName.getText();
            String address = txtMotherAddress.getText();
            String nic = txtMotherNic.getText();
            String dob = txtMotherDob.getText();
            String occupation = txtMotherOccupation.getText();
            String email = txtMotherEmail.getText();
            String phoneNumber = txtMotherPhoneNumber.getText();
            int weight = Integer.parseInt(txtMotherWeight.getText());
            int height = Integer.parseInt(txtMotherHeight.getText());
            String allergies = txtMotherAllergies.getText();
            String medicalHistory = txtMotherMedicalHistory.getText();
            String note = txtMotherNote.getText();
            String blood = cmbMotherBloodType.getValue();

            int fatherId = Integer.parseInt(cmbFatherId.getValue().toString());

            System.out.println(fatherId);



            MotherDto dto = new MotherDto(0,name, address, nic, dob, occupation, email, phoneNumber, weight, height, allergies, medicalHistory, note, blood,fatherId);
            System.out.println(dto.getFather_id());
            boolean isSaved = motherModel.saveMother(dto);

            if (isSaved) {
                motherReset();
                new Alert(Alert.AlertType.INFORMATION, "Mother added!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void initializeMotherTable() {
        colMotherId.setCellValueFactory(new PropertyValueFactory<>("mother_id"));
        colMotherName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMotherAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colMotherNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colMotherEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMotherPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        colMotherAction.setCellValueFactory(new PropertyValueFactory<>("action"));
    }

    public void loadMotherTableData() throws SQLException, ClassNotFoundException {
        tblMother.setItems(FXCollections.observableArrayList(
                motherModel.getAllMother().stream()
                        .map(motherDto -> {
                            // Create Edit button with ✏️ emoji
                            Button editButton = new Button("\uD83D\uDD8B");
                            editButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");


                            // Create Delete button with 🗑️ emoji
                            Button deleteButton = new Button("\uD83D\uDDD1");
                            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

                            // Add actions
                            editButton.setOnAction(e -> {
                                editMotherDataLoader(motherDto);
                                System.out.println("Edit clicked for: " + motherDto.getMother_id());
                            });

                            deleteButton.setOnAction(e -> {
                                System.out.println("Delete clicked for: " + motherDto.getMother_id());
                                deleteMother(motherDto.getMother_id());
                            });

                            // Create HBox with buttons
                            HBox actionBox = new HBox(10, editButton, deleteButton);
                            actionBox.setAlignment(Pos.CENTER);

                            return new MotherTm(
                                    motherDto.getMother_id(),
                                    motherDto.getName(),
                                    motherDto.getAddress(),
                                    motherDto.getNic(),
                                    motherDto.getEmail(),
                                    motherDto.getPhone_number(),
                                    actionBox
                            );
                        }).toList()
        ));

    }

    public void btnUpdateMotherOnAction(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(lableId.getText());
            String name = txtMotherName.getText();
            String address = txtMotherAddress.getText();
            String nic = txtMotherNic.getText();
            String dob = txtMotherDob.getText();
            String occupation = txtMotherOccupation.getText();
            String email = txtMotherEmail.getText();
            String phoneNumber = txtMotherPhoneNumber.getText();
            int weight = Integer.parseInt(txtMotherWeight.getText());
            int height = Integer.parseInt(txtMotherHeight.getText());
            String allergies = txtMotherAllergies.getText();
            String medicalHistory = txtMotherMedicalHistory.getText();
            String note = txtMotherNote.getText();
            String blood = cmbMotherBloodType.getValue();

            MotherDto dto = new MotherDto(id, name, address, nic, dob, occupation, email, phoneNumber, weight, height, allergies, medicalHistory, note, blood);
            boolean isUpdated = motherModel.updateMother(dto);

            if (isUpdated) {
                motherReset();
                new Alert(Alert.AlertType.INFORMATION, "Mother updated!").show();

            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            e.printStackTrace();

        }
    }

    private void initializeChildTable() {
        colChildId.setCellValueFactory(new PropertyValueFactory<>("child_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("child_name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("Action"));

        resetChild();
    }

    public void deleteChild(int id) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Child");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete Child?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                boolean isDeleted = childModel.deleteChild(id);
                if (isDeleted) {
                    resetChild();
                    new Alert(Alert.AlertType.INFORMATION, "Child deleted successfully.").show();

                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to delete child.").show();
                }

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

            }

        }

    }


    public void tableMotherOnClick(MouseEvent mouseEvent) {
    }


    public void btnAddFatherOnAction(ActionEvent actionEvent) {
        String FatherName = txtFatherName.getText();
        String FatherAddress = txtFatherEmail.getText();
        String FatherNic = txtFatherNic.getText();
        String FatherDob = txtFatherDob.getText();
        String FatherOccupation = txtFatherOccupation.getText();
        String FatherEmail = txtFatherEmail.getText();
        String FatherPhoneNumber = txtFatherPhoneNumber.getText();
        String bloodType = cmbMotherBloodType.getValue();

        FatherDto fatherDto = new FatherDto(FatherName, FatherAddress, FatherNic, FatherDob, FatherOccupation, FatherEmail, FatherPhoneNumber, bloodType);
        try {
            boolean isAdd = fatherModel.saveFather(fatherDto);
            fatherReset();
            if (isAdd) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Father added!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Father not added!");
                alert.show();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.show();
            e.printStackTrace();

        }
    }

    private void initializeFatherTable() {
        colFatherId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFatherName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colFatherAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colFatherNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colFatherEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colFatherPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        colFatherAction.setCellValueFactory(new PropertyValueFactory<>("Action"));

        fatherReset();
    }

    public void loadFatherTableData() throws SQLException, ClassNotFoundException {
        tableFather.setItems(FXCollections.observableArrayList(
                fatherModel.getAllFather().stream()
                        .map(fatherDto -> {
                            // Create Edit button with ✏️ emoji
                            Button editButton = new Button("\uD83D\uDD8B");
                            editButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");


                            // Create Delete button with 🗑️ emoji
                            Button deleteButton = new Button("\uD83D\uDDD1");
                            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

                            // Add actions
                            editButton.setOnAction(e -> {
                                editFatherDataLoader(fatherDto);
                                System.out.println("Edit clicked for: " + fatherDto.getFather_id());
                            });

                            deleteButton.setOnAction(e -> {
                                fatherDelete(fatherDto.getFather_id());
                                System.out.println("Delete clicked for: " + fatherDto.getFather_id());
                            });

                            // Create HBox with buttons
                            HBox actionBox = new HBox(10, editButton, deleteButton);
                            actionBox.setAlignment(Pos.CENTER);

                            return new FatherTm(
                                    fatherDto.getFather_id(),
                                    fatherDto.getName(),
                                    fatherDto.getAddress(),
                                    fatherDto.getNic(),
                                    fatherDto.getEmail(),
                                    fatherDto.getPhone_number(),
                                    actionBox
                            );
                        }).toList()
        ));
    }

    public void fatherReset() {

        txtFatherName.clear();
        txtFatheraddress.clear();
        txtFatherNic.clear();
        txtFatherDob.clear();
        txtFatherOccupation.clear();
        txtFatherEmail.clear();
        txtFatherPhoneNumber.clear();
        cmbFatherBloodType.setValue(null);

        btnAddFather.setDisable(false);
        btnUpdateFather.setDisable(true);
        try {
            loadFatherTableData();
            ArrayList<FatherDto> fathers= fatherModel.getAllFather();
            cmbFatherId.setItems(FXCollections.observableArrayList(fathers));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void editFatherDataLoader(FatherDto fatherDto) {
        lableFatherId.setText(Integer.toString(fatherDto.getFather_id()));
        txtFatherName.setText(fatherDto.getName());
        txtFatheraddress.setText(fatherDto.getAddress());
        txtFatherNic.setText(fatherDto.getNic());
        txtFatherDob.setText(fatherDto.getDob());
        txtFatherOccupation.setText(fatherDto.getOccupation());
        txtFatherEmail.setText(fatherDto.getEmail());
        txtFatherPhoneNumber.setText(fatherDto.getPhone_number());
        cmbFatherBloodType.setValue(fatherDto.getBlood_type());


        btnAddFather.setDisable(true);
        btnUpdateFather.setDisable(false);
    }

    public void btnUpdateFatherOnAction(ActionEvent actionEvent) {

        int fatherId = Integer.parseInt(lableFatherId.getText());
        String name = txtFatherName.getText();
        String address = txtFatheraddress.getText();
        String nic = txtFatherNic.getText();
        String dob = txtFatherDob.getText();
        String occupation = txtFatherOccupation.getText();
        String email = txtFatherEmail.getText();
        String phoneNumber = txtFatherPhoneNumber.getText();
        String bloodType = cmbFatherBloodType.getValue() != null ? cmbFatherBloodType.getValue().toString() : "";


        FatherDto fatherDto = new FatherDto(
                fatherId,
                name,
                address,
                nic,
                dob,
                occupation,
                email,
                phoneNumber,
                bloodType
        );

        try {
            boolean isUpdated = fatherModel.updateFather(fatherDto);
            if (isUpdated) {
                fatherReset();
                new Alert(Alert.AlertType.INFORMATION, "Father updated successfully.").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to update Father.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    public void fatherDelete(int fatherId) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Father");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete Father?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                boolean isDeleted = fatherModel.deleteFather(fatherId);
                if (isDeleted) {
                    fatherReset();
                    new Alert(Alert.AlertType.INFORMATION, "father deleted successfully.").show();

                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to delete father.").show();
                }

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

            }

        }


    }

    public void tableFatherOnClick(MouseEvent mouseEvent) {
    }

    public void btnChildAddOnAction(ActionEvent actionEvent) {
        String name = txtChildFullName.getText();
        String address = txtChildAddress.getText();
        String birthPlace = txtChildBirthPlace.getText();
        String gender = txtChildGender.getText();
        String dob = txtChildDob.getText();
        float birtHeight = Float.parseFloat(txtChildHeight.getText());
        float   birtWeight =Float.parseFloat(txtChildWeight.getText());
        String note = txtChildNote.getText();
        String bloodType = cmbChildBloodType.getValue().toString();

        ChildDto childDto = new ChildDto(name, address, birthPlace, gender, dob, birtHeight, birtWeight, note, bloodType);

        try {
            boolean isUpdated = childModel.saveChild(childDto);
            if (isUpdated) {
               resetChild();
                new Alert(Alert.AlertType.INFORMATION, "Child updated successfully.").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to update Child.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void resetChild() {
        txtChildFullName.clear();
        txtChildAddress.clear();
        txtChildBirthPlace.clear();
        txtChildGender.clear();
        txtChildHeight.clear();
        txtChildWeight.clear();
        txtChildNote.clear();
        txtChildDob.clear();
        cmbChildBloodType.setValue(null);

        btnChildAdd.setDisable(false);
        btnUpdateChild.setDisable(true);

        try {
            loadChildTableData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void editChildDataLoader(ChildDto childDto) {

        txtChildId.setText(Integer.toString(childDto.getChild_id()));
        txtChildFullName.setText(childDto.getName());
        txtChildAddress.setText(childDto.getAddress());
        txtChildBirthPlace.setText(childDto.getBirth_place());
        txtChildGender.setText(childDto.getGender());
        txtChildHeight.setText(String.valueOf(childDto.getBirth_height()));
        txtChildWeight.setText(String.valueOf(childDto.getBirth_weight()));
        txtChildNote.setText(childDto.getNote());
        cmbChildBloodType.setValue(childDto.getBlood_type());
        txtChildDob.setText(childDto.getDob());

        btnChildAdd.setDisable(true);
        btnUpdateChild.setDisable(false);

    }

    public void btnChildUpdateOnAction(ActionEvent actionEvent) {
        int childId = Integer.parseInt(txtChildId.getText());
        String name = txtChildFullName.getText();
        String address = txtChildAddress.getText();
        String birthPlace = txtChildBirthPlace.getText();
        String gender = txtChildGender.getText();
        String dob = txtChildDob.getText();
        float birtHeight = Float.parseFloat(txtChildHeight.getText());
        float birtWeight = Float.parseFloat(txtChildWeight.getText());
        String note = txtChildNote.getText();
        String bloodType = String.valueOf(cmbChildBloodType.getValue());

//        System.out.println(childId);

        ChildDto childDto = new ChildDto(childId,name,address,birthPlace,gender,dob,birtHeight,birtWeight,note,bloodType);
        try {
            boolean isAdded = childModel.updateChild(childDto);
            if (isAdded) {
                resetChild();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully added child.");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to add Child");
                alert.show();
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.show();
            e.printStackTrace();

        }


    }

    public void tableChildOnClicked(MouseEvent mouseEvent) {

    }


    public void motherReset() {
        txtMotherName.clear();
        txtMotherAddress.clear();
        txtMotherNic.clear();
        txtMotherDob.clear();
        txtMotherOccupation.clear();
        txtMotherEmail.clear();
        txtMotherPhoneNumber.clear();
        txtMotherHeight.clear();
        txtMotherWeight.clear();
        txtMotherAllergies.clear();
        txtMotherMedicalHistory.clear();
        txtMotherNote.clear();
        cmbMotherBloodType.setValue(null);

        btnAddMother.setDisable(false);
        btnUpdateMother.setDisable(true);
        try {
            loadMotherTableData();
            loadFatherTableData();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            e.printStackTrace();
        }

    }

    public void deleteMother(int motherId) {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Mother");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this Mother?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                boolean isDeleted = motherModel.deleteMother(motherId);

                System.out.println("Deleted session successfully");
                if (isDeleted) {
                    motherReset();
                    System.out.println("Deleted Mother successfully");

                }

            } else {
                new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();

        }

    }

    public void editMotherDataLoader(MotherDto motherDto) {
        lableId.setText(Integer.toString(motherDto.getMother_id()));
        txtMotherName.setText(motherDto.getName());
        txtMotherAddress.setText(motherDto.getAddress());
        txtMotherNic.setText(motherDto.getNic());
        txtMotherDob.setText(motherDto.getDob());
        txtMotherOccupation.setText(motherDto.getOccupation());
        txtMotherEmail.setText(motherDto.getEmail());
        txtMotherPhoneNumber.setText(motherDto.getPhone_number());
        txtMotherHeight.setText(String.valueOf(motherDto.getHeight()));
        txtMotherWeight.setText(String.valueOf(motherDto.getWeight()));
        txtMotherAllergies.setText(motherDto.getAllergies());
        txtMotherMedicalHistory.setText(motherDto.getMedical_history());
        txtMotherNote.setText(motherDto.getNote());
        cmbMotherBloodType.setValue(motherDto.getBlood_type());


        btnAddMother.setDisable(true);
        btnUpdateMother.setDisable(false);
    }

    public void btnMotherRefashOnAction(ActionEvent actionEvent) {
        motherReset();
    }


    public void btnFatherRefashOnAction(ActionEvent actionEvent) {
        fatherReset();
    }

    public void loadChildTableData() throws SQLException, ClassNotFoundException {
        tableChild.setItems(FXCollections.observableArrayList(
                childModel.getAllChild().stream()
                        .map(childDto -> {
                            // Create Edit button with ✏️ emoji
                            Button editButton = new Button("\uD83D\uDD8B");
                            editButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");


                            // Create Delete button with 🗑️ emoji
                            Button deleteButton = new Button("\uD83D\uDDD1");
                            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

                            // Add actions
                            editButton.setOnAction(e -> {
                                editChildDataLoader(childDto);
                                System.out.println("Edit clicked for: " + childDto.getChild_id());
                            });

                            deleteButton.setOnAction(e -> {
                                deleteChild(childDto.getChild_id());
                                System.out.println("Delete clicked for: " + childDto.getChild_id());
                            });

                            // Create HBox with buttons
                            HBox actionBox = new HBox(10, editButton, deleteButton);
                            actionBox.setAlignment(Pos.CENTER);

                            return new ChildTm(
                                    childDto.getChild_id(),
                                    childDto.getName(),
                                    childDto.getAddress(),
                                    childDto.getGender(),
                                    childDto.getDob(),
                                    actionBox
                            );
                        }).toList()
        ));
    }

    public void btnChildRefashOnAction(ActionEvent actionEvent) {
        resetChild();
    }
}