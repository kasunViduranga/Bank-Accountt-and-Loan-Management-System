/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.GarenterDAO;
import lk.ijse.student.bmgts.model.entity.Garenter;

/**
 *
 * @author Kasun
 */
public class GarenterDAOImpl implements GarenterDAO{

    @Override
    public boolean add(Garenter entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into garenter values(?,?,?,?,?,?,?,?,?,?,?,?)",
                entity.getGarenterID_PK(), 
                entity.getFirstName(),
                entity.getLastName(), 
                entity.getAddress(), 
                entity.getNic(), 
                entity.getDob(), 
                entity.getMobNum(), 
                entity.getHomeTell(),
                entity.getGender(), 
                entity.getJob(), 
                entity.getMonthSalary(), 
                entity.getPaysheetNum());
    }
    
    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Garenter entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Garenter serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Garenter> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
