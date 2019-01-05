/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.AccountDAO;
import lk.ijse.student.bmgts.model.entity.Account;

/**
 *
 * @author Kasun
 */
public class AccountDAoImpl implements AccountDAO{

    @Override
    public boolean add(Account entity) throws Exception {
        return CrudUtil.executeUpdate("insert into account values (?,?,?,?,?,?)", entity.getAccNum_PK(),
                entity.getOpenDate(),entity.getOpenTime(),entity.getTotal(),entity.getAccTypeID_FK(),entity.getNic());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Account entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE account set total=? WHERE accNum=?", entity.getTotal(), entity.getAccNum_PK());
    }

    @Override
    public Account serch(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from account where accNum=?", id);
        if(rst.next()){
            String accNum_pk=rst.getString("accNum");
            String openDate=rst.getString("openDate");
            String openTime=rst.getString("openTime");
            double total=rst.getDouble("total");
            String accTypeID_FK=rst.getString("accTypeID");
            String nic=rst.getString("nic");
            
            Account account= new Account(accNum_pk, openDate, openTime, total, accTypeID_FK, nic);
            return account;
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Account> getAll() throws Exception {
        ArrayList<Account> accounts= new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from account");
        while (rst.next()) {
           accounts.add(new Account(rst.getString("accNum"), rst.getString("openDate"), rst.getString("openTime"), rst.getDouble("total"), rst.getString("accTypeID"), rst.getString("nic")));
            
        }
        return accounts;
    }
    
    private void comboSelectEvent(){
        
    }
}
