/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.TransactionDTO;

/**
 *
 * @author Kasun
 */
public interface TransactionBO extends SuperBO{
   
    public boolean addTransaction(TransactionDTO dto) throws Exception;

    public boolean deleteTransaction(String id) throws Exception;

    public boolean updateTransaction(TransactionDTO dto) throws Exception;

    public TransactionDTO searchTransaction(String id) throws Exception;

    public ArrayList<TransactionDTO> getAllTransaction() throws Exception;
    
    public ArrayList<String> getAllTransactionID() throws Exception;
}
