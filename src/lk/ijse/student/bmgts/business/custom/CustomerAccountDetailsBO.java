/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.AccountDTO;
import lk.ijse.student.bmgts.model.CommenDTO;
import lk.ijse.student.bmgts.model.CommensDTO;
import lk.ijse.student.bmgts.model.CustomerAccountDetailsDTO;

/**
 *
 * @author Kasun
 */
public interface CustomerAccountDetailsBO extends SuperBO{
    
    public boolean addCustomerAccountDetails(CustomerAccountDetailsDTO dto) throws Exception;

    public boolean deleteCustomerAccountDetails(String id) throws Exception;

    public boolean updateCustomerAccountDetails(CustomerAccountDetailsDTO dto) throws Exception;

    public CustomerAccountDetailsDTO searchCustomerAccountDetails(String id) throws Exception;

    public ArrayList<CustomerAccountDetailsDTO> getAllCustomerAccountDetails() throws Exception;
    
    public ArrayList<String> getAllCustomerAccountDetailsID() throws Exception;
    
    public boolean addCustomerWithAccount(CommenDTO dTO)throws Exception;
    
    public boolean addCustomerWithAccounts(CommensDTO dTO)throws Exception;
}
