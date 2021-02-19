package lk.ijse.RoyalInstitute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.RoyalInstitute.business.BOFactory;
import lk.ijse.RoyalInstitute.business.BOType;
import lk.ijse.RoyalInstitute.business.custom.StudentBO;
import lk.ijse.RoyalInstitute.dto.StudentDTO;
import lk.ijse.RoyalInstitute.model.StudentTM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class StudentRegistrationViewController {

    public JFXTextField txtStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXButton btnBack;
    public JFXTextField txtContact;
    public JFXDatePicker dpDOB;
    public RadioButton radioMale;
    public RadioButton radioFemale;
    public AnchorPane txtGender;
    public ToggleGroup tgGender;
    public TableView<StudentTM> tblStudent;

    StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize() {

        btnDelete.setDisable(true);

        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));

        loadTable();

        tblStudent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StudentTM>() {

            @Override
            public void changed(ObservableValue<? extends StudentTM> observable, StudentTM oldValue, StudentTM newValue) {
                btnDelete.setDisable(false);
                btnSave.setText("Update");

                StudentTM tm = tblStudent.getSelectionModel().getSelectedItem();

                if (tm == null) {
                    return;
                }

                txtStudentID.setText(tm.getId());
                txtStudentName.setText(tm.getStudentName());
                txtStudentAddress.setText(tm.getAddress());
                txtContact.setText(tm.getContact());
                dpDOB.setValue(LocalDate.parse(tm.getDob()));
                if (tm.getGender() != "Female") {
                    tgGender.selectToggle(radioMale);
                }else{
                    tgGender.selectToggle(radioFemale);
                }
            }
        });
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String address = txtStudentAddress.getText();
        String contact = txtContact.getText();
        String dob = dpDOB.getValue().toString();
        String gender = "";
        if (radioMale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }

        StudentDTO studentDTO = new StudentDTO(id,name,address,contact,dob,gender);

        if (btnSave.getText().trim().equals("Save")) {
            save(studentDTO);
        } else {
            update(studentDTO);
        }
        loadTable();
        clear();
    }

    private void clear() {
        txtStudentID.clear();
        txtStudentName.clear();
        txtStudentAddress.clear();
        txtContact.clear();
        dpDOB.setValue(null);
        radioMale.setSelected(false);
        radioFemale.setSelected(false);
    }

    public void loadTable() {
        ObservableList<StudentTM> items = tblStudent.getItems();
        items.clear();
        try {
            List<StudentDTO> allStudents = studentBO.getAllStudents();
            for (StudentDTO student : allStudents) {
                items.add(new StudentTM(student.getId(),
                        student.getStudentName(),
                        student.getAddress(),
                        student.getContact(),
                        student.getDob(),
                        student.getGender()));
            }
            tblStudent.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save(StudentDTO studentDTO) {
        try {
            boolean isAdded = studentBO.saveStudent(studentDTO);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Registration Successful...").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "oops..! Registration Unsuccessful...").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void update(StudentDTO studentDTO) {
        try {
            boolean isAdded = studentBO.updateStudent(studentDTO);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student updated Successful...").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "oops..! update Unsuccessful...").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String address = txtStudentAddress.getText();
        String contact = txtContact.getText();
        String dob = dpDOB.getValue().toString();
        String gender = "";
        if (radioMale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }

        try {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure? You want to Delete this student...", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get().equals(ButtonType.YES)) {
                studentBO.deleteStudent(new StudentDTO(id,name,address,contact,dob,gender));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        loadTable();
        clear();
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }
}


