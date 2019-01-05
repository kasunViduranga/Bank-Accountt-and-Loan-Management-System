/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.BOFactory;
import lk.ijse.student.bmgts.business.custom.GarenterBO;
import lk.ijse.student.bmgts.dao.DAOFactory;
import lk.ijse.student.bmgts.dao.custom.GarenterDAO;
import lk.ijse.student.bmgts.model.AccountDTO;
import lk.ijse.student.bmgts.model.GarenterDTO;
import lk.ijse.student.bmgts.model.entity.Garenter;

/**
 *
 * @author Kasun
 */
public class GarenterBOImpl implements GarenterBO{
    
    private GarenterDAO superDAO;
    
    public GarenterBOImpl() throws Exception {
        superDAO=(GarenterDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.GARENTER);
    }
    
    

    @Override
    public boolean addGarente(GarenterDTO dto) throws Exception {
        Garenter garenter= new Garenter(
                dto.getGarenterID(), 
                dto.getFirstName(), 
                dto.getLastName(), 
                dto.getAddress(), 
                dto.getNic(), 
                dto.getDob(), 
                dto.getMobNum(), 
                dto.getHomeTell(), 
                dto.getGender(), 
                dto.getJob(), 
                dto.getMonthSalary(), 
                dto.getPaysheetNum());
        return superDAO.add(garenter);
    }
    
    @Override
    public boolean deleteGarente(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateGarente(GarenterDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDTO searchGarente(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GarenterDTO> getAllGarente() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllGarenteID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
