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
public class TransactionDTO {
    
    private String tranId;
    private String tranType;
    private String accNum;
    private double tranFee;
    private String tranDate;
    private String tranTime;
    private String tranPersNIC;

    public TransactionDTO() {
    }

    public TransactionDTO(String tranId, String tranType, String accNum, double tranFee, String tranDate, String tranTime, String tranPersNIC) {
        this.tranId = tranId;
        this.tranType = tranType;
        this.accNum = accNum;
        this.tranFee = tranFee;
        this.tranDate = tranDate;
        this.tranTime = tranTime;
        this.tranPersNIC = tranPersNIC;
    }

    /**
     * @return the tranId
     */
    public String getTranId() {
        return tranId;
    }

    /**
     * @param tranId the tranId to set
     */
    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    /**
     * @return the tranType
     */
    public String getTranType() {
        return tranType;
    }

    /**
     * @param tranType the tranType to set
     */
    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    /**
     * @return the accNum
     */
    public String getAccNum() {
        return accNum;
    }

    /**
     * @param accNum the accNum to set
     */
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    /**
     * @return the tranFee
     */
    public double getTranFee() {
        return tranFee;
    }

    /**
     * @param tranFee the tranFee to set
     */
    public void setTranFee(double tranFee) {
        this.tranFee = tranFee;
    }

    /**
     * @return the tranDate
     */
    public String getTranDate() {
        return tranDate;
    }

    /**
     * @param tranDate the tranDate to set
     */
    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    /**
     * @return the tranTime
     */
    public String getTranTime() {
        return tranTime;
    }

    /**
     * @param tranTime the tranTime to set
     */
    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }

    /**
     * @return the tranPersNIC
     */
    public String getTranPersNIC() {
        return tranPersNIC;
    }

    /**
     * @param tranPersNIC the tranPersNIC to set
     */
    public void setTranPersNIC(String tranPersNIC) {
        this.tranPersNIC = tranPersNIC;
    }

       
    
}