/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.custom.CustomerBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.CustomerDAO;
import lk.ijse.student.bmgts.model.CustomerDTO;
import lk.ijse.student.bmgts.model.entity.Customer;

/**
 *
 * @author Kasun
 */
public class CustomerBOImpl implements CustomerBO{
    
    private CustomerDAO customerDAO;

    public CustomerBOImpl() throws Exception{
        customerDAO=(CustomerDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.CUSTOMER);
    }
    
    

    @Override
    public boolean addCustomer(CustomerDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer ref=customerDAO.serch(id);
        CustomerDTO customerDTO=new CustomerDTO(ref.getCusID_PK(), ref.getFirstName(), 
                ref.getLastName(), ref.getAddress(), ref.getOwnerType(), ref.getDob(), ref.getNic(), ref.getGender(), ref.getTell());
        return customerDTO;
    }
    
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        ArrayList<Customer> customers= customerDAO.getAll();
        ArrayList<CustomerDTO> cusDTO= new ArrayList<>();
         for(Customer customer:customers){
             cusDTO.add(new CustomerDTO(customer.getCusID_PK(),customer.getFirstName(),
                     customer.getLastName(),customer.getAddress(), customer.getOwnerType(),customer.getDob(),customer.getNic(),
                     customer.getGender(),customer.getTell()));
         }
         return cusDTO;
    }

    @Override
    public ArrayList<String> getAllCustomerID() throws Exception {
        ArrayList<Customer> customers=customerDAO.getAll();
         ArrayList<String> customerIDList= new ArrayList<>();
        for (Customer customer : customers) {
            customerIDList.add(customer.getCusID_PK());
        }
        return customerIDList;
    }
}
