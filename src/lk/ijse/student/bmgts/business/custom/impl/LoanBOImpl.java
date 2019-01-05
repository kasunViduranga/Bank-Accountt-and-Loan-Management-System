/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.custom.LoanBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.LoanDAO;
import lk.ijse.student.bmgts.model.AccountDTO;
import lk.ijse.student.bmgts.model.LoanDTO;
import lk.ijse.student.bmgts.model.entity.Loan;

/**
 *
 * @author Kasun
 */
public class LoanBOImpl implements LoanBO{
    
    private LoanDAO loanDAO;
    public LoanBOImpl() throws Exception {
        loanDAO=(LoanDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.LOAN);
    }
    
    

    @Override
    public boolean addLoan(LoanDTO dto) throws Exception {
        Loan loan=new Loan(
                dto.getLoanNum(), 
                dto.getCusID(), 
                dto.getLoanAmount(), 
                dto.getStartDate(), 
                dto.getFirstGarenterID(), 
                dto.getSecondGarenterID(), 
                dto.getLoanTypeID(), 
                dto.getDuration(), 
                dto.getInterestCharge(), 
                dto.getMonthlyPayment(), 
                dto.getPayDate(),
                dto.getTotal());
        return loanDAO.add(loan);
    }

    @Override
    public boolean deleteLoan(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateLoan(LoanDTO dto) throws Exception {
        return loanDAO.update(new Loan(
                dto.getLoanNum(), 
                dto.getCusID(), 
                dto.getLoanAmount(), 
                dto.getStartDate(), 
                dto.getFirstGarenterID(), 
                dto.getSecondGarenterID(), 
                dto.getLoanTypeID(), 
                dto.getDuration(),
                dto.getInterestCharge(), 
                dto.getMonthlyPayment(),
                dto.getPayDate(), 
                dto.getTotal()));
    }
    @Override
    public ArrayList<LoanDTO> getAllLoan() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllLoanID() throws Exception {
        ArrayList<Loan> loans=loanDAO.getAll();
        ArrayList<String> loanIdList=new ArrayList<>();
        for(Loan id:loans){
            loanIdList.add(id.getLoanNum_PK());
        }
        return loanIdList;
    }

    @Override
    public LoanDTO searchLoan(String id) throws Exception {
        Loan ref=loanDAO.serch(id);
        LoanDTO loanDTO=new LoanDTO(
                ref.getLoanNum_PK(), 
                ref.getCusID_FK(), 
                ref.getLoanAmount(),
                ref.getStartDate(), 
                ref.getFirstGarenterID_FK(),
                ref.getSecondGarenterID_FK(),
                ref.getLoanTypeID_FK(),
                ref.getDuration(),
                ref.getInterestCharge(),
                ref.getMonthlyPayment(),
                ref.getPayDate(),
                ref.getTotal());
        
        
        return loanDTO;
    }
    
}
