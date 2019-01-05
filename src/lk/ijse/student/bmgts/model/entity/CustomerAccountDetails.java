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
public class CustomerAccountDetails {
    
    private String cusAccDetailsID_PK;
    private String cusID_FK;
    private String accNum_FK;

    public CustomerAccountDetails() {
    }

    public CustomerAccountDetails(String cusAccDetailsID_PK, String cusID_FK, String accNum_FK) {
        this.cusAccDetailsID_PK = cusAccDetailsID_PK;
        this.cusID_FK = cusID_FK;
        this.accNum_FK = accNum_FK;
    }

    /**
     * @return the cusAccDetailsID_PK
     */
    public String getCusAccDetailsID_PK() {
        return cusAccDetailsID_PK;
    }

    /**
     * @param cusAccDetailsID_PK the cusAccDetailsID_PK to set
     */
    public void setCusAccDetailsID_PK(String cusAccDetailsID_PK) {
        this.cusAccDetailsID_PK = cusAccDetailsID_PK;
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

    
   }
