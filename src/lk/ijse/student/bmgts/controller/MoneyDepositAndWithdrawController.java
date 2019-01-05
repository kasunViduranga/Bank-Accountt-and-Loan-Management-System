/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.student.bmgts.business.BOFactory;
import lk.ijse.student.bmgts.business.custom.AccountBO;
import lk.ijse.student.bmgts.business.custom.TransactionBO;
import lk.ijse.student.bmgts.commen.IDGenarator;
import lk.ijse.student.bmgts.model.AccountDTO;
import lk.ijse.student.bmgts.model.TransactionDTO;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class MoneyDepositAndWithdrawController implements Initializable {

    @FXML
    private JFXRadioButton rbtnDeposite;
    @FXML
    private JFXRadioButton rbtnWithdraw;
    @FXML
    private JFXComboBox<String> cmbAccNumber;
    @FXML
    private JFXTextField txtTotal;
    @FXML
    private JFXTextField txtDate;
    @FXML
    private JFXTextField txtTime;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnClear;
    
    private AccountBO accountBO;
    private final ToggleGroup btnGroup = new ToggleGroup();
    @FXML
    private JFXTextField txtTRID;
    private TransactionBO transactionBO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            accountBO=(AccountBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ACCOUNT);
            transactionBO=(TransactionBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.Transaction);
            loadAccNumCMB();
            comboEvent();
            setDAteTime();
            setbuttonGroup();
            loanTypeIDLoader();
        } catch (Exception ex) {
            Logger.getLogger(MoneyDepositAndWithdrawController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    @FXML
    private void clearLoanDetails(MouseEvent event) throws Exception{
        
        txtNIC.clear();
        txtTotal.clear();
        txtAmount.clear();
        txtTRID.clear();
        
        loanTypeIDLoader();
    }
    
    private void loadAccNumCMB() throws Exception{
        ArrayList<String> accountDTOs= accountBO.getAllAccountNumber();
        cmbAccNumber.getItems().clear();
        for(String id:accountDTOs){
            cmbAccNumber.getItems().add(id);
        }
    }
    
    private void comboEvent() throws Exception{
        cmbAccNumber.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    String accNumber=cmbAccNumber.getValue();
                    AccountDTO ref=accountBO.searchAccount(accNumber);
                    if(ref!=null){
                       
                        txtNIC.setText(ref.getNic());
                        txtTotal.setText(Double.toString(ref.getTotal()));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(MoneyDepositAndWithdrawController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
     private void setDAteTime(){
        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                txtDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                txtTime.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }
     
    public void setbuttonGroup() throws Exception{
       rbtnDeposite.setToggleGroup(btnGroup);
       rbtnWithdraw.setToggleGroup(btnGroup);
    }
    private void loanTypeIDLoader() throws ClassNotFoundException, IOException, Exception{
        String ids= IDGenarator.getNewID("transaction", "tranId", "TR");
        txtTRID.setText(ids);
    }

    @FXML
    private void saveTransaction(MouseEvent event) throws Exception{
        
        double oldTotal=Double.parseDouble(txtTotal.getText());
        double amount=Double.parseDouble(txtAmount.getText());
        double depositNewTotal;
        double withNewTotal;
        
        if(rbtnWithdraw.isSelected()){
            if(oldTotal>amount){
                withNewTotal=oldTotal-amount;
                txtTotal.setText(Double.toString(withNewTotal));
                
                TransactionDTO transactionDTO=new TransactionDTO(txtTRID.getText(), "Withdraw", cmbAccNumber.getValue(), 
                        Double.parseDouble(txtAmount.getText()), txtDate.getText(), txtTime.getText(), txtNIC.getText());
                boolean isSucces=transactionBO.addTransaction(transactionDTO);
                
                isSucces=accountBO.updateAccount(new AccountDTO(cmbAccNumber.getValue(), withNewTotal));
                
                if(isSucces){
                    Alert aa = new Alert(Alert.AlertType.INFORMATION, "Withdraw is Succesful", ButtonType.OK);
                    aa.showAndWait();
                }else{
                    Alert aa = new Alert(Alert.AlertType.INFORMATION, "Withdraw is Not Succes", ButtonType.OK);
                    aa.showAndWait();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.INFORMATION, "ballence is Low, Transaction is Not sucess", ButtonType.OK);
                a.showAndWait();
            }
        }
            
        if(rbtnDeposite.isSelected()){
            depositNewTotal=oldTotal+amount;
            txtTotal.setText(Double.toString(depositNewTotal));
            
            TransactionDTO transactionDTO=new TransactionDTO(txtTRID.getText(), "Diposite", cmbAccNumber.getValue(), 
                        Double.parseDouble(txtAmount.getText()), txtDate.getText(), txtTime.getText(), txtNIC.getText());
                boolean isSucces=transactionBO.addTransaction(transactionDTO);
                
                isSucces=accountBO.updateAccount(new AccountDTO(cmbAccNumber.getValue(), depositNewTotal));
                
                if(isSucces){
                    Alert aa = new Alert(Alert.AlertType.INFORMATION, "Deposit is Succesful", ButtonType.OK);
                    aa.showAndWait();
                }else{
                    Alert aa = new Alert(Alert.AlertType.INFORMATION, "Deposite is Not Succes", ButtonType.OK);
                    aa.showAndWait();
                }
        }
       
        loanTypeIDLoader();
    }
}
