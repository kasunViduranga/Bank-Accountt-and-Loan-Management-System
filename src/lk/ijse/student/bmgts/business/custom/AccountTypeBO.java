/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.AccountTypeDTO;

/**
 *
 * @author Kasun
 */
public interface AccountTypeBO extends SuperBO{
    
    public boolean addAccountType(AccountTypeDTO dto) throws Exception;

    public boolean deleteAccountType(String id) throws Exception;

    public boolean updateAccountType(AccountTypeDTO dto) throws Exception;

    public AccountTypeDTO searchAccountType(String id) throws Exception;

    public ArrayList<AccountTypeDTO> getAllAccountType() throws Exception;
    
    public ArrayList<String> getAllAccountTypeID() throws Exception;
    
}
