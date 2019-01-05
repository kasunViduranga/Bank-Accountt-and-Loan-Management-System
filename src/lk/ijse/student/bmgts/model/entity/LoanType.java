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
public class LoanType {
    private String loanTypeID_PK;
    private String loanType;
    private int duration;
    private double rateCharge;
    private double maxAmount;
    private double minMonthSalary;

    public LoanType() {
    }

    public LoanType(String loanTypeID_PK, String loanType, int duration, double rateCharge, double maxAmount, double minMonthSalary) {
        this.loanTypeID_PK = loanTypeID_PK;
        this.loanType = loanType;
        this.duration = duration;
        this.rateCharge = rateCharge;
        this.maxAmount = maxAmount;
        this.minMonthSalary = minMonthSalary;
    }

    /**
     * @return the loanTypeID_PK
     */
    public String getLoanTypeID_PK() {
        return loanTypeID_PK;
    }

    /**
     * @param loanTypeID_PK the loanTypeID_PK to set
     */
    public void setLoanTypeID_PK(String loanTypeID_PK) {
        this.loanTypeID_PK = loanTypeID_PK;
    }

    /**
     * @return the loanType
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * @param loanType the loanType to set
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType;
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
     * @return the rateCharge
     */
    public double getRateCharge() {
        return rateCharge;
    }

    /**
     * @param rateCharge the rateCharge to set
     */
    public void setRateCharge(double rateCharge) {
        this.rateCharge = rateCharge;
    }

    /**
     * @return the maxAmount
     */
    public double getMaxAmount() {
        return maxAmount;
    }

    /**
     * @param maxAmount the maxAmount to set
     */
    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * @return the minMonthSalary
     */
    public double getMinMonthSalary() {
        return minMonthSalary;
    }

    /**
     * @param minMonthSalary the minMonthSalary to set
     */
    public void setMinMonthSalary(double minMonthSalary) {
        this.minMonthSalary = minMonthSalary;
    }

    
}
