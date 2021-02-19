package lk.ijse.RoyalInstitute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.RoyalInstitute.business.BOFactory;
import lk.ijse.RoyalInstitute.business.BOType;
import lk.ijse.RoyalInstitute.business.custom.RegisterBO;
import lk.ijse.RoyalInstitute.dto.CourseDTO;
import lk.ijse.RoyalInstitute.dto.RegisterDTO;
import lk.ijse.RoyalInstitute.dto.StudentDTO;
import lk.ijse.RoyalInstitute.model.RegisterTM;

import java.util.List;


public class RegistrationViewController {
    public JFXTextField txtRegId;
    public JFXTextField txtRegDate;
    public JFXTextField txtRegFee;
    public JFXTextField txtStudentId;
    public JFXTextField txtCourseCode;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public TableView<RegisterTM> tblRegister;

    RegisterBO registerBO = BOFactory.getInstance().getBO(BOType.REGISTER);

    public void initialize() {

        tblRegister.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("regNo"));
        tblRegister.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("student"));
        tblRegister.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("course"));
        tblRegister.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("regDate"));
        tblRegister.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("regFee"));

        loadTable();

        tblRegister.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RegisterTM>() {

            @Override
            public void changed(ObservableValue<? extends RegisterTM> observable, RegisterTM oldValue, RegisterTM newValue) {


                RegisterTM tm = tblRegister.getSelectionModel().getSelectedItem();

                if (tm == null) {
                    return;
                }

                txtRegId.setText(tm.getRegNo());
                txtRegDate.setText(tm.getRegDate());
                txtRegFee.setText(tm.getRegFee());
                txtStudentId.setText(tm.getStudentId());
                txtCourseCode.setText(tm.getCourseId());

            }
        });
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String regNo = txtRegId.getText();
        String regDate = txtRegDate.getText();
        String regFee = txtRegFee.getText();
        StudentDTO studentDTO = new StudentDTO(txtStudentId.getText());
        CourseDTO courseDTO = new CourseDTO(txtCourseCode.getText());
        String courseCode = txtCourseCode.getText();


        RegisterDTO registerDTO = new RegisterDTO(regNo,regDate,regFee,studentDTO,courseDTO);

        try {
            boolean isAdded = registerBO.saveRegister(registerDTO);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Registration Successful...").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "oops..! Registration Unsuccessful...").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        loadTable();
        txtRegId.clear();
        txtRegDate.clear();
        txtRegFee.clear();
        txtStudentId.clear();
        txtCourseCode.clear();
    }


    private void loadTable() {
        ObservableList<RegisterTM> items = tblRegister.getItems();
        items.clear();
        try {
            List<RegisterDTO> allregisters = registerBO.getAllRegisters();
            for (RegisterDTO registerDTO : allregisters) {
                items.add(new RegisterTM(registerDTO.getRegNo(),
                        registerDTO.getRegDate(),
                        registerDTO.getRegFee(),
                        registerDTO.getStudentDTO(),
                        registerDTO.getCourseDTO()));
            }
            tblRegister.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }
}
