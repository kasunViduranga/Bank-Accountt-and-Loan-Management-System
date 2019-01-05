/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.TransactionDAO;
import lk.ijse.student.bmgts.model.entity.Transaction;

/**
 *
 * @author Kasun
 */
public class TransactionDAOImpl implements TransactionDAO{

    @Override
    public boolean add(Transaction entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO transaction VALUES(?,?,?,?,?,?,?)", entity.getTranId_PK(), 
                entity.getTranType(), entity.getAccNum_FK(), entity.getTranFee(), entity.getTranDate(), entity.getTranTime(), entity.getTranPersNIC());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Transaction entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transaction> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
