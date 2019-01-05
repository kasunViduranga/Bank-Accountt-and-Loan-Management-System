/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.AccountTypeDAO;
import lk.ijse.student.bmgts.model.entity.AccountType;

/**
 *
 * @author Kasun
 */
public class AccountTypeDAOImpl implements AccountTypeDAO {

    @Override
    public boolean add(AccountType entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into accType values(?,?,?,?,?)", entity.getAccTypeID_PK(),entity.getAccType(), entity.getRate(), entity.getMinAmouOf1stDep(), entity.getCountOfOwners());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from accType where accTypeID=?", id);
    }

    @Override
    public boolean update(AccountType entity) throws Exception {
        String SQL="Update accType set accType=?, rate=?, minAmouOf1stDep=?, CountOfOwners=? where accTypeID=?";
        String Acctype=entity.getAccType();
        double rate=entity.getRate();
        double minAmountOf1stDep=entity.getMinAmouOf1stDep();
        int countOfOwners=entity.getCountOfOwners();
        String acctypeID=entity.getAccTypeID_PK();
        
        return CrudUtil.executeUpdate(SQL,Acctype,rate,minAmountOf1stDep,countOfOwners,acctypeID);
    }

    @Override
    public AccountType serch(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from accType where accTypeID=?", id);
        
        if(rst.next()){
            String  accTypeID=rst.getString("accTypeID");
            String accType=rst.getString("accType");
            double rate=rst.getDouble("rate");
            double minAmouOf1stDep=rst.getDouble("minAmouOf1stDep");
            int countOfOwners=rst.getInt("CountOfOwners");
            
            AccountType accountType= new AccountType(accTypeID, accType, rate, minAmouOf1stDep, countOfOwners);
            return accountType;
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<AccountType> getAll() throws Exception {
        ArrayList<AccountType> accType= new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from accType");
        while (rst.next()) {
           accType.add(new AccountType(rst.getString("accTypeID"), rst.getString("accType"), rst.getDouble("rate"), rst.getDouble("minAmouOf1stDep"), rst.getInt("CountOfOwners")));
            
        }
        return accType;
    }

   

    
}
