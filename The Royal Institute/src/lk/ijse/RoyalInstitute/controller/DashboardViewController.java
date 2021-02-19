package lk.ijse.RoyalInstitute.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashboardViewController {

    public Label lblDate;
    public Label lblTime;
    public JFXButton btnStudent;
    public JFXButton btnCourse;
    public AnchorPane root;

    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location)));

    }

    public void initialize() throws IOException {
        initUi("StudentRegistrationView.fxml");
        genarateOrderDate();
        setLblTime();
    }
    
    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        initUi("StudentRegistrationView.fxml");
    }

    public void btnCourseOnAction(ActionEvent actionEvent) throws IOException {
        initUi("CourseRegistrationView.fxml");
    }
    public void btnRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        initUi("RegistrationView.fxml");
    }

    private void genarateOrderDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String orderDate = sdf.format(date);
        lblDate.setText(orderDate);
    }

    public void setLblTime(){
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, event -> {
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


}
