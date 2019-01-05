/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.controller;

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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.student.bmgts.business.BOFactory;
import lk.ijse.student.bmgts.business.custom.AccountTypeBO;
import lk.ijse.student.bmgts.business.custom.CustomerAccountDetailsBO;
import lk.ijse.student.bmgts.business.custom.CustomerBO;
import lk.ijse.student.bmgts.commen.IDGenarator;
import lk.ijse.student.bmgts.model.AccountDTO;
import lk.ijse.student.bmgts.model.AccountTypeDTO;
import lk.ijse.student.bmgts.model.CommenDTO;
import lk.ijse.student.bmgts.model.CommensDTO;
import lk.ijse.student.bmgts.model.CustomerAccountDetailsDTO;
import lk.ijse.student.bmgts.model.CustomerDTO;

/** 
 * FXML Controller class
 *
 * @author Kasun
 */
public class OpenAccountController implements Initializable {

    private AccountTypeBO accSuperBO;
    @FXML
    private JFXTextField txtAccounType;
    @FXML
    private JFXTextField txt1stOwnerFirstName;
    @FXML
    private JFXTextField txt1stOwnerLastName;
    @FXML
    private JFXTextField txt1stOwnerAddress;
    @FXML
    private JFXTextField txt1stOwnerDOB;
    @FXML
    private JFXTextField txt1stOwnerNIC;
    @FXML
    private JFXTextField txt1stOwnerTell;
    @FXML
    private JFXRadioButton btn1stOwnerMale;
    @FXML
    private JFXRadioButton btn1stOwnerFemale;
    @FXML
    private JFXTextField txtAccNumber;
    @FXML
    private JFXComboBox<String> cmbAccTypeID;
    @FXML
    private TextField txtRate;
    @FXML
    private JFXTextField txtOpenTime;
    @FXML
    private JFXTextField txtOpenDate;
    @FXML
    private JFXTextField txt2ndOwnerFirstName;
    @FXML
    private JFXTextField txt2ndOwnerLastName;
    @FXML
    private JFXTextField txt2ndOwnerAddress;
    private JFXTextField txt2ndOwnerAge;
    @FXML
    private JFXTextField txt2ndOwnerDOB;
    @FXML
    private JFXTextField txt2ndOwnerNIC;
    @FXML
    private JFXTextField txt2ndOwnerTell;
    @FXML
    private JFXRadioButton btn2ndOwnerMale;
    @FXML
    private JFXRadioButton btn2ndOwnerFemale;
    @FXML
    private JFXTextField txt3rdOwnerFirstName;
    @FXML
    private JFXTextField txt3rdOwnerLastName;
    @FXML
    private JFXTextField txt3rdOwnerAddress;
    private JFXTextField txt3rdOwnerAge;
    @FXML
    private JFXTextField txt3rdOwnerDOB;
    @FXML
    private JFXTextField txt3rdOwnerNIC;
    @FXML
    private JFXTextField txt3rdOwnerTell;
    @FXML
    private JFXRadioButton btn3rdOwnerMale;
    @FXML
    private JFXRadioButton btn3rdOwnerFemale;
    
    private final ToggleGroup btnGroup1stOwner = new ToggleGroup();
    private final ToggleGroup btnGroup2ndOwner = new ToggleGroup();
    private final ToggleGroup btnGroup3rdOwner = new ToggleGroup();
    
    int countOfOwners;
    
