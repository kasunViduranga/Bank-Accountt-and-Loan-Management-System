/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.student.bmgts.business.BOFactory;
import lk.ijse.student.bmgts.business.custom.InstalmentpaymentBO;
import lk.ijse.student.bmgts.business.custom.LoanBO;
import lk.ijse.student.bmgts.commen.IDGenarator;
import lk.ijse.student.bmgts.model.InstalmentpaymentDTO;
import lk.ijse.student.bmgts.model.LoanDTO;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class LoanPaymentAndDetailsController implements Initializable {

    

    private LoanBO loanBO;
   
    
    private InstalmentpaymentBO instalmentpaymentBO;
    @FXML
    private JFXTextField txtLoanPaymentID;
    @FXML
    private JFXTextField txtPayTotal;
    @FXML
    private JFXTextField txtPayPersonID;
    @FXML
    private JFXTextField txtPaymentAmount;
    @FXML
    private JFXTextField txtPayDate;
    @FXML
    private JFXComboBox<String> cmbLoanNumber;
    @FXML
    private JFXTextField txtLoanDuration;
    @FXML
    private JFXTextField txtLoanIterestCharge;
    @FXML
    private JFXTextField txtLoanAmount;
    @FXML
    private JFXTextField txtMonthlyPayment;
    @FXML
    private JFXTextField txtLoanDate;
    @FXML
    private JFXTextField txtLoanType;
    @FXML
    private JFXTextField txtLoanTotal;
    @FXML
    private JFXTextField txtCusID;
    @FXML
    private JFXTextField txt2ndGarenterID;
    @FXML
    private JFXTextField txt1stGarenterID;
    @FXML
    private JFXTextField txtLoanPayDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loanBO=(LoanBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.LOAN);
            instalmentpaymentBO=(InstalmentpaymentBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.INSTALMENTPAYMENT);
            loadLoanNumber();
            loanNumLoader();
            comboEvent();
            setDAteTime();
        } catch (Exception ex) {
            Logger.getLogger(LoanPaymentAndDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void loadLoanNumber() throws Exception{
        ArrayList<String> loanNum= loanBO.getAllLoanID();
        cmbLoanNumber.getItems().clear();
        for(String id:loanNum){
            cmbLoanNumber.getItems().add(id);
        }
    }
    
    
    private void comboEvent() throws Exception{
        cmbLoanNumber.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    String loanNum=cmbLoanNumber.getValue();
                    LoanDTO ref=loanBO.searchLoan(loanNum);
                    if(ref!=null){
                        txtLoanType.setText(ref.getLoanTypeID());
                        txtLoanDuration.setText(Integer.toString(ref.getDuration()));
                        txtLoanIterestCharge.setText(Double.toString(ref.getInterestCharge()));
                        txtLoanAmount.setText(Double.toString(ref.getLoanAmount()));
                        txtMonthlyPayment.setText(Double.toString(ref.getMonthlyPayment()));
                        txtLoanDate.setText(ref.getStartDate());
                        txtPayDate.setText(ref.getPayDate());
                        txtLoanTotal.setText(Double.toString(ref.getTotal()));
                        txtCusID.setText(ref.getCusID());
                        txt1stGarenterID.setText(ref.getFirstGarenterID());
                        txt2ndGarenterID.setText(ref.getSecondGarenterID());
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LoanPaymentAndDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }

    @FXML
    private void makePayment(MouseEvent event) throws Exception {
        double oldTotal=Double.parseDouble(txtLoanTotal.getText());
        double amount=Double.parseDouble(txtPaymentAmount.getText());
        double newTotal=oldTotal-amount;
        
        txtPayTotal.setText(Double.toString(newTotal));
        
        String loanPayID=txtLoanPaymentID.getText();
        String loanNum=cmbLoanNumber.getValue();
        String paydate=txtLoanPayDate.getText();
        String payPersNIC=txtPayPersonID.getText();
        double payAmount=Double.parseDouble(txtPaymentAmount.getText());
        
        InstalmentpaymentDTO instalmentpaymentDTO=new InstalmentpaymentDTO(loanPayID, loanNum, paydate, payPersNIC, payAmount);
        
        boolean add=instalmentpaymentBO.addInstalmentpayment(instalmentpaymentDTO);
        
        boolean update=loanBO.updateLoan(new LoanDTO(
                cmbLoanNumber.getValue(), 
                txtCusID.getText(), 
                Double.parseDouble(txtLoanAmount.getText()), 
                txtLoanDate.getText(), 
                txt1stGarenterID.getText(), 
                txt2ndGarenterID.getText(), 
                txtLoanType.getText(), 
                Integer.parseInt(txtLoanDuration.getText()), 
                Double.parseDouble(txtLoanIterestCharge.getText()), 
                Double.parseDouble(txtMonthlyPayment.getText()),
                txtPayDate.getText(), 
                newTotal));
       
         if(update){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Loan Payment Successfully", ButtonType.OK);
            a.showAndWait();
        }
    }
    @FXML
    private void clearAll(MouseEvent event) {
        
    }
    
    private void loanNumLoader() throws ClassNotFoundException, IOException, Exception{
        String ids= IDGenarator.getNewID("instalmentpayment", "loanPayID", "LP");
        txtLoanPaymentID.setText(ids);
    }
    
    private void setDAteTime(){
        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                txtLoanPayDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }
}