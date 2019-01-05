/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.LoanTypeDTO;

/**
 *
 * @author Kasun
 */
public interface LoanTypeBO extends SuperBO{
    
    public boolean addLoanType(LoanTypeDTO dto) throws Exception;

    public boolean deleteLoanType(String id) throws Exception;

    public boolean updateLoanType(LoanTypeDTO dto) throws Exception;

    public LoanTypeDTO searchLoanType(String id) throws Exception;

    public ArrayList<LoanTypeDTO> getAllLoanType() throws Exception;
    
    public ArrayList<String> getAllLoanTypeID() throws Exception;
    
    
}
