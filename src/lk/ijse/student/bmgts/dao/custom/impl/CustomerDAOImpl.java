/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.CustomerDAO;
import lk.ijse.student.bmgts.model.entity.Customer;

/**
 *
 * @author Kasun
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean add(Customer entity) throws Exception {
        return CrudUtil.executeUpdate("insert into customer Values(?,?,?,?,?,?,?,?,?)", entity.getCusID_PK(),
                entity.getFirstName(),entity.getLastName(),entity.getAddress(),entity.getOwnerType(),
                entity.getDob(),entity.getNic(),entity.getGender(),entity.getTell());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer serch(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from customer where cusID=?", id);
        if(rst.next()){
            String cusID_PK=rst.getString("cusID");
            String firstName=rst.getString("firstName");
            String lastName=rst.getString("lastName");
            String address=rst.getString("address");
            String ownerType=rst.getString("ownerType");
            String dob=rst.getString("dob");
            String nic=rst.getString("nic");
            String gender=rst.getString("gender");
            String tell=rst.getString("Tell");
            
            Customer customer=new Customer(cusID_PK, firstName, lastName, address, ownerType, dob, nic, gender, tell);
            return customer;
            
        }else{
            return null;
        }
    }
    
    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ArrayList<Customer> customers=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from customer");
        while(rst.next()){
            customers.add(new Customer(rst.getString("cusID"), rst.getString("firstName"), rst.getString("lastName"), 
                    rst.getString("address"), rst.getString("ownerType"), rst.getString("dob"), rst.getString("nic"), rst.getString("gender"), rst.getString("Tell")));
        }
        return customers;
    }
    
}
