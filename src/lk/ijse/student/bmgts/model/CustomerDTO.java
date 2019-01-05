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
public class CustomerDTO {
    
    private String cusID;
    private String firstName;
    private String lastName;
    private String address;
    private String ownerType;
    private String dob;
    private String nic;
    private String gender;
    private String tell;

    public CustomerDTO() {
    }

    public CustomerDTO(String cusID, String firstName, String lastName, String address, String ownerType,String dob, String nic, String gender, String tell) {
        this.cusID = cusID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ownerType=ownerType;
        this.dob = dob;
        this.nic = nic;
        this.gender = gender;
        this.tell = tell;
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
     * @return the tell
     */
    public String getTell() {
        return tell;
    }

    /**
     * @param tell the tell to set
     */
    public void setTell(String tell) {
        this.tell = tell;
    }

    /**
     * @return the ownerType
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * @param ownerType the ownerType to set
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

       
}
