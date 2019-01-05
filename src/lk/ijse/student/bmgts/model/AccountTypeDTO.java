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
public class AccountTypeDTO {

    public static void add(AccountTypeDTO accTypeDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String  accTypeID;
    private String accType;
    private double rate;
    private double minAmouOf1stDep;
    private int countOfOwners;

    public AccountTypeDTO() {
    }

    public AccountTypeDTO(String accTypeID, String accType, double rate, double minAmouOf1stDep, int countOfOwners) {
        this.accTypeID = accTypeID;
        this.accType = accType;
        this.rate = rate;
        this.minAmouOf1stDep = minAmouOf1stDep;
        this.countOfOwners = countOfOwners;
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
     * @return the accType
     */
    public String getAccType() {
        return accType;
    }

    /**
     * @param accType the accType to set
     */
    public void setAccType(String accType) {
        this.accType = accType;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * @return the minAmouOf1stDep
     */
    public double getMinAmouOf1stDep() {
        return minAmouOf1stDep;
    }

    /**
     * @param minAmouOf1stDep the minAmouOf1stDep to set
     */
    public void setMinAmouOf1stDep(double minAmouOf1stDep) {
        this.minAmouOf1stDep = minAmouOf1stDep;
    }

    /**
     * @return the countOfOwners
     */
    public int getCountOfOwners() {
        return countOfOwners;
    }

    /**
     * @param countOfOwners the countOfOwners to set
     */
    public void setCountOfOwners(int countOfOwners) {
        this.countOfOwners = countOfOwners;
    }

     
    
}
