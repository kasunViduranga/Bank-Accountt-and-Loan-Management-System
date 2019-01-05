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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.student.bmgts.business.BOFactory;
import lk.ijse.student.bmgts.business.custom.AccountTypeBO;
import lk.ijse.student.bmgts.business.custom.LoanTypeBO;
import lk.ijse.student.bmgts.commen.IDGenarator;
import lk.ijse.student.bmgts.model.AccountTypeDTO;
import lk.ijse.student.bmgts.model.LoanTypeDTO;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class LoanAndAccSettingController implements Initializable {

    @FXML
    private JFXTextField txtLoanID;
    @FXML
    private JFXTextField txtLoanType;
    @FXML
    private JFXTextField txtInterestCharge;
    @FXML
    private JFXTextField txtDuration;
    @FXML
    private JFXTextField txtMaxAmount;
    @FXML
    private JFXTextField txtAccID;
    @FXML
    private JFXTextField txtAccType;
    @FXML
    private JFXTextField txtInterest;
    @FXML
    private TableView<LoanTypeDTO> loanDetailsTable;
    @FXML
    private JFXTextField txtMinAmouOf1stDep;
    @FXML
    private JFXTextField txtMinMonthSalary;
    @FXML
    private JFXComboBox<String> cmbCountOfOwners;
    @FXML
    private TableView<AccountTypeDTO> accDetailsTable;
    
    
    
    private AccountTypeBO accSuperBO;
    private LoanTypeBO loanSuperBO;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            steComboBoxValues();
            accSuperBO=(AccountTypeBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ACCOUNT_TYPE);
            loanSuperBO = (LoanTypeBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.LOAN_TYPE);
            loadAllAccTypeTOTable ();
            loadAllLoanTypeToTable ();
            loadAccDetailsTableToTXT();
            loadLoanTypeDetailsTableToTXT();
            accountTypeIDLoader();
            loanTypeIDLoader();
        } catch (Exception ex) {
            Logger.getLogger(LoanAndAccSettingController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @FXML
    private void updateLoanType(MouseEvent event)throws Exception{
        
        boolean update=loanSuperBO.updateLoanType(new LoanTypeDTO(txtLoanID.getText(), 
            txtLoanType.getText(), Integer.parseInt(txtDuration.getText()), 
            Double.parseDouble(txtInterestCharge.getText()), Double.parseDouble(txtMaxAmount.getText()), Double.parseDouble(txtMinMonthSalary.getText())));
            
        if(update){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Updated !", ButtonType.OK);
            a.showAndWait();
        }
        
    }

    @FXML
    private void saveLoanType(MouseEvent event) throws Exception{
        
        String loanTypeID= txtLoanID.getText();
        String loanType= txtLoanType.getText();
        int duration= Integer.parseInt(txtDuration.getText());
        double rateCharge= Double.parseDouble(txtInterestCharge.getText());
        double maxAmount= Double.parseDouble(txtMaxAmount.getText());
        double minMonthSalary= Double.parseDouble(txtMinMonthSalary.getText());
        
        LoanTypeDTO loanTpeDTO=new LoanTypeDTO(loanTypeID, loanType, duration, rateCharge, maxAmount, minMonthSalary);
        
        
        boolean addLoanType= loanSuperBO.addLoanType(loanTpeDTO);
        
        if (addLoanType) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Added Successfully", ButtonType.OK);
            a.showAndWait();
            clearLoanType();
            loadAllLoanTypeToTable ();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Added Failed", ButtonType.OK);
            a.showAndWait();
        }
    }

    @FXML
    private void searchLoanType(MouseEvent event) throws Exception {
        String loanTypeID= txtLoanID.getText();
        LoanTypeDTO ref=loanSuperBO.searchLoanType(loanTypeID);
       if(ref!=null){
           txtLoanID.setText(ref.getLoanTypeID());
           txtLoanType.setText(ref.getLoanType());
           txtDuration.setText(Integer.toString(ref.getDuration()));
           txtInterestCharge.setText(Double.toString(ref.getRateCharge()));
           txtMaxAmount.setText(Double.toString(ref.getMaxAmount()));
           txtMinMonthSalary.setText(Double.toString(ref.getMinMonthSalary()));
       }
        
    }

    @FXML
    private void deleteLoanType(MouseEvent event) throws Exception {
        String loanTypeID= txtLoanID.getText();
        boolean isDelete=loanSuperBO.deleteLoanType(loanTypeID);
         if (isDelete) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Delete Successfully", ButtonType.OK);
            a.showAndWait();
            loadAllLoanTypeToTable ();
            clearLoanType();
            
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Delete Failed", ButtonType.OK);
            a.showAndWait();
        }
    }

    @FXML
    private void updateAccountType(MouseEvent event) throws Exception{
        String  accTypeID= txtAccID.getText();
        String accType= txtAccType.getText();
        double rate= Double.parseDouble(txtInterest.getText());
        double minAmouOf1stDep= Double.parseDouble(txtMinAmouOf1stDep.getText());
        int countOfOwners=Integer.parseInt(cmbCountOfOwners.getValue());
        
        AccountTypeDTO accountTypaDTO= new AccountTypeDTO(accTypeID, accType, rate, minAmouOf1stDep, countOfOwners);
        boolean isUpdate=accSuperBO.updateAccountType(accountTypaDTO);
       
        if (isUpdate) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Update Successfully", ButtonType.OK);
            a.showAndWait();
            clearAccType();
            loadAllLoanTypeToTable ();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Update Failed", ButtonType.OK);
            a.showAndWait();
        }
    }

    @FXML
    private void saveAccountType(MouseEvent event) throws Exception{
        
        
        String  accTypeID= txtAccID.getText();
        String accType= txtAccType.getText();
        double rate= Double.parseDouble(txtInterest.getText());
        double minAmouOf1stDep= Double.parseDouble(txtMinAmouOf1stDep.getText());
        int countOfOwners=Integer.parseInt(cmbCountOfOwners.getValue());
        
        AccountTypeDTO accTypeDTO= new AccountTypeDTO(accTypeID, accType, rate, minAmouOf1stDep,countOfOwners);
        
        boolean addAccountType = accSuperBO.addAccountType(accTypeDTO);
        if (addAccountType) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Added Successfully", ButtonType.OK);
            a.showAndWait();
            loadAllAccTypeTOTable ();
            clearAccType();
            
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Added Failed", ButtonType.OK);
            a.showAndWait();
        }
    }

    @FXML
    private void searchAccountType(MouseEvent event) throws Exception {
        String AccTypeID= txtAccID.getText();
        AccountTypeDTO ref= accSuperBO.searchAccountType(AccTypeID);
        if(ref!=null){
            txtAccID.setText(ref.getAccTypeID());
            txtAccType.setText(ref.getAccType());
            txtInterest.setText(Double.toString(ref.getRate()));
            txtMinAmouOf1stDep.setText(Double.toString(ref.getMinAmouOf1stDep()));
            cmbCountOfOwners.setValue(Integer.toString(ref.getCountOfOwners())); 
        }
        
    }

    @FXML
    private void deleteAccountType(MouseEvent event) throws Exception{
        String ACCTypeID= txtAccID.getText();
        boolean isDelete= accSuperBO.deleteAccountType(ACCTypeID);
        if (isDelete) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Delete Successfully", ButtonType.OK);
            a.showAndWait();
            loadAllAccTypeTOTable();
            clearAccType();
            
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Delete Failed", ButtonType.OK);
            a.showAndWait();
        }
        
        
    }

    private void steComboBoxValues(){
        cmbCountOfOwners.getItems().addAll("01", "02", "03");
    }
    
    public void loadAllAccTypeTOTable () throws Exception{
        accDetailsTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("accTypeID"));
        accDetailsTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("accType"));
        accDetailsTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("rate"));
        accDetailsTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("minAmouOf1stDep"));
        accDetailsTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("CountOfOwners"));
       
        accDetailsTable.setItems(FXCollections.observableArrayList(accSuperBO.getAllAccountType()));
       
        accountTypeIDLoader();
    }
    
    private void loadAccDetailsTableToTXT () throws Exception{
        
        accDetailsTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends AccountTypeDTO> observable, AccountTypeDTO oldValue, AccountTypeDTO newValue) -> {
            AccountTypeDTO values= observable.getValue();
            txtAccID.setText(values.getAccTypeID());
            txtAccType.setText(values.getAccType());
            txtInterest.setText(Double.toString(values.getRate()));
            txtMinAmouOf1stDep.setText(Double.toString(values.getMinAmouOf1stDep()));
            cmbCountOfOwners.setValue(Integer.toString(values.getCountOfOwners()));
        });
        
    }
    
    private void loadLoanTypeDetailsTableToTXT () throws Exception{
        
        loanDetailsTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends LoanTypeDTO> observable, LoanTypeDTO oldValue, LoanTypeDTO newValue) -> {
            LoanTypeDTO values= observable.getValue();
            txtLoanID.setText(values.getLoanTypeID());
            txtLoanType.setText(values.getLoanType());
            txtDuration.setText(Integer.toString(values.getDuration()));
            txtInterestCharge.setText(Double.toString(values.getRateCharge()));
            txtMaxAmount.setText(Double.toString(values.getMaxAmount()));
            txtMinMonthSalary.setText(Double.toString(values.getMinMonthSalary()));
        });
    }
    
    
    public void loadAllLoanTypeToTable () throws Exception{
        
       loanDetailsTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("loanTypeID"));
       loanDetailsTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("loanType"));
       loanDetailsTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
       loanDetailsTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("rateCharge"));
       loanDetailsTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("maxAmount"));
       loanDetailsTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("minMonthSalary"));
       
       loanDetailsTable.setItems(FXCollections.observableArrayList(loanSuperBO.getAllLoanType()));
       
       loanTypeIDLoader();
    }
    
    private void clearAccType(){
        txtAccType.clear();
        txtInterest.clear();
        txtMinAmouOf1stDep.clear();
    }
    private void clearLoanType(){
        txtLoanType.clear();
        txtDuration.clear();
        txtInterestCharge.clear();
        txtMaxAmount.clear();
        txtMinMonthSalary.clear();
    }

    @FXML
    private void clearLoanDetails(MouseEvent event) throws Exception{
        clearLoanType();
        loanTypeIDLoader();
    }

    @FXML
    private void clearAccountDetais(MouseEvent event) throws Exception{
        clearAccType();
        accountTypeIDLoader();
    }
    
    private void accountTypeIDLoader() throws ClassNotFoundException, IOException, Exception{
    
        String id= IDGenarator.getNewID("acctype", "accTypeID", "ACC");
        txtAccID.setText(id);
    }
    
    private void loanTypeIDLoader() throws ClassNotFoundException, IOException, Exception{
        String ids= IDGenarator.getNewID("loantype", "loanTypeID", "LO");
        txtLoanID.setText(ids);
    }
    
    
}
