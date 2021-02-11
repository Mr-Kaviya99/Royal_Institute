package lk.ijse.RoyalInstitute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class LogingFormController {
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXButton btnLogIn;


    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();

        if (userName.length() > 0 && password.length() > 0) {

            if (userName.equalsIgnoreCase("kavindu")
                    && password.equalsIgnoreCase("kavi")) {

                URL resource = this.getClass().getResource("../view/DashboardView.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene= new Scene(load);
                Stage stage= new Stage();
                stage.setScene(scene);
                stage.show();

            } else {
                new Alert(Alert.AlertType.WARNING, "Wrong Password Or User Name !",
                        ButtonType.OK).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty !",
                    ButtonType.OK).show();

        }

    }


}
