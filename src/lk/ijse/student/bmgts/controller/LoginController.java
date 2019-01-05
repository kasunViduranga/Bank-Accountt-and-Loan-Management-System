/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.student.bmgts.commen.PasswordUtil;
import lk.ijse.student.bmgts.dao.CrudUtil;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private JFXButton btnNewUser;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnNewUser.setVisible(false);
    }    

    @FXML
    private void isLogIn(MouseEvent event) throws Exception {
        try {
            ResultSet rst = CrudUtil.executeQuery("Select * from user");
        if(rst.next()){
            String userName=rst.getString(2);
            String salt=rst.getString(3);
            String secPw=rst.getString(4);
            
            boolean ifPasswordMatches=PasswordUtil.verifyUserPassword(txtPassword.getText(), secPw, salt);
            if (ifPasswordMatches && txtUserName.getText().equals(userName)) {
                Parent root= FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/HomePage.fxml"));
            Scene tempScence= new Scene(root);
            Stage stage= (Stage) this.mainPane.getScene().getWindow();
            stage.setScene(tempScence);
            stage.centerOnScreen();
            
            TranslateTransition tempTranslate = new TranslateTransition(Duration.millis(600), root);
            tempTranslate.setFromY(-tempScence.getWidth());
            tempTranslate.setToY(0);
            tempTranslate.play();
            } else {
                Alert a=new Alert(Alert.AlertType.ERROR,"Error in username password combination!", ButtonType.OK);
                a.showAndWait();
            }
        }
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cancel(MouseEvent event) {
        Stage stage= (Stage) this.mainPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void isnewUser(MouseEvent event) throws Exception {
    try {
            String userName=txtUserName.getText();
            String password=txtPassword.getText();
            String salt=PasswordUtil.getSalt(30);
            String secPw=PasswordUtil.generateSecurePassword(password, salt);
            CrudUtil.executeUpdate("Insert into user values(?,?,?,?)", "001",userName,salt,secPw);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
