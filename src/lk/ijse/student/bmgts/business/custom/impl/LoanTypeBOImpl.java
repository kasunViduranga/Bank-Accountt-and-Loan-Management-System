/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.custom.LoanTypeBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.LoanTypeDAO;
import lk.ijse.student.bmgts.model.LoanTypeDTO;
import lk.ijse.student.bmgts.model.entity.LoanType;

/**
 *
 * @author Kasun
 */
public class LoanTypeBOImpl implements LoanTypeBO{
    private LoanTypeDAO superDAO;
    
    public LoanTypeBOImpl() throws Exception{
        superDAO = (LoanTypeDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.LOAN_TYPE);
    }
    @Override
    public boolean addLoanType(LoanTypeDTO dto) throws Exception {
        LoanType loanType= new LoanType(dto.getLoanTypeID(), dto.getLoanType(), dto.getDuration(), dto.getRateCharge(), dto.getMaxAmount(),dto.getMinMonthSalary());
        return superDAO.add(loanType);
    }

    @Override
    public boolean deleteLoanType(String id) throws Exception {
       return superDAO.delete(id);
    }

    @Override
    public boolean updateLoanType(LoanTypeDTO dto) throws Exception {
        return superDAO.update(new LoanType(dto.getLoanTypeID(), dto.getLoanType(), dto.getDuration(), dto.getRateCharge(), dto.getMaxAmount(), dto.getMinMonthSalary()));
    }
    @Override
    public LoanTypeDTO searchLoanType(String id) throws Exception {
        LoanType ref=superDAO.serch(id);
        LoanTypeDTO loanDTO= new LoanTypeDTO(ref.getLoanTypeID_PK(),ref.getLoanType(),ref.getDuration(),ref.getRateCharge(),ref.getMaxAmount(),ref.getMinMonthSalary());
        return loanDTO;
    }

    @Override
    public ArrayList<LoanTypeDTO> getAllLoanType() throws Exception {
        ArrayList<LoanType> getAll=superDAO.getAll();
        ArrayList<LoanTypeDTO> loanDTO= new ArrayList<>();
        for (LoanType loanType : getAll) {
            loanDTO.add(new LoanTypeDTO(loanType.getLoanTypeID_PK(), loanType.getLoanType(), loanType.getDuration(), loanType.getRateCharge(), loanType.getMaxAmount(), loanType.getMinMonthSalary()));
        }
        return loanDTO;
    }

    @Override
    public ArrayList<String> getAllLoanTypeID() throws Exception {
        ArrayList<LoanType> loanTypes=superDAO.getAll();
        ArrayList<String> loanTypeIDList= new ArrayList<>();
        for (LoanType loanType : loanTypes) {
            loanTypeIDList.add(loanType.getLoanTypeID_PK());
        }
        return loanTypeIDList;
    } 
}
