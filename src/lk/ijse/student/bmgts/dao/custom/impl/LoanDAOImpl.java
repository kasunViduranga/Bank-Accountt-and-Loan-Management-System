/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.student.bmgts.dao.CrudUtil;
import lk.ijse.student.bmgts.dao.custom.LoanDAO;
import lk.ijse.student.bmgts.model.entity.Loan;

/**
 *
 * @author Kasun
 */
public class LoanDAOImpl implements LoanDAO{

    @Override
    public boolean add(Loan entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO loan VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", 
                entity.getLoanNum_PK(), 
                entity.getCusID_FK(), 
                entity.getLoanAmount(), 
                entity.getStartDate(), 
                entity.getFirstGarenterID_FK(),
                entity.getSecondGarenterID_FK(),
                entity.getLoanTypeID_FK(),
                entity.getDuration(),
                entity.getInterestCharge(),
                entity.getMonthlyPayment(),
                entity.getPayDate(),
                entity.getTotal());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Loan entity) throws Exception {
        
        return CrudUtil.executeUpdate("UPDATE loan SET cusID=?, loanAmount=?, startDate=?, firstGarenterID=?, secondGarenterID=?, loanTypeID=?, duration=?, interestCharge=?, monthlyPayment=?, payDate=?, total=? WHERE loanNum=?", 
                entity.getCusID_FK(),
                entity.getLoanAmount(),
                entity.getStartDate(),
                entity.getFirstGarenterID_FK(),
                entity.getSecondGarenterID_FK(),
                entity.getLoanTypeID_FK(),
                entity.getDuration(),
                entity.getInterestCharge(),
                entity.getMonthlyPayment(),
                entity.getPayDate(),
                entity.getTotal(),
                entity.getLoanNum_PK());
    }

    @Override
    public Loan serch(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Loan where loanNum=?", id);
        if(rst.next()){
            String loanNum_PK=rst.getString("loanNum");
            String cusID_FK=rst.getString("cusID");
            double loanAmount=rst.getDouble("loanAmount");
            String startDate=rst.getString("startDate");
            String firstGarenterID_FK=rst.getString("firstGarenterID");
            String secondGarenterID_FK=rst.getString("secondGarenterID");
            String loanTypeID_FK=rst.getString("loanTypeID");
            int duration=rst.getInt("duration");
            double interestCharge=rst.getDouble("interestCharge");
            double monthlyPayment=rst.getDouble("monthlyPayment");
            String payDate=rst.getString("payDate");
            double total=rst.getDouble("total");
            
            Loan loan=new Loan(loanNum_PK, cusID_FK, loanAmount, startDate, 
                    firstGarenterID_FK, secondGarenterID_FK, loanTypeID_FK, duration, interestCharge, monthlyPayment, payDate, total);
            return loan;
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Loan> getAll() throws Exception {
        ArrayList<Loan> loans=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM loan");
        while (rst.next()){
           loans.add(new Loan(
                   rst.getString("loanNum"), 
                   rst.getString("cusID"), 
                   rst.getDouble("loanAmount"), 
                   rst.getString("startDate"), 
                   rst.getString("firstGarenterID"), 
                   rst.getString("secondGarenterID"), 
                   rst.getString("loanTypeID"), 
                   rst.getInt("duration"), 
                   rst.getDouble("interestCharge"), 
                   rst.getDouble("monthlyPayment"), 
                   rst.getString("payDate"), 
                   rst.getDouble("total")));
            
        }
        return loans;
    }
    
}