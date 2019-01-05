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
public class GarenterDTO {
    private String garenterID;
    private String firstName;
    private String lastName;
    private String address;
    private String nic;
    private String dob;
    private String mobNum;
    private String homeTell;
    private String gender;
    private String job;
    private double monthSalary;
    private String paysheetNum;

    public GarenterDTO() {
    }

    public GarenterDTO(String garenterID, String firstName, String lastName, String address, String nic, String dob, String mobNum, String homeTell, String gender, String job, double monthSalary, String paysheetNum) {
        this.garenterID = garenterID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.nic = nic;
        this.dob = dob;
        this.mobNum = mobNum;
        this.homeTell = homeTell;
        this.gender = gender;
        this.job = job;
        this.monthSalary = monthSalary;
        this.paysheetNum = paysheetNum;
    }

    /**
     * @return the garenterID
     */
    public String getGarenterID() {
        return garenterID;
    }

    /**
     * @param garenterID the garenterID to set
     */
    public void setGarenterID(String garenterID) {
        this.garenterID = garenterID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the mobNum
     */
    public String getMobNum() {
        return mobNum;
    }

    /**
     * @param mobNum the mobNum to set
     */
    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    /**
     * @return the homeTell
     */
    public String getHomeTell() {
        return homeTell;
    }

    /**
     * @param homeTell the homeTell to set
     */
    public void setHomeTell(String homeTell) {
        this.homeTell = homeTell;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the monthSalary
     */
    public double getMonthSalary() {
        return monthSalary;
    }

    /**
     * @param monthSalary the monthSalary to set
     */
    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    /**
     * @return the paysheetNum
     */
    public String getPaysheetNum() {
        return paysheetNum;
    }

    /**
     * @param paysheetNum the paysheetNum to set
     */
    public void setPaysheetNum(String paysheetNum) {
        this.paysheetNum = paysheetNum;
    }
    
    
    
}