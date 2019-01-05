/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.controller;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.student.bmgts.db.DBConnection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Kasun
 */
public class ReportPageController implements Initializable {

    @FXML
    private AnchorPane reportPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void loadCustomerDetailsReport(MouseEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/bmgts/reports/BankcustomerReport.jasper");
            HashMap map = new HashMap();
            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(fillReport, false);
        } catch (Exception ex) {
            Logger.getLogger(ReportPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    @FXML
    private void loadMoneyWithdrawDetailsReport(MouseEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/bmgts/reports/TransactionReport.jasper");
            HashMap map = new HashMap();
            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(fillReport, false);
        } catch (Exception ex) {
            Logger.getLogger(ReportPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void loadLoanTypeDetailsReport(MouseEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/bmgts/reports/loanTypeDetails.jasper");
            HashMap map = new HashMap();
            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(fillReport, false);
        } catch (Exception ex) {
            Logger.getLogger(ReportPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadAccTypeDetailsReport(MouseEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/bmgts/reports/AccTypeReports.jasper");
            HashMap map = new HashMap();
            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(fillReport, false);
        } catch (Exception ex) {
            Logger.getLogger(ReportPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadAccountReport(MouseEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/bmgts/reports/accountDetails.jasper");
            HashMap map = new HashMap();
            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(fillReport, false);
        } catch (Exception ex) {
            Logger.getLogger(ReportPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadLoanDetailsReport(MouseEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/bmgts/reports/loanDetail.jasper");
            HashMap map = new HashMap();
            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(fillReport, false);
        } catch (Exception ex) {
            Logger.getLogger(ReportPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadGarenterReport(MouseEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/bmgts/reports/GarenterDetails.jasper");
            HashMap map = new HashMap();
            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(fillReport, false);
        } catch (Exception ex) {
            Logger.getLogger(ReportPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadPaymentdetailReport(MouseEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/bmgts/reports/instalmentpayment.jasper");
            HashMap map = new HashMap();
            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(fillReport, false);
        } catch (Exception ex) {
            Logger.getLogger(ReportPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
