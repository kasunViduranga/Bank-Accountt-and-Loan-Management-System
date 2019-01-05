/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.LoanDTO;

/**
 *
 * @author Kasun
 */
public interface LoanBO extends SuperBO{
    public boolean addLoan(LoanDTO dto) throws Exception;

    public boolean deleteLoan(String id) throws Exception;

    public boolean updateLoan(LoanDTO dto) throws Exception;

    public LoanDTO searchLoan(String id) throws Exception;

    public ArrayList<LoanDTO> getAllLoan() throws Exception;
    
    public ArrayList<String> getAllLoanID() throws Exception;
}
