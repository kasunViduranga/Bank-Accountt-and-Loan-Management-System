/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.student.bmgts.business.BOFactory;
import lk.ijse.student.bmgts.business.custom.CustomerBO;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.model.CustomerDTO;
import lk.ijse.student.bmgts.model.entity.Customer;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class CustomerManageController implements Initializable {

    @FXML
    private TableView<CustomerDTO> tableCustomer;
    @FXML
    private TextField txtNICSearch;
    @FXML
    private JFXTextField txtFirstName;
    @FXML
    private JFXTextField txtLastName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtOwnerType;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtTell;

    private CustomerBO customerBO;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            customerBO=(CustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CUSTOMER);
            loadAllCustomer();
        } catch (Exception ex) {
            Logger.getLogger(CustomerManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void searchCustomer(MouseEvent event) {
    }

    @FXML
    private void clearText(MouseEvent event) {
        
        txtNICSearch.clear();
        txtFirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
        txtOwnerType.clear();
        txtNIC.clear();
        txtTell.clear();
    }

    @FXML
    private void customerIsUpdete(MouseEvent event) {
    }
    
    private void loadAllCustomer(){
        
        try {
            tableCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cusID"));
            tableCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("firstName"));
            tableCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("lastName"));
            tableCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
            tableCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("ownerType"));
            tableCustomer.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("dob"));
            tableCustomer.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("nic"));
            tableCustomer.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("gender"));
            tableCustomer.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("tell"));
            
            tableCustomer.setItems(FXCollections.observableArrayList(customerBO.getAllCustomer()));
        } catch (Exception ex) {
            Logger.getLogger(CustomerManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
