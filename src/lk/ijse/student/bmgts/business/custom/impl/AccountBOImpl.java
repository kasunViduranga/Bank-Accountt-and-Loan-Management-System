/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.custom.AccountBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.AccountDAO;
import lk.ijse.student.bmgts.dao.custom.CustomerAccountDetailsDAO;
import lk.ijse.student.bmgts.dao.custom.CustomerDAO;
import lk.ijse.student.bmgts.model.AccountDTO;
import lk.ijse.student.bmgts.model.entity.Account;

/**
 *
 * @author Kasun
 */
public class AccountBOImpl implements AccountBO{

    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    private CustomerAccountDetailsDAO customerAccountDetailsDAO;
    
    public AccountBOImpl() throws Exception {
        accountDAO=(AccountDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ACCOUNT);
        customerDAO=(CustomerDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.CUSTOMER);
        customerAccountDetailsDAO=(CustomerAccountDetailsDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.CUSTOMERACCOUNTDETAILS);
    }
    
    

    @Override
    public boolean addAccount(AccountDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAccount(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAccount(AccountDTO dto) throws Exception {
        return accountDAO.update(new Account(dto.getAccNum(), dto.getTotal()));
    }

    @Override
    public AccountDTO searchAccount(String id) throws Exception {
        Account ref=accountDAO.serch(id);
        AccountDTO accountDTO= new AccountDTO(ref.getAccNum_PK(), ref.getOpenDate(), ref.getOpenTime(), ref.getAccTypeID_FK(), ref.getTotal(), ref.getNic());
        return accountDTO;
    }

    @Override
    public ArrayList<AccountDTO> getAllAccount() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllAccountNumber() throws Exception {
        ArrayList<Account> accounts=accountDAO.getAll();
        ArrayList<String> accountIDList= new ArrayList<>();
        for (Account account : accounts) {
            accountIDList.add(account.getAccNum_PK());
        }
        return accountIDList;
        
    }

    @Override
    public boolean addAccountWithNewCustomer(AccountDTO accountDTO) throws Exception{
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
 
}
