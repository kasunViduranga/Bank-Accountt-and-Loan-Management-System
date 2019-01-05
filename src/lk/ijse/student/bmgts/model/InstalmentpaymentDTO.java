/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.model;

/**
 *
 * @author Kasun
 */
public class InstalmentpaymentDTO {
    
    private String loanPayID;
    private String loanNum;
    private String paydate;
    private String payPersNIC;
    private double payAmount;

    public InstalmentpaymentDTO() {
    }

    public InstalmentpaymentDTO(String loanPayID, String loanNum, String paydate, String payPersNIC, double payAmount) {
        this.loanPayID = loanPayID;
        this.loanNum = loanNum;
        this.paydate = paydate;
        this.payPersNIC = payPersNIC;
        this.payAmount = payAmount;
    }

    /**
     * @return the loanPayID
     */
    public String getLoanPayID() {
        return loanPayID;
    }

    /**
     * @param loanPayID the loanPayID to set
     */
    public void setLoanPayID(String loanPayID) {
        this.loanPayID = loanPayID;
    }

    /**
     * @return the loanNum
     */
    public String getLoanNum() {
        return loanNum;
    }

    /**
     * @param loanNum the loanNum to set
     */
    public void setLoanNum(String loanNum) {
        this.loanNum = loanNum;
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
