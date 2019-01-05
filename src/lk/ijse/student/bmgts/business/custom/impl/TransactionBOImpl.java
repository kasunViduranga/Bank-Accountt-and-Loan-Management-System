/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.custom.TransactionBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.TransactionDAO;
import lk.ijse.student.bmgts.model.TransactionDTO;
import lk.ijse.student.bmgts.model.entity.Transaction;

/**
 *
 * @author Kasun
 */
public class TransactionBOImpl implements TransactionBO{

    private TransactionDAO transactionDAO;
    public TransactionBOImpl() throws Exception{
        transactionDAO=(TransactionDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.Transaction);
    }
    
    

    @Override
    public boolean addTransaction(TransactionDTO dto) throws Exception {
        Transaction transaction=new Transaction(dto.getTranId(), dto.getTranType(), dto.getAccNum(), dto.getTranFee(), dto.getTranDate(), dto.getTranTime(), dto.getTranPersNIC());
        return transactionDAO.add(transaction);
    }

    @Override
    public boolean deleteTransaction(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTransaction(TransactionDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TransactionDTO searchTransaction(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TransactionDTO> getAllTransaction() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllTransactionID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
