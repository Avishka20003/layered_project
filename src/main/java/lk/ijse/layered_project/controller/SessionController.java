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
import lk.ijse.layered_project.bo.custom.SessionBO;
import lk.ijse.layered_project.dto.SessionDto;
import lk.ijse.layered_project.view.SessionTm;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SessionController implements Initializable {

    public Label labelId;
    public TextField txtTopic;

    public DatePicker date;
    public TextField txtDuration;
    public TextArea txtDescription;

    public Button btnAddSession;
    public Button btnUpdateSession;

    public TableView<SessionTm> tableView;
    public TableColumn<SessionTm, Integer> colSessionId;
    public TableColumn<SessionTm, String> colTopic;
    public TableColumn<SessionTm, String> colDescription;
    public TableColumn<SessionTm, String> colDate;
    public TableColumn<SessionTm, String> colDuration;
    public TableColumn<SessionTm, String> colAction;


//    SesstionModel sesstionModel = new SesstionModel();   //  creat an intance of sesstionmodel
    SessionBO sessionBO = (SessionBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SESSION);


    public void btnAddSessionOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String topic = txtTopic.getText();
        String description = txtDescription.getText();
        String dt = date.getValue().toString();
        String duration = txtDuration.getText();

        SessionDto session = new SessionDto(topic, description, dt, duration, 1);


        try {
            boolean isAdd = sessionBO.saveSession(session);
            if (isAdd) {
                reset();
                new Alert(Alert.AlertType.CONFIRMATION, "Session added successfully").show();

            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Session added error").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
            e.printStackTrace();

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTable();
        try {
            reset();
            loadTableData();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }

    }

    public void initializeTable() {
        colSessionId.setCellValueFactory(new PropertyValueFactory<>("session_id"));
        colTopic.setCellValueFactory(new PropertyValueFactory<>("topic"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("action"));
    }

    public void loadTableData() throws SQLException, ClassNotFoundException {
        tableView.setItems(FXCollections.observableArrayList(
                sessionBO.getAllSession().stream()
                        .map(sessionDTO -> {
                            // Create Edit button with ✏️ emoji
                            Button editButton = new Button("\uD83D\uDD8B");
                            editButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

                            // Create Delete button with 🗑️ emoji
                            Button deleteButton = new Button("\uD83D\uDDD1");
                            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");


                            // Add actions
                            editButton.setOnAction(e -> {

                                System.out.println("Edit clicked for: " + sessionDTO.getSession_id());
                                editClinicDataLoader(sessionDTO);
                                System.out.println("Edit clicked for: "+sessionDTO.getSession_id());
                            });

                            deleteButton.setOnAction(e -> {
                                System.out.println("Delete clicked for: " + sessionDTO.getSession_id());
                                deleteSession(sessionDTO.getSession_id());
                            });

                            // Create HBox with buttons
                            HBox actionBox = new HBox(10, editButton, deleteButton);
                            actionBox.setAlignment(Pos.CENTER);

                            return new SessionTm(
                                    sessionDTO.getSession_id(),
                                    sessionDTO.getTopic(),
                                    sessionDTO.getDescription(),
                                    sessionDTO.getDate(),
                                    sessionDTO.getDuration(),
                                    actionBox
                            );
                        })
                        .collect(Collectors.toList()) // Replace .toList() if using Java < 16
        ));
    }

    public void reset() {
        txtTopic.clear();
        txtDuration.clear();
        txtDescription.clear();
        txtDuration.clear();
        btnAddSession.setDisable(false);
        btnUpdateSession.setDisable(true);
        try {
            loadTableData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteSession(int id) {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Session");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this session?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                boolean isDeleted = sessionBO.deleteSession(id);

                if (isDeleted) {
                    reset();
                    System.out.println("Deleted session successfully");

                } else {
                    new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
                }
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();

        }

    }

    public void editClinicDataLoader(SessionDto sessionDto) {
        labelId.setText(Integer.toString(sessionDto.getSession_id()));
        txtTopic.setText(sessionDto.getTopic());
        txtDescription.setText(sessionDto.getDescription());
        date.setValue(LocalDate.parse(sessionDto.getDate()));
        txtDuration.setText(sessionDto.getDuration());

        btnAddSession.setDisable(true);
        btnUpdateSession.setDisable(false);
    }


    public void btnUpdateSessionOnAction(ActionEvent actionEvent) {
        int sessionId = Integer.parseInt(labelId.getText());
        String topic = txtTopic.getText();
        String description = txtDescription.getText();
        String dt = date.getValue().toString();
        String duration = txtDuration.getText();

        SessionDto sessionDto = new SessionDto(
                sessionId,
                topic,
                description,
                dt,
                duration,
                1
        );
        try {
            boolean isUpdated = sessionBO.updateSession(sessionDto);
            if (isUpdated) {
                reset();
                new Alert(Alert.AlertType.INFORMATION, "Customer updated successfully.").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to update customer.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void tableSessinOnClick(MouseEvent mouseEvent) {
    }
}

