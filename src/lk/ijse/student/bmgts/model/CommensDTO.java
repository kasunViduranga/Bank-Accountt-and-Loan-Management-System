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
public class CommensDTO {
    private AccountDTO accountDTO;
    private CustomerAccountDetailsDTO customerAccountDetailsDTO;

    public CommensDTO() {
    }

    public CommensDTO(AccountDTO accountDTO, CustomerAccountDetailsDTO customerAccountDetailsDTO) {
        this.accountDTO = accountDTO;
        this.customerAccountDetailsDTO = customerAccountDetailsDTO;
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

    
}
