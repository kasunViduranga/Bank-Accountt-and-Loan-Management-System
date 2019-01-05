/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.model.entity;

/**
 *
 * @author Kasun
 */
public class Instalmentpayment {
    private String loanPayID_PK;
    private String loanNum_FK;
    private String paydate;
    private String payPersNIC;
    private double payAmount;

    public Instalmentpayment() {
    }

    public Instalmentpayment(String loanPayID_PK, String loanNum_FK, String paydate, String payPersNIC, double payAmount) {
        this.loanPayID_PK = loanPayID_PK;
        this.loanNum_FK = loanNum_FK;
        this.paydate = paydate;
        this.payPersNIC = payPersNIC;
        this.payAmount = payAmount;
    }

    /**
     * @return the loanPayID_PK
     */
    public String getLoanPayID_PK() {
        return loanPayID_PK;
    }

    /**
     * @param loanPayID_PK the loanPayID_PK to set
     */
    public void setLoanPayID_PK(String loanPayID_PK) {
        this.loanPayID_PK = loanPayID_PK;
    }

    /**
     * @return the loanNum_FK
     */
    public String getLoanNum_FK() {
        return loanNum_FK;
    }

    /**
     * @param loanNum_FK the loanNum_FK to set
     */
    public void setLoanNum_FK(String loanNum_FK) {
        this.loanNum_FK = loanNum_FK;
    }

    /**
     * @return the paydate
     */
    public String getPaydate() {
        return paydate;
    }

    /**
     * @param paydate the paydate to set
     */
    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    /**
     * @return the payPersNIC
     */
    public String getPayPersNIC() {
        return payPersNIC;
    }

    /**
     * @param payPersNIC the payPersNIC to set
     */
    public void setPayPersNIC(String payPersNIC) {
        this.payPersNIC = payPersNIC;
    }

    /**
     * @return the payAmount
     */
    public double getPayAmount() {
        return payAmount;
    }

    /**
     * @param payAmount the payAmount to set
     */
    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    
}