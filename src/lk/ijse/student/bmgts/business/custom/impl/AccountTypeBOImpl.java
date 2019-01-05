/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.custom.AccountTypeBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.AccountTypeDAO;
import lk.ijse.student.bmgts.model.AccountTypeDTO;
import lk.ijse.student.bmgts.model.entity.AccountType;

/**
 *
 * @author Kasun
 */
public class AccountTypeBOImpl implements AccountTypeBO{
    
     private AccountTypeDAO superDAO;

    public AccountTypeBOImpl() throws Exception {
        superDAO = (AccountTypeDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ACCOUNT_TYPE);
    }
     
     

    @Override
    public boolean addAccountType(AccountTypeDTO dto) throws Exception {
        
        AccountType accountType=new AccountType(dto.getAccTypeID(), dto.getAccType(), dto.getRate(), dto.getMinAmouOf1stDep(),dto.getCountOfOwners());
        return superDAO.add(accountType);
    }

    @Override
    public boolean deleteAccountType(String id) throws Exception {
        return superDAO.delete(id);
    }

    @Override
    public boolean updateAccountType(AccountTypeDTO dto) throws Exception {
        AccountType accountType= new AccountType(dto.getAccTypeID(), dto.getAccType(), dto.getRate(), dto.getMinAmouOf1stDep(),dto.getCountOfOwners());
         return superDAO.update(accountType);
    }

    @Override
    public AccountTypeDTO searchAccountType(String id) throws Exception {
        AccountType ref= superDAO.serch(id);
        AccountTypeDTO accTypeDTO= new AccountTypeDTO(ref.getAccTypeID_PK(), ref.getAccType(), ref.getRate(), ref.getMinAmouOf1stDep(), ref.getCountOfOwners());
        return accTypeDTO;
    }

    @Override
    public ArrayList<AccountTypeDTO> getAllAccountType() throws Exception {
         ArrayList<AccountType> getAll = superDAO.getAll();
         ArrayList<AccountTypeDTO> accDTO= new ArrayList<>();
         for(AccountType accType:getAll){
             accDTO.add(new AccountTypeDTO(accType.getAccTypeID_PK(), accType.getAccType(), accType.getRate(), accType.getMinAmouOf1stDep(), accType.getCountOfOwners()));
         }
         return accDTO;
    }

    @Override
    public ArrayList<String> getAllAccountTypeID() throws Exception {
        ArrayList<AccountType> accountTypes= superDAO.getAll();
        ArrayList<String> accountTypeList= new ArrayList<>();
        for (AccountType accountType : accountTypes) {
            accountTypeList.add(accountType.getAccTypeID_PK());
        }
        return accountTypeList;
    }
    
}
