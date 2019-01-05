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
public class AccountDTO {
    
    private String accNum;
    private String openDate;
    private String openTime;
    private double total;
    private String accTypeID;
    private String nic;
   
    public AccountDTO() {
    }
    
    public AccountDTO(String accNum, Double total){
        this.accNum = accNum;
        this.total=total;
    }
    
    public AccountDTO(String accNum, String openDate, String openTime, String accTypeID,double total,String nic){
        this.accNum = accNum;
        this.openDate = openDate;
        this.openTime = openTime;
        this.total=total;
        this.accTypeID = accTypeID;
        this.nic=nic;
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
     * @return the accTypeID
     */
    public String getAccTypeID() {
        return accTypeID;
    }

    /**
     * @param accTypeID the accTypeID to set
     */
    public void setAccTypeID(String accTypeID) {
        this.accTypeID = accTypeID;
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
