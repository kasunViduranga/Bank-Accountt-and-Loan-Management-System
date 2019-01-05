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
public class LoanDTO {
    
    private String loanNum;
    private String cusID;
    private double loanAmount;
    private String startDate;
    private String firstGarenterID;
    private String secondGarenterID;
    private String loanTypeID;
    private int duration;
    private double interestCharge;
    private double monthlyPayment;
    private String payDate;
    private double total;

    public LoanDTO() {
    }

    public LoanDTO(String loanNum, String cusID, double loanAmount, String startDate, String firstGarenterID, String secondGarenterID, String loanTypeID, int duration, double interestCharge, double monthlyPayment, String payDate, double total) {
        this.loanNum = loanNum;
        this.cusID = cusID;
        this.loanAmount = loanAmount;
        this.startDate = startDate;
        this.firstGarenterID = firstGarenterID;
        this.secondGarenterID = secondGarenterID;
        this.loanTypeID = loanTypeID;
        this.duration = duration;
        this.interestCharge = interestCharge;
        this.monthlyPayment = monthlyPayment;
        this.payDate = payDate;
        this.total = total;
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
     * @return the cusID
     */
    public String getCusID() {
        return cusID;
    }

    /**
     * @param cusID the cusID to set
     */
    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    /**
     * @return the loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * @param loanAmount the loanAmount to set
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the firstGarenterID
     */
    public String getFirstGarenterID() {
        return firstGarenterID;
    }

    /**
     * @param firstGarenterID the firstGarenterID to set
     */
    public void setFirstGarenterID(String firstGarenterID) {
        this.firstGarenterID = firstGarenterID;
    }

    /**
     * @return the secondGarenterID
     */
    public String getSecondGarenterID() {
        return secondGarenterID;
    }

    /**
     * @param secondGarenterID the secondGarenterID to set
     */
    public void setSecondGarenterID(String secondGarenterID) {
        this.secondGarenterID = secondGarenterID;
    }

    /**
     * @return the loanTypeID
     */
    public String getLoanTypeID() {
        return loanTypeID;
    }

    /**
     * @param loanTypeID the loanTypeID to set
     */
    public void setLoanTypeID(String loanTypeID) {
        this.loanTypeID = loanTypeID;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the interestCharge
     */
    public double getInterestCharge() {
        return interestCharge;
    }

    /**
     * @param interestCharge the interestCharge to set
     */
    public void setInterestCharge(double interestCharge) {
        this.interestCharge = interestCharge;
    }

    /**
     * @return the monthlyPayment
     */
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * @param monthlyPayment the monthlyPayment to set
     */
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    /**
     * @return the payDate
     */
    public String getPayDate() {
        return payDate;
    }

    /**
     * @param payDate the payDate to set
     */
    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

            
}
