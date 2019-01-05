/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.InstalmentpaymentDAO;
import lk.ijse.student.bmgts.model.entity.Instalmentpayment;

/**
 *
 * @author Kasun
 */
public class InstalmentpaymentDAOImpl implements InstalmentpaymentDAO{

    @Override
    public boolean add(Instalmentpayment entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO instalmentpayment VALUES(?,?,?,?,?)", entity.getLoanPayID_PK(),
                entity.getLoanNum_FK(),entity.getPaydate(),entity.getPayPersNIC(),entity.getPayAmount());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Instalmentpayment entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Instalmentpayment serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Instalmentpayment> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
