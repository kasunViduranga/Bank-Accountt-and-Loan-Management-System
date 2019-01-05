/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.AccountTypeDTO;
import lk.ijse.student.bmgts.model.CustomerDTO;

/**
 *
 * @author Kasun
 */
public interface CustomerBO extends SuperBO{
    
    public boolean addCustomer(CustomerDTO dto) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public boolean updateCustomer(CustomerDTO dto) throws Exception;

    public CustomerDTO searchCustomer(String id) throws Exception;

    public ArrayList<CustomerDTO> getAllCustomer() throws Exception;
    
    public ArrayList<String> getAllCustomerID() throws Exception;
    
}
