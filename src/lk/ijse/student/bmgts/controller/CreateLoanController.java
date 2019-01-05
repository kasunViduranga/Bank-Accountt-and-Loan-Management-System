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
import lk.ijse.student.bmgts.business.custom.CustomerBO;
import lk.ijse.student.bmgts.business.custom.GarenterBO;
import lk.ijse.student.bmgts.business.custom.LoanBO;
import lk.ijse.student.bmgts.business.custom.LoanTypeBO;
import lk.ijse.student.bmgts.commen.IDGenarator;
import lk.ijse.student.bmgts.model.CustomerDTO;
import lk.ijse.student.bmgts.model.GarenterDTO;
import lk.ijse.student.bmgts.model.LoanDTO;
import lk.ijse.student.bmgts.model.LoanTypeDTO;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class CreateLoanController implements Initializable {

    @FXML
    private JFXTextField txtFirstName;
    @FXML
    private JFXTextField txtLoanNumber;
    @FXML
    private JFXTextField txtCustomerAddress;
    @FXML
    private JFXTextField txtLoanDuration;
    @FXML
    private JFXTextField txtLoanIterestCharge;
    @FXML
    private JFXTextField txtLoanAmount;
    @FXML
    private JFXTextField txtMonthlyPayment;
    @FXML
    private JFXComboBox<String> cmbLoanTypeID;
    @FXML
    private JFXTextField txtLastName;
    @FXML
    private JFXTextField txt1stGarenterFirstName;
    @FXML
    private JFXTextField txt1stGarenterAddress;
    @FXML
    private JFXTextField txt1stGarenterHometell;
    @FXML
    private JFXTextField txt1stGarenterDOB;
    @FXML
    private JFXTextField txt1stGarenterNIC;
    @FXML
    private JFXRadioButton cmb1stGarenterMale;
    @FXML
    private JFXRadioButton cmb1stGarenterfemaie;
    @FXML
    private JFXTextField txt1stGarenterLastName;
    @FXML
    private JFXTextField txt1stGarenterJob;
    @FXML
    private JFXTextField txt1stGarentermonthSalary;
    @FXML
    private JFXTextField txt1stGarenterPaysheetNember;
    @FXML
    private JFXTextField txt1stGarenterMobileNumber;
    @FXML
    private JFXTextField txtLoanDate;
    @FXML
    private JFXComboBox<String> cmbCustomerID;
    @FXML
    private JFXTextField txt1stGarenterID;
    @FXML
    private JFXTextField txt2ndGarenterFirstName;
    @FXML
    private JFXTextField txt2ndGarenterAddress;
    @FXML
    private JFXTextField txt2ndGarenterHomeTell;
    @FXML
    private JFXTextField txt2ndGarenterDOB;
    @FXML
    private JFXTextField txt2ndGarenterNIC;
    @FXML
    private JFXRadioButton cmb2ndGarenterMale;
    @FXML
    private JFXRadioButton cmb2ndGarenterfemale;
    @FXML
    private JFXTextField txt2ndGarenterLastName;
    @FXML
    private JFXTextField txt2ndGarenterJob;
    @FXML
    private JFXTextField txt2ndGarenterMonthSalary;
    @FXML
    private JFXTextField txt2ndGarenterPaysheetNumber;
    @FXML
    private JFXTextField txt2ndGarenterMobileNumber;
    @FXML
    private JFXTextField txt2ndGarenterID;
    
    private GarenterBO GarenterSuperBO;
    private CustomerBO customerBO;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtTell;
    @FXML
    private JFXTextField txtDOB;
    @FXML
    private JFXTextField txtPayDate;
    private LoanTypeBO loanTypeBO;
    @FXML
    private JFXTextField txtLoanType;
    private LoanBO loanBO;
    private final ToggleGroup btnGroup1stGarenter = new ToggleGroup();
    private final ToggleGroup btnGroup2ndGarenter = new ToggleGroup();
    @FXML
    private JFXTextField txtLoanTotal;
    @FXML
    private JFXButton btnCreateLoan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            GarenterSuperBO = (GarenterBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.GARENTER);
            customerBO=(CustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CUSTOMER);
            loanTypeBO=(LoanTypeBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.LOAN_TYPE);
            loanBO=(LoanBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.LOAN);
            loadCustomerID();
            loadCustomersID();
            setDAteTime();
            loadLoanTypeID();
            loanTypeCombeEvent();
            groupButton();
            loanNumLoader();
            btnCreateLoan.setDisable(true);
        } catch (Exception ex) {
            Logger.getLogger(CreateLoanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void isCreateLoan(MouseEvent event) throws Exception {
    
        String gender1stGarenter;
        String gender2ndGarenter;
        if(cmb1stGarenterMale.isSelected()){
            gender1stGarenter="Male";
        }else{
            gender1stGarenter="Female";
        }
        if(cmb2ndGarenterMale.isSelected()){
            gender2ndGarenter="Male";
        }else{
            gender2ndGarenter="Female";
        }
        
        
        GarenterDTO garenterDTO1=new GarenterDTO(
                txt1stGarenterID.getText(), 
                txt1stGarenterFirstName.getText(), 
                txt1stGarenterLastName.getText(), 
                txt1stGarenterAddress.getText(), 
                txt1stGarenterNIC.getText(), 
                txt1stGarenterDOB.getText(), 
                txt1stGarenterMobileNumber.getText(), 
                txt1stGarenterHometell.getText(), 
                gender1stGarenter, 
                txt1stGarenterJob.getText(), 
                Double.parseDouble(txt1stGarentermonthSalary.getText()), 
                txt1stGarenterPaysheetNember.getText());
        
        boolean add1st=GarenterSuperBO.addGarente(garenterDTO1);
        
        GarenterDTO garenterDTO2=new GarenterDTO(
                txt2ndGarenterID.getText(), 
                txt2ndGarenterFirstName.getText(), 
                txt2ndGarenterLastName.getText(), 
                txt2ndGarenterAddress.getText(), 
                txt2ndGarenterNIC.getText(), 
                txt2ndGarenterDOB.getText(), 
                txt2ndGarenterMobileNumber.getText(), 
                txt2ndGarenterHomeTell.getText(), 
                gender2ndGarenter, 
                txt2ndGarenterJob.getText(), 
                Double.parseDouble(txt2ndGarenterMonthSalary.getText()), 
                txt2ndGarenterPaysheetNumber.getText());
        
        boolean add2nd=GarenterSuperBO.addGarente(garenterDTO2);
        
        LoanDTO loanDTO=new LoanDTO(
                txtLoanNumber.getText(), 
                cmbCustomerID.getValue(), 
                Double.parseDouble(txtLoanAmount.getText()), 
                txtLoanDate.getText(), 
                txt1stGarenterID.getText(), 
                txt2ndGarenterID.getText(), 
                cmbLoanTypeID.getValue(), 
                Integer.parseInt(txtLoanDuration.getText()), 
                Double.parseDouble(txtLoanIterestCharge.getText()), 
                Double.parseDouble(txtMonthlyPayment.getText()), 
                txtPayDate.getText(),
                Double.parseDouble(txtLoanTotal.getText()));
        
        boolean addLoan=loanBO.addLoan(loanDTO);
        if(addLoan){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Create Loan Successfully", ButtonType.OK);
            a.showAndWait();
        }
        loanNumLoader();
        btnCreateLoan.setDisable(true);
        clearAll();
    
    }

    @FXML
    private void isClearAll(MouseEvent event) {
        clearAll();
    }

 
    
    private void loadCustomerID()throws Exception{
        ArrayList<String> customerID=customerBO.getAllCustomerID();
        cmbCustomerID.getItems().clear();
        for(String id:customerID){
            cmbCustomerID.getItems().add(id);
        }
    }
    
    private void loadLoanTypeID() throws Exception{
        ArrayList<String> loanTypeID=loanTypeBO.getAllLoanTypeID();
        cmbLoanTypeID.getItems().clear();
        for(String id:loanTypeID){
            cmbLoanTypeID.getItems().add(id);
        }
        
    }
        
    private void loadCustomersID()throws Exception{
        cmbCustomerID.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    String cusID=cmbCustomerID.getValue();
                    CustomerDTO ref=customerBO.searchCustomer(cusID);
                    if(ref!=null){
                        txtFirstName.setText(ref.getFirstName());
                        txtLastName.setText(ref.getLastName());
                        txtCustomerAddress.setText(ref.getAddress());
                        txtNIC.setText(ref.getNic());
                        txtTell.setText(ref.getTell());
                        txtDOB.setText(ref.getDob());
                        
                    }
                } catch (Exception ex) {
                    Logger.getLogger(OpenAccountController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
    }
    private void loanTypeCombeEvent() throws Exception{
        cmbLoanTypeID.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    String loanTypeID=cmbLoanTypeID.getValue();
                    LoanTypeDTO ref=loanTypeBO.searchLoanType(loanTypeID);
                    if(ref!=null){
                        txtLoanType.setText(ref.getLoanType());
                        txtLoanDuration.setText(Integer.toString(ref.getDuration()));
                        txtLoanIterestCharge.setText(Double.toString(ref.getRateCharge()));
                        txtLoanAmount.setText(Double.toString(ref.getMaxAmount()));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CreateLoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
    }
    
      private void setDAteTime(){
        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                txtLoanDate.setText(new SimpleDateFormat("YYYY.MM.dd").format(new Date()));
//                txtOpenTime.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }

    @FXML
    private void isCalculate(MouseEvent event) {
        double amount=Double.parseDouble(txtLoanAmount.getText());
        double rate=Double.parseDouble(txtLoanIterestCharge.getText());
        int duration=Integer.parseInt(txtLoanDuration.getText());
        Double total=((amount/100*rate)*duration)+amount;
        
        txtLoanTotal.setText(Double.toString(total));
        double monthPay=total/duration;
        txtMonthlyPayment.setText(Double.toString(monthPay));
        btnCreateLoan.setDisable(false);
        
    }
    
    private void groupButton(){
        cmb1stGarenterMale.setToggleGroup(btnGroup1stGarenter);
        cmb1stGarenterfemaie.setToggleGroup(btnGroup1stGarenter);
        
        cmb2ndGarenterMale.setToggleGroup(btnGroup2ndGarenter);
        cmb2ndGarenterfemale.setToggleGroup(btnGroup2ndGarenter);
    }
    
    private void loanNumLoader() throws ClassNotFoundException, IOException, Exception{
        String ids= IDGenarator.getNewID("loan", "loanNum", "LO0045-");
        txtLoanNumber.setText(ids);
    }
    private void clearAll(){
        txt1stGarenterID.clear();
        txt1stGarenterFirstName.clear();
        txt1stGarenterLastName.clear();
        txt1stGarenterAddress.clear();
        txt1stGarenterNIC.clear();
        txt1stGarenterDOB.clear();
        txt1stGarenterMobileNumber.clear();
        txt1stGarenterHometell.clear();
        txt1stGarenterJob.clear();
        txt1stGarentermonthSalary.clear();
        txt1stGarenterPaysheetNember.clear();
        
        txt2ndGarenterID.clear();
        txt2ndGarenterFirstName.clear();
        txt2ndGarenterLastName.clear();
        txt2ndGarenterAddress.clear();
        txt2ndGarenterNIC.clear();
        txt2ndGarenterDOB.clear();
        txt2ndGarenterMobileNumber.clear();
        txt2ndGarenterHomeTell.clear();
        txt2ndGarenterJob.clear();
        txt2ndGarenterMonthSalary.clear();
        txt2ndGarenterPaysheetNumber.clear();
        
        txtMonthlyPayment.clear();
        txtLoanTotal.clear();
        txtPayDate.clear();
    }
}