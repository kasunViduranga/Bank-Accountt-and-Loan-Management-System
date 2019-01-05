/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.custom.InstalmentpaymentBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.InstalmentpaymentDAO;
import lk.ijse.student.bmgts.model.InstalmentpaymentDTO;
import lk.ijse.student.bmgts.model.entity.Instalmentpayment;

/**
 *
 * @author Kasun
 */
public class InstalmentpaymentBOImpl implements InstalmentpaymentBO{

    private InstalmentpaymentDAO instalmentpaymentDAO;
    
    
    public InstalmentpaymentBOImpl() throws Exception {
        instalmentpaymentDAO=(InstalmentpaymentDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.INSTALMENTPAYMENT);
        
        
    }
    
    

    @Override
    public boolean addInstalmentpayment(InstalmentpaymentDTO dto) throws Exception {
        Instalmentpayment instalmentpayment=new Instalmentpayment(dto.getLoanPayID(), dto.getLoanNum(), dto.getPaydate(), dto.getPayPersNIC(), dto.getPayAmount());
        return instalmentpaymentDAO.add(instalmentpayment);
    }

    @Override
    public boolean deleteInstalmentpayment(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateInstalmentpayment(InstalmentpaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InstalmentpaymentDTO searchInstalmentpayment(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<InstalmentpaymentDTO> getAllInstalmentpayment() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
