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
public class Transaction {
    
    private String tranId_PK;
    private String tranType;
    private String accNum_FK;
    private double tranFee;
    private String tranDate;
    private String tranTime;
    private String tranPersNIC;

    public Transaction() {
    }

    public Transaction(String tranId_PK, String tranType, String accNum_FK, double tranFee, String tranDate, String tranTime, String tranPersNIC) {
        this.tranId_PK = tranId_PK;
        this.tranType = tranType;
        this.accNum_FK = accNum_FK;
        this.tranFee = tranFee;
        this.tranDate = tranDate;
        this.tranTime = tranTime;
        this.tranPersNIC = tranPersNIC;
    }

    /**
     * @return the tranId_PK
     */
    public String getTranId_PK() {
        return tranId_PK;
    }

    /**
     * @param tranId_PK the tranId_PK to set
     */
    public void setTranId_PK(String tranId_PK) {
        this.tranId_PK = tranId_PK;
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
     * @return the accNum_FK
     */
    public String getAccNum_FK() {
        return accNum_FK;
    }

    /**
     * @param accNum_FK the accNum_FK to set
     */
    public void setAccNum_FK(String accNum_FK) {
        this.accNum_FK = accNum_FK;
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
