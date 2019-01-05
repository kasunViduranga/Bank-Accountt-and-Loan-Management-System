/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.AccountDTO;

/**
 *
 * @author Kasun
 */
public interface AccountBO extends SuperBO{
    
    public boolean addAccount(AccountDTO dto) throws Exception;

    public boolean deleteAccount(String id) throws Exception;

    public boolean updateAccount(AccountDTO dto) throws Exception;

    public AccountDTO searchAccount(String id) throws Exception;

    public ArrayList<AccountDTO> getAllAccount() throws Exception;
    
    public ArrayList<String> getAllAccountNumber() throws Exception;

    public boolean addAccountWithNewCustomer(AccountDTO accountDTO) throws Exception;
    
}
