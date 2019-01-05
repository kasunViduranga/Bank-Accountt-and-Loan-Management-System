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
public class CustomerAccountDetailsDTO {
    
    private String cusAccDetailsID;
    private String cusID;
    private String accNum;

    public CustomerAccountDetailsDTO() {
    }

    public CustomerAccountDetailsDTO(String cusAccDetailsID, String cusID, String accNum) {
        this.cusAccDetailsID = cusAccDetailsID;
        this.cusID = cusID;
        this.accNum = accNum;
    }

    /**
     * @return the cusAccDetailsID
     */
    public String getCusAccDetailsID() {
        return cusAccDetailsID;
    }

    /**
     * @param cusAccDetailsID the cusAccDetailsID to set
     */
    public void setCusAccDetailsID(String cusAccDetailsID) {
        this.cusAccDetailsID = cusAccDetailsID;
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

    
}
