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
public class CommenDTO {
    private CustomerDTO customerDTO;
    private AccountDTO accountDTO;
    private CustomerAccountDetailsDTO customerAccountDetailsDTO;
    private boolean isNewOne;

    public CommenDTO() {
    }
    public CommenDTO( AccountDTO accountDTO, CustomerAccountDetailsDTO customerAccountDetailsDTO){
        this.accountDTO = accountDTO;
        this.customerAccountDetailsDTO = customerAccountDetailsDTO;
    
    }
    public CommenDTO(CustomerDTO customerDTO, AccountDTO accountDTO, CustomerAccountDetailsDTO customerAccountDetailsDTO) {
        this.customerDTO = customerDTO;
        this.accountDTO = accountDTO;
        this.customerAccountDetailsDTO = customerAccountDetailsDTO;
    }
    
    public CommenDTO(boolean isNewOne){
        this.isNewOne=isNewOne;
    }

    /**
     * @return the customerDTO
     */
    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    /**
     * @param customerDTO the customerDTO to set
     */
    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    /**
     * @return the accountDTO
     */
    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    /**
     * @param accountDTO the accountDTO to set
     */
    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    /**
     * @return the customerAccountDetailsDTO
     */
    public CustomerAccountDetailsDTO getCustomerAccountDetailsDTO() {
        return customerAccountDetailsDTO;
    }

    /**
     * @param customerAccountDetailsDTO the customerAccountDetailsDTO to set
     */
    public void setCustomerAccountDetailsDTO(CustomerAccountDetailsDTO customerAccountDetailsDTO) {
        this.customerAccountDetailsDTO = customerAccountDetailsDTO;
    }

    /**
     * @return the isNewOne
     */
    public boolean isIsNewOne() {
        return isNewOne;
    }

    /**
     * @param isNewOne the isNewOne to set
     */
    public void setIsNewOne(boolean isNewOne) {
        this.isNewOne = isNewOne;
    }
    
}
