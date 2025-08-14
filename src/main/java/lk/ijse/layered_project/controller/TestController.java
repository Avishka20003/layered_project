package lk.ijse.layered_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import lk.ijse.layered_project.bo.BOFactory;
import lk.ijse.layered_project.bo.custom.MotherBO;
import lk.ijse.layered_project.bo.custom.TestBO;
import lk.ijse.layered_project.dto.MotherDto;
import lk.ijse.layered_project.dto.TestDto;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestController implements Initializable {

    public ComboBox cmbMotherAddId;
    public ComboBox cmbMotherSearchId;
    public ComboBox cmbMoherTestId;


    public CheckBox checkBox1BloodTest;
    public CheckBox checkBox1UrineTest;
    public CheckBox checkBox1UltrasoundTest;
    public CheckBox checkBox1FolicAcid;
    public CheckBox checkBox1FerrousSulfate;
    
    public CheckBox checkBox2OgttTest;
    public CheckBox checkBox2TetanusVaccineTest;
    public CheckBox checkBox2FolicAcid;
    public CheckBox checkBox2FerrousSulfate;
    public CheckBox checkBox2VitaminD;
    public CheckBox checkBox2Calcium;
    
    public CheckBox checkBox3AllTestWeeklyChecks;
    public CheckBox checkBox3FolicAcid;
    public CheckBox checkBox3FerrousSulfate;


    TestBO testModel = (TestBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.TEST);
    MotherBO motherModel = (MotherBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MOTHER);

  /*  private TestModel testModel = new TestModel();
    public MotherModel motherModel = new MotherModel();
*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadMothers();
    }

    public void loadMothers() {
        try {
            ArrayList<MotherDto> mothers = motherModel.getAllMother();

            cmbMotherAddId.getItems().clear();
            cmbMotherSearchId.getItems().clear();

            cmbMotherAddId.getItems().addAll(mothers);
            cmbMotherSearchId.getItems().addAll(mothers);

            cmbMotherAddId.setCellFactory(lv -> new ListCell<MotherDto>() {
                @Override
                protected void updateItem(MotherDto item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item.getName());
                }
            });

            cmbMotherAddId.setButtonCell(new ListCell<MotherDto>() {
                @Override
                protected void updateItem(MotherDto item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item.getName());
                }
            });

            cmbMotherSearchId.setCellFactory(lv -> new ListCell<MotherDto>() {
                @Override
                protected void updateItem(MotherDto item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item.getName());
                }
            });

            cmbMotherSearchId.setButtonCell(new ListCell<MotherDto>() {
                @Override
                protected void updateItem(MotherDto item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item.getName());
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void loadAllTestsForSearch() {
        try {
            ArrayList<TestDto> tests = testModel.getAllTest();
            for (TestDto test : tests) {

            }
        } catch (SQLException | ClassNotFoundException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to load tests: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void btnMotherIdSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnMotherIdTestIdAddOnAction(ActionEvent actionEvent) {
    }
    public ArrayList<String> getSelectedItems() {

        ArrayList<String> selectedItems = new ArrayList<>();

        if (checkBox1BloodTest.isSelected()) selectedItems.add("Blood Test");
        if (checkBox1UrineTest.isSelected()) selectedItems.add("Urine Test");
        if (checkBox1UltrasoundTest.isSelected()) selectedItems.add("Ultrasound Test");
        if (checkBox1FolicAcid.isSelected()) selectedItems.add("Folic Acid (1st Trimester)");
        if (checkBox1FerrousSulfate.isSelected()) selectedItems.add("Ferrous Sulfate (1st Trimester)");


        if (checkBox2OgttTest.isSelected()) selectedItems.add("OGTT Test");
        if (checkBox2TetanusVaccineTest.isSelected()) selectedItems.add("Tetanus Vaccine");
        if (checkBox2FolicAcid.isSelected()) selectedItems.add("Folic Acid (2nd Trimester)");
        if (checkBox2FerrousSulfate.isSelected()) selectedItems.add("Ferrous Sulfate (2nd Trimester)");
        if (checkBox2VitaminD.isSelected()) selectedItems.add("Vitamin D");
        if (checkBox2Calcium.isSelected()) selectedItems.add("Calcium");


        if (checkBox3AllTestWeeklyChecks.isSelected()) selectedItems.add("All Tests + Weekly Checks");
        if (checkBox3FolicAcid.isSelected()) selectedItems.add("Folic Acid (3rd Trimester)");
        if (checkBox3FerrousSulfate.isSelected()) selectedItems.add("Ferrous Sulfate (3rd Trimester)");

        return selectedItems;
    }

}