package lk.ijse.RoyalInstitute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.RoyalInstitute.business.BOFactory;
import lk.ijse.RoyalInstitute.business.BOType;
import lk.ijse.RoyalInstitute.business.custom.CourseBO;
import lk.ijse.RoyalInstitute.dto.CourseDTO;
import lk.ijse.RoyalInstitute.model.CourseTM;

import java.util.List;
import java.util.Optional;

public class CourseRegistrationViewController {
    public JFXTextField txtProgramId;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public TableView<CourseTM>tblCourse;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXButton btnCancel;

    CourseBO courseBO = BOFactory.getInstance().getBO(BOType.COURSE);

    public void initialize() {

        btnDelete.setDisable(true);

        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("proId"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("pro"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tblCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));

        loadTable();

        tblCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {

            @Override
            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM newValue) {
                btnDelete.setDisable(false);
                btnSave.setText("Update");

                CourseTM tm = tblCourse.getSelectionModel().getSelectedItem();

                if (tm == null) {
                    return;
                }

                txtProgramId.setText(tm.getProId());
                txtProgram.setText(tm.getPro());
                txtDuration.setText(tm.getDuration());
                txtFee.setText(tm.getFee());

            }
        });
    }

    private void loadTable() {
        ObservableList<CourseTM> items = tblCourse.getItems();
        items.clear();
        try {
            List<CourseDTO> allCourses = courseBO.getAllCourses();
            for (CourseDTO courseDTO : allCourses) {
                items.add(new CourseTM(courseDTO.getProId(),
                        courseDTO.getPro(),
                        courseDTO.getDuration(),
                        courseDTO.getFee()));
            }
            tblCourse.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String proId = txtProgramId.getText();
        String pro = txtProgram.getText();
        String duration = txtDuration.getText();
        String fee = txtFee.getText();
        

        CourseDTO courseDTO = new CourseDTO(proId,pro,duration,fee);

        if (btnSave.getText().trim().equals("Save")) {
            save(courseDTO);
        } else {
            update(courseDTO);
        }
        txtProgramId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
        loadTable();
        
    }

    private void save(CourseDTO courseDTO) {
        try {
            boolean isAdded = courseBO.saveCourse(courseDTO);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Course saved Successful...").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "oops..! saving progress Unsuccessful...").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void update(CourseDTO courseDTO) {
        try {
            boolean isAdded = courseBO.updateCourse(courseDTO);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Course updated Successful...").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "oops..! update Unsuccessful...").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String proId = txtProgramId.getText();
        String pro = txtProgram.getText();
        String duration = txtDuration.getText();
        String fee = txtFee.getText();

        try {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure? You want to Delete this student...", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get().equals(ButtonType.YES)) {
                courseBO.deleteCourse(new CourseDTO(proId,pro,duration,fee));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        txtProgramId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
        loadTable();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }
}
