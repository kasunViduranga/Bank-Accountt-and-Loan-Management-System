/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.student.bmgts.business.custom.CustomerAccountDetailsBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.AccountDAO;
import lk.ijse.student.bmgts.dao.custom.CustomerAccountDetailsDAO;
import lk.ijse.student.bmgts.dao.custom.CustomerDAO;
import lk.ijse.student.bmgts.db.DBConnection;
import lk.ijse.student.bmgts.model.CommenDTO;
import lk.ijse.student.bmgts.model.CommensDTO;
import lk.ijse.student.bmgts.model.CustomerAccountDetailsDTO;
import lk.ijse.student.bmgts.model.entity.Account;
import lk.ijse.student.bmgts.model.entity.Customer;
import lk.ijse.student.bmgts.model.entity.CustomerAccountDetails;

/**
 *
 * @author Kasun
 */
public class CustomerAccountDetailsBOImpl implements CustomerAccountDetailsBO{
    private static CustomerDAO customerDAO;
    private static AccountDAO accountDAO;
    private static CustomerAccountDetailsDAO customerAccountDetailsDAO;
    public CustomerAccountDetailsBOImpl() throws Exception {
        customerDAO=(CustomerDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.CUSTOMER);
        accountDAO=(AccountDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ACCOUNT);
        customerAccountDetailsDAO=(CustomerAccountDetailsDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.CUSTOMERACCOUNTDETAILS);
    }
    
    @Override
    public boolean addCustomerAccountDetails(CustomerAccountDetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomerAccountDetails(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomerAccountDetails(CustomerAccountDetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerAccountDetailsDTO searchCustomerAccountDetails(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerAccountDetailsDTO> getAllCustomerAccountDetails() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllCustomerAccountDetailsID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCustomerWithAccount(CommenDTO dTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        CommenDTO commenDTO=new CommenDTO();
        boolean isNew=commenDTO.isIsNewOne();
        try{
             boolean add = customerDAO.add(new Customer(
                     dTO.getCustomerDTO().getCusID(), 
                     dTO.getCustomerDTO().getFirstName(),
                        dTO.getCustomerDTO().getLastName(), 
                     dTO.getCustomerDTO().getAddress(), 
                     dTO.getCustomerDTO().getOwnerType(), 
                     dTO.getCustomerDTO().getDob(),
                        dTO.getCustomerDTO().getNic(), 
                     dTO.getCustomerDTO().getGender(), 
                     dTO.getCustomerDTO().getTell()));
                if(!add){
                    return false;
                }
                add = accountDAO.add(new Account(
                        dTO.getAccountDTO().getAccNum(), 
                        dTO.getAccountDTO().getOpenDate(), 
                        dTO.getAccountDTO().getOpenTime(), 
                        dTO.getAccountDTO().getTotal(),
                        dTO.getAccountDTO().getAccTypeID(), 
                        dTO.getAccountDTO().getNic()));
            if(!add){
                connection.rollback();
                return false;
                }
               add = customerAccountDetailsDAO.add(new CustomerAccountDetails(
                       dTO.getCustomerAccountDetailsDTO().getCusAccDetailsID(),
                       dTO.getCustomerAccountDetailsDTO().getCusID(),
                       dTO.getCustomerAccountDetailsDTO().getAccNum()));
               if(!add){
                   connection.rollback();
                   return false;
               }
               connection.commit();
               return true;
        }finally{
               connection.setAutoCommit(true);
        }   
        
    }

    @Override
    public boolean addCustomerWithAccounts(CommensDTO dTO) throws Exception {
        
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try{
                boolean add = accountDAO.add(
                        new Account(
                                dTO.getAccountDTO().getAccNum(), 
                                dTO.getAccountDTO().getOpenDate(), 
                                dTO.getAccountDTO().getOpenTime(), 
                                dTO.getAccountDTO().getTotal(),
                                dTO.getAccountDTO().getAccTypeID(), 
                                dTO.getAccountDTO().getNic()
                        )
                );
            if(!add){
                connection.rollback();
                return false;
                }
                add = customerAccountDetailsDAO.add(new CustomerAccountDetails(dTO.getCustomerAccountDetailsDTO().getCusAccDetailsID(),
                        dTO.getCustomerAccountDetailsDTO().getCusID(),dTO.getCustomerAccountDetailsDTO().getAccNum()));
                if(!add){
                    connection.rollback();
                    return false;
                }
               connection.commit();
               return true;
        }finally{
               connection.setAutoCommit(true);
        }   
    }
    
}
