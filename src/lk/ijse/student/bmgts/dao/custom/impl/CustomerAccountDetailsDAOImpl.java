/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.CustomerAccountDetailsDAO;
import lk.ijse.student.bmgts.model.entity.CustomerAccountDetails;

/**
 *
 * @author Kasun
 */
public class CustomerAccountDetailsDAOImpl implements CustomerAccountDetailsDAO{

    @Override
    public boolean add(CustomerAccountDetails entity) throws Exception {
       return CrudUtil.executeUpdate("insert into cusaccDetails values(?,?,?)", entity.getCusAccDetailsID_PK(),
                entity.getCusID_FK(),entity.getAccNum_FK());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CustomerAccountDetails entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerAccountDetails serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerAccountDetails> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