    @FXML
    private Label lbl2ndOwnerGender;
    @FXML
    private Label lbl3rdOwnerGender;
    @FXML
    private JFXTextField txt1stOwnerID;
    @FXML
    private JFXTextField txt2ndOwnerID;
    @FXML
    private JFXTextField txt3rdOwnerID;
    @FXML
    private RadioButton rbtn1stNewCustomer;
    @FXML
    private RadioButton rbtn2ndNewCustomer;
    @FXML
    private RadioButton rbtn3rdNewCustomer;
    @FXML
    private JFXComboBox<String> cmb1stOwnerID;
    @FXML
    private JFXComboBox<String> cmb2ndOwnerID;
    @FXML
    private JFXComboBox<String> cmb3rdOwnerID;
    @FXML
    private JFXTextField txtAmount;
    private static CustomerBO customerBO;
    CustomerAccountDetailsBO customerAccountDetailsBO;
    @FXML
    private JFXTextField txtCusAccDeID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setbuttonGroup();
            customerBO=(CustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CUSTOMER);
            accSuperBO= (AccountTypeBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ACCOUNT_TYPE);
            customerAccountDetailsBO=(CustomerAccountDetailsBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CUSTOMERACCOUNTDETAILS);
            loadAccountTypeID();
            comboSelectEvent();
            setSelectRBTNEvent();
            cusAccDeIDLoader();
            customerIDLoader();
            accountIDLoader();
            setDAteTime();
            loadCustomerID();
            loadCustomersID();
        } catch (Exception ex) {
            Logger.getLogger(OpenAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setSelectRBTNEvent() throws Exception{
        rbtn1stNewCustomer.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(rbtn1stNewCustomer.isSelected()){
                    cmb1stOwnerID.setDisable(true);
                    txt1stOwnerID.setDisable(false);
                }else{
                    cmb1stOwnerID.setDisable(false);
                    txt1stOwnerID.setDisable(true);
                }
            }
            
        });
        
        rbtn2ndNewCustomer.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(rbtn2ndNewCustomer.isSelected()){
                    cmb2ndOwnerID.setDisable(true);
                }else{
                    cmb2ndOwnerID.setDisable(false);
                }
            }
            
        });
        
        
        rbtn3rdNewCustomer.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(rbtn3rdNewCustomer.isSelected()){
                    cmb3rdOwnerID.setDisable(true);
                }else{
                    cmb3rdOwnerID.setDisable(false);
                }
            }
            
        }); 
    }
    public void setbuttonGroup() throws Exception{
       btn1stOwnerMale.setToggleGroup(btnGroup1stOwner);
       btn1stOwnerFemale.setToggleGroup(btnGroup1stOwner);
       
       btn2ndOwnerMale.setToggleGroup(btnGroup2ndOwner);
       btn2ndOwnerFemale.setToggleGroup(btnGroup2ndOwner);
       
       btn3rdOwnerMale.setToggleGroup(btnGroup3rdOwner);
       btn3rdOwnerFemale.setToggleGroup(btnGroup3rdOwner);
       
       
    }

    @FXML
    private void createAccount(MouseEvent event) throws Exception{
        
        String firstOwnerGender;
        if(btn1stOwnerMale.isSelected()){
            firstOwnerGender="Male";
        }else{
           firstOwnerGender="Female"; 
        }
        
        String amount=txtAmount.getText();
        if(amount.matches("[0-9]{3,7}[.]\\d{2}")){
            txt1stOwnerFirstName.requestFocus();
            String firstName=txt1stOwnerFirstName.getText();
            if(firstName.matches("[A-Za-z]{3,30}")){
                txt1stOwnerLastName.requestFocus();
                String lastName=txt1stOwnerLastName.getText();
                if(lastName.matches("[A-Za-z]{3,30}")){
                    txt1stOwnerAddress.requestFocus();
                    String addr=txt1stOwnerAddress.getText();
                    if(addr.matches("[A-Z0-9]{10,20}")){
                        txt1stOwnerDOB.requestFocus();
                        String dob=txt1stOwnerDOB.getText();
                        if(dob.matches("\\d{4}\\-\\d{2}\\-\\d{2}")){
                            txt1stOwnerNIC.requestFocus();
                            String nic=txt1stOwnerNIC.getText();
                            if(nic.matches("\\d{9}[vV]")){
                                txt1stOwnerTell.requestFocus();
                                String tell=txt1stOwnerTell.getText();
                                if(tell.matches("[0-9]{10}")){
                                    
                                    if(rbtn1stNewCustomer.isSelected()){
            
                                        CustomerDTO cdto=new CustomerDTO(
                                                txt1stOwnerID.getText(), 
                                                txt1stOwnerFirstName.getText(), 
                                                txt1stOwnerLastName.getText(),
                                                txt1stOwnerAddress.getText(), 
                                                "1st Ownner", 
                                                txt1stOwnerDOB.getText(), 
                                                txt1stOwnerNIC.getText(), 
                                                firstOwnerGender, 
                                                txt1stOwnerTell.getText());

                                        AccountDTO accountDTO=new AccountDTO(
                                                txtAccNumber.getText(), 
                                                txtOpenDate.getText(), 
                                                txtOpenTime.getText(), 
                                                cmbAccTypeID.getValue(), 
                                                Double.parseDouble(txtAmount.getText()),
                                                txt1stOwnerNIC.getText());

                                        CustomerAccountDetailsDTO customerAccountDetailsDTO=new CustomerAccountDetailsDTO(
                                                txtCusAccDeID.getText(), 
                                                txt1stOwnerID.getText(), 
                                                txtAccNumber.getText());

                                        CommenDTO commenDTO=new CommenDTO(cdto, accountDTO, customerAccountDetailsDTO);
                                        boolean addCustomerWithAccount = customerAccountDetailsBO.addCustomerWithAccount(commenDTO);
                                        if(addCustomerWithAccount){
                                        Alert alert=new Alert(Alert.AlertType.INFORMATION, "Adedd new Customer", ButtonType.OK);
                                        alert.showAndWait();
                                        }else{
                                        Alert alert=new Alert(Alert.AlertType.ERROR, "Adedd UnsucsessFull Customer", ButtonType.OK);
                                        alert.showAndWait();
                                        }

                                    }else{
                                        AccountDTO accountDTO=new AccountDTO(
                                                txtAccNumber.getText(), 
                                                txtOpenDate.getText(), 
                                                txtOpenTime.getText(), 
                                                cmbAccTypeID.getValue(), 
                                                Double.parseDouble(txtAmount.getText()),
                                                txt1stOwnerNIC.getText()
                                        );

                                        CustomerAccountDetailsDTO customerAccountDetailsDTO=new CustomerAccountDetailsDTO(
                                                txtCusAccDeID.getText(), 
                                                cmb1stOwnerID.getValue(), 
                                                txtAccNumber.getText()
                                        );

                                        CommensDTO commenDTO=new CommensDTO(accountDTO, customerAccountDetailsDTO);
                                        boolean addCustomerWithAccount = customerAccountDetailsBO.addCustomerWithAccounts(commenDTO);
                                        if(addCustomerWithAccount){
                                            Alert a=new Alert(Alert.AlertType.INFORMATION, "Aded sucsessFull", ButtonType.OK);
                                            a.showAndWait();
                                        }else{
                                            Alert a=new Alert(Alert.AlertType.ERROR, "Aded UnsucsessFull", ButtonType.OK);
                                            a.showAndWait();

                                        }
                                    }
                                    
                                    cusAccDeIDLoader();
                                    customerIDLoader();
                                    accountIDLoader();
                                    loadCustomersID();
                                    comboSelectEvent();
                                    clearAll();
                                    
                                }else{
                                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Check Tell Number, Somthing Mistake", ButtonType.OK);
                                    a.showAndWait();
                                }
                            }else{
                                Alert a = new Alert(Alert.AlertType.INFORMATION, "Check NIC Number, Somthing Mistake", ButtonType.OK);
                                a.showAndWait();
                            }
                        }else{
                            Alert a = new Alert(Alert.AlertType.INFORMATION, "Check Date of Birth, Somthing Mistake", ButtonType.OK);
                            a.showAndWait();
                        }
                    }else{
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Check Address, Somthing Mistake", ButtonType.OK);
                        a.showAndWait();
                    }
                    
                }else{
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Check Last Name, Somthing Mistake", ButtonType.OK);
                                a.showAndWait();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Check First Name, Somthing Mistake", ButtonType.OK);
                a.showAndWait();
            }
        }else{
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Check Amount, Somthing Mistake", ButtonType.OK);
            a.showAndWait();
        }
        
        
    }
    
    private void loadCustomerID()throws Exception{
        ArrayList<String> customerID=customerBO.getAllCustomerID();
        cmb1stOwnerID.getItems().clear();
        for(String id:customerID){
            cmb1stOwnerID.getItems().add(id);
        }
    }
    
    public void loadAccountTypeID() throws Exception{
        ArrayList<String> accountTypeDTOs= accSuperBO.getAllAccountTypeID();
        cmbAccTypeID.getItems().clear();
        for(String id:accountTypeDTOs){
            cmbAccTypeID.getItems().add(id);
        }
    }
    
    private void comboSelectEvent()throws Exception{
        cmbAccTypeID.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                
                try {
                    String AccTypeID= cmbAccTypeID.getValue();
                    AccountTypeDTO ref= accSuperBO.searchAccountType(AccTypeID);
                    if(ref!=null){
                        
                        txtAccounType.setText(ref.getAccType());
                        txtRate.setText(Double.toString(ref.getRate()));
                        double minAmouOf1stDep=ref.getMinAmouOf1stDep();
                        countOfOwners=ref.getCountOfOwners();
                        setDisabletext();

                    }       } catch (Exception ex) {
                    Logger.getLogger(OpenAccountController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        
    }
    
    private void setDisabletext(){
        
        if(countOfOwners==1){
            
            rbtn2ndNewCustomer.setDisable(true);
            cmb2ndOwnerID.setDisable(true);
            txt2ndOwnerID.setDisable(true);
            txt2ndOwnerFirstName.setDisable(true);
            txt2ndOwnerLastName.setDisable(true);
            txt2ndOwnerAddress.setDisable(true);
            txt2ndOwnerDOB.setDisable(true);
            txt2ndOwnerNIC.setDisable(true);
            txt2ndOwnerTell.setDisable(true);
            btn2ndOwnerMale.setDisable(true);
            btn2ndOwnerFemale.setDisable(true);
            lbl2ndOwnerGender.setDisable(true);
                            
            rbtn3rdNewCustomer.setDisable(true);
            cmb3rdOwnerID.setDisable(true);
            txt3rdOwnerID.setDisable(true);
            txt3rdOwnerFirstName.setDisable(true);
            txt3rdOwnerLastName.setDisable(true);
            txt3rdOwnerAddress.setDisable(true);
            txt3rdOwnerDOB.setDisable(true);
            txt3rdOwnerNIC.setDisable(true);
            txt3rdOwnerTell.setDisable(true);
            btn3rdOwnerMale.setDisable(true);
            btn3rdOwnerFemale.setDisable(true);
            lbl3rdOwnerGender.setDisable(true);
                            
        }if(countOfOwners==2){
            
            rbtn2ndNewCustomer.setDisable(false);
            cmb2ndOwnerID.setDisable(false);
            txt2ndOwnerID.setDisable(false);
            txt2ndOwnerFirstName.setDisable(false);
            txt2ndOwnerLastName.setDisable(false);
            txt2ndOwnerAddress.setDisable(false);
            txt2ndOwnerDOB.setDisable(false);
            txt2ndOwnerNIC.setDisable(false);
            txt2ndOwnerTell.setDisable(false);
            btn2ndOwnerMale.setDisable(false);
            btn2ndOwnerFemale.setDisable(false);
            lbl2ndOwnerGender.setDisable(false);
                            
            rbtn3rdNewCustomer.setDisable(true);
            cmb3rdOwnerID.setDisable(true);
            txt3rdOwnerID.setDisable(true);
            txt3rdOwnerFirstName.setDisable(true);
            txt3rdOwnerLastName.setDisable(true);
            txt3rdOwnerAddress.setDisable(true);
            txt3rdOwnerDOB.setDisable(true);
            txt3rdOwnerNIC.setDisable(true);
            txt3rdOwnerTell.setDisable(true);
            btn3rdOwnerMale.setDisable(true);
            btn3rdOwnerFemale.setDisable(true);
            lbl3rdOwnerGender.setDisable(true);
        
        }if(countOfOwners==3){
            
            rbtn2ndNewCustomer.setDisable(false);
            cmb2ndOwnerID.setDisable(false);
            txt2ndOwnerID.setDisable(false);
            txt2ndOwnerFirstName.setDisable(false);
            txt2ndOwnerLastName.setDisable(false);
            txt2ndOwnerAddress.setDisable(false);
            txt2ndOwnerDOB.setDisable(false);
            txt2ndOwnerNIC.setDisable(false);
            txt2ndOwnerTell.setDisable(false);
            btn2ndOwnerMale.setDisable(false);
            btn2ndOwnerFemale.setDisable(false);
            lbl2ndOwnerGender.setDisable(false);
                            
            rbtn3rdNewCustomer.setDisable(false);
            cmb3rdOwnerID.setDisable(false);
            txt3rdOwnerID.setDisable(false);
            txt3rdOwnerFirstName.setDisable(false);
            txt3rdOwnerLastName.setDisable(false);
            txt3rdOwnerAddress.setDisable(false);
            txt3rdOwnerDOB.setDisable(false);
            txt3rdOwnerNIC.setDisable(false);
            txt3rdOwnerTell.setDisable(false);
            btn3rdOwnerMale.setDisable(false);
            btn3rdOwnerFemale.setDisable(false);
            lbl3rdOwnerGender.setDisable(false);
        }      
    }
    private void cusAccDeIDLoader() throws ClassNotFoundException, IOException, Exception{
    
        String id= IDGenarator.getNewID("cusaccDetails", "cusAccDetailsID", "aa");
        txtCusAccDeID.setText(id);
    }

    private void accountIDLoader() throws ClassNotFoundException, IOException, Exception{
    
        String id= IDGenarator.getNewID("account", "accNum", "0045-");
        txtAccNumber.setText(id);
    }
        
    private void customerIDLoader() throws ClassNotFoundException, IOException, Exception{
    
        String id= IDGenarator.getNewID("customer", "cusID", "C");
        txt1stOwnerID.setText(id);
    }
    
      private void setDAteTime(){
        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                txtOpenDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                txtOpenTime.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }
      
    private void clearAll(){
        txtAmount.clear();
        txt1stOwnerFirstName.clear();
        txt1stOwnerLastName.clear();
        txt1stOwnerAddress.clear();
        txt1stOwnerNIC.clear();
        txt1stOwnerTell.clear();
        txt1stOwnerDOB.clear();
    }

    @FXML
    private void isClearAll(MouseEvent event) throws Exception{
        clearAll();
        comboSelectEvent();
        loadCustomersID();
    }
    
        private void loadCustomersID()throws Exception{
        cmb1stOwnerID.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    String cusID=cmb1stOwnerID.getValue();
                    CustomerDTO ref=customerBO.searchCustomer(cusID);
                    if(ref!=null){
                        txt1stOwnerFirstName.setText(ref.getFirstName());
                        txt1stOwnerLastName.setText(ref.getLastName());
                        txt1stOwnerAddress.setText(ref.getAddress());
                        txt1stOwnerNIC.setText(ref.getNic());
                        txt1stOwnerTell.setText(ref.getTell());
                        txt1stOwnerDOB.setText(ref.getDob());
                        
                    }
                } catch (Exception ex) {
                    Logger.getLogger(OpenAccountController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}