/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class DashBoardController implements Initializable {

    @FXML
    private AnchorPane dashBoardPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void openAccButtonIsClick(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/OpenAccount.fxml"));
            dashBoardPane.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createLoanButtonIsClick(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/CreateLoan.fxml"));
            dashBoardPane.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void accSettingButtonIsClick(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/LoanAndAccSetting.fxml"));
            dashBoardPane.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mouseIsExited(MouseEvent event) {
        ImageView source = (ImageView) event.getSource();
        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(300),source);
        scaleTrans.setToX(1);
        scaleTrans.setToY(1);
        scaleTrans.play();
        
        source.setEffect(null);
    }

    private void mouseIsEntered(MouseEvent event) {
        ImageView source = (ImageView) event.getSource();
        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(300),source);
        scaleTrans.setToX(1.2);
        scaleTrans.setToY(1.2);
        scaleTrans.play();
        
        DropShadow tt = new DropShadow();
        tt.setColor(Color.CORNFLOWERBLUE);
        tt.setWidth(30);
        tt.setHeight(30);
        tt.setRadius(30);
        
        source.setEffect(tt);
    }

    private void depositeButtonIsClick(MouseEvent event) {
        try {
            AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/MoneyDepositAndWithdraw.fxml"));
            dashBoardPane.getChildren().add(an);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
