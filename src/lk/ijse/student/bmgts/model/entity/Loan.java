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
public class Loan {
    private String loanNum_PK;
    private String cusID_FK;
    private double loanAmount;
    private String startDate;
    private String firstGarenterID_FK;
    private String secondGarenterID_FK;
    private String loanTypeID_FK;
    private int duration;
    private double interestCharge;
    private double monthlyPayment;
    private String payDate;
    private double total;

    public Loan() {
    }

    public Loan(String loanNum_PK, String cusID_FK, double loanAmount, String startDate, String firstGarenterID_FK, String secondGarenterID_FK, String loanTypeID_FK, int duration, double interestCharge, double monthlyPayment, String payDate, double total) {
        this.loanNum_PK = loanNum_PK;
        this.cusID_FK = cusID_FK;
        this.loanAmount = loanAmount;
        this.startDate = startDate;
        this.firstGarenterID_FK = firstGarenterID_FK;
        this.secondGarenterID_FK = secondGarenterID_FK;
        this.loanTypeID_FK = loanTypeID_FK;
        this.duration = duration;
        this.interestCharge = interestCharge;
        this.monthlyPayment = monthlyPayment;
        this.payDate = payDate;
        this.total = total;
    }

    /**
     * @return the loanNum_PK
     */
    public String getLoanNum_PK() {
        return loanNum_PK;
    }

    /**
     * @param loanNum_PK the loanNum_PK to set
     */
    public void setLoanNum_PK(String loanNum_PK) {
        this.loanNum_PK = loanNum_PK;
    }

    /**
     * @return the cusID_FK
     */
    public String getCusID_FK() {
        return cusID_FK;
    }

    /**
     * @param cusID_FK the cusID_FK to set
     */
    public void setCusID_FK(String cusID_FK) {
        this.cusID_FK = cusID_FK;
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
     * @return the firstGarenterID_FK
     */
    public String getFirstGarenterID_FK() {
        return firstGarenterID_FK;
    }

    /**
     * @param firstGarenterID_FK the firstGarenterID_FK to set
     */
    public void setFirstGarenterID_FK(String firstGarenterID_FK) {
        this.firstGarenterID_FK = firstGarenterID_FK;
    }

    /**
     * @return the secondGarenterID_FK
     */
    public String getSecondGarenterID_FK() {
        return secondGarenterID_FK;
    }

    /**
     * @param secondGarenterID_FK the secondGarenterID_FK to set
     */
    public void setSecondGarenterID_FK(String secondGarenterID_FK) {
        this.secondGarenterID_FK = secondGarenterID_FK;
    }

    /**
     * @return the loanTypeID_FK
     */
    public String getLoanTypeID_FK() {
        return loanTypeID_FK;
    }

    /**
     * @param loanTypeID_FK the loanTypeID_FK to set
     */
    public void setLoanTypeID_FK(String loanTypeID_FK) {
        this.loanTypeID_FK = loanTypeID_FK;
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

