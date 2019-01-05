/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class HomePageController implements Initializable {

    @FXML
    private AnchorPane mainDashBoard;
    @FXML
    private Label dateLabel;
    @FXML
    private Label timeLabel1;
    @FXML
    private JFXButton btnLoanPayment;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/DashBoard.fxml"));
            mainDashBoard.getChildren().add(an);
            
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDAteTime();
    }    

    @FXML
    private void createLoanPaneLoad(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/CreateLoan.fxml"));
            mainDashBoard.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void homeButtonIsClick(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/DashBoard.fxml"));
            mainDashBoard.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openAccButtonIsClick(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/OpenAccount.fxml"));
            mainDashBoard.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void accButtonIsClick(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/LoanAndAccSetting.fxml"));
            mainDashBoard.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void depositeButtonIsClick(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/MoneyDepositAndWithdraw.fxml"));
            mainDashBoard.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  private void setDAteTime(){
        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                dateLabel.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                timeLabel1.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }  

    @FXML
    private void reportPaneLoad(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/ReportPage.fxml"));
            mainDashBoard.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logOut(MouseEvent event) {
        Stage stage  = (Stage) mainDashBoard.getScene().getWindow();
         Alert a=new Alert(Alert.AlertType.INFORMATION, "Are you Sure, do you want LogOut in Bank Management System?", ButtonType.YES);
         a.showAndWait();
         stage.close();
    }

    @FXML
    private void minimise(MouseEvent event) {
        Stage stage  = (Stage) mainDashBoard.getScene().getWindow();
        stage.setIconified(true);
        
    }

    @FXML
    private void manageCustomerPaneLoad(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/CustomerManage.fxml"));
            mainDashBoard.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loanPayment(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/LoanPaymentAndDetails.fxml"));
            mainDashBoard.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
