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
public class Account {
    
    private String accNum_PK;
    private String openDate;
    private String openTime;
    private double total;
    private String accTypeID_FK;
    private String nic;

    public Account() {
    }

    public Account(String accNum_PK, double total){
        this.accNum_PK = accNum_PK;
        this.total = total;
    }
    
    public Account(String accNum_PK, String openDate, String openTime, double total, String accTypeID_FK, String nic) {
        this.accNum_PK = accNum_PK;
        this.openDate = openDate;
        this.openTime = openTime;
        this.total = total;
        this.accTypeID_FK = accTypeID_FK;
        this.nic = nic;
    }

    /**
     * @return the accNum_PK
     */
    public String getAccNum_PK() {
        return accNum_PK;
    }

    /**
     * @param accNum_PK the accNum_PK to set
     */
    public void setAccNum_PK(String accNum_PK) {
        this.accNum_PK = accNum_PK;
    }

    /**
     * @return the openDate
     */
    public String getOpenDate() {
        return openDate;
    }

    /**
     * @param openDate the openDate to set
     */
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    /**
     * @return the openTime
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * @param openTime the openTime to set
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime;
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

    /**
     * @return the accTypeID_FK
     */
    public String getAccTypeID_FK() {
        return accTypeID_FK;
    }

    /**
     * @param accTypeID_FK the accTypeID_FK to set
     */
    public void setAccTypeID_FK(String accTypeID_FK) {
        this.accTypeID_FK = accTypeID_FK;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

               
    
}
