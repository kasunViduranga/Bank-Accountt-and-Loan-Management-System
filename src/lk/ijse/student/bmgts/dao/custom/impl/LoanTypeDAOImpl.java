/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.LoanTypeDAO;
import lk.ijse.student.bmgts.model.entity.LoanType;

/**
 *
 * @author Kasun
 */
public class LoanTypeDAOImpl implements LoanTypeDAO{

    @Override
    public boolean add(LoanType entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into loanType values(?,?,?,?,?,?)", entity.getLoanTypeID_PK(),entity.getLoanType(),entity.getDuration(),entity.getRateCharge(),entity.getMaxAmount(),entity.getMinMonthSalary());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("Delete from loanType where loanTypeId=? ", id);
    }

    @Override
    public boolean update(LoanType entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE loanType SET loanType=?, duration=?, rateCharge=?, maxAmount=?, minMonthSalary=? WHERE loanTypeID=?", entity.getLoanType(),
                entity.getDuration(),entity.getRateCharge(),entity.getMaxAmount(),entity.getMinMonthSalary(),entity.getLoanTypeID_PK());
    }

    @Override
    public LoanType serch(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from LoanType where loanTypeID=?", id);
       
        if(rst.next()){
            String loanTypeID_PK= rst.getString("loanTypeID");
            String loanType= rst.getString("LoanType");
            int duration= rst.getInt("duration");
            double rateCharge= rst.getDouble("rateCharge");
            double maxAmount=rst.getDouble("maxAmount");
            double minMonthSalary=rst.getDouble("minMonthSalary");
           
            LoanType loType=new LoanType(loanTypeID_PK, loanType, duration, rateCharge, maxAmount, minMonthSalary);
            return loType;
        }else{
            return null;
        }
        
    }

    @Override
    public ArrayList<LoanType> getAll() throws Exception {
        ArrayList<LoanType> loanType= new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from loanType");
        while (rst.next()) {
            loanType.add(new LoanType(rst.getString("loanTypeID"), rst.getString("loanType"), rst.getInt("duration"), rst.getDouble("rateCharge"), rst.getDouble("maxAmount"), rst.getDouble("minMonthSalary")));
        }
        return loanType;
    }

   

       
}
