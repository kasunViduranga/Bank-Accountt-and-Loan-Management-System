/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.dao;

import lk.ijse.student.bmgts.dao.custom.impl.AccountDAoImpl;
import lk.ijse.student.bmgts.dao.custom.impl.AccountTypeDAOImpl;
import lk.ijse.student.bmgts.dao.custom.impl.CustomerAccountDetailsDAOImpl;
import lk.ijse.student.bmgts.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.student.bmgts.dao.custom.impl.GarenterDAOImpl;
import lk.ijse.student.bmgts.dao.custom.impl.InstalmentpaymentDAOImpl;
import lk.ijse.student.bmgts.dao.custom.impl.LoanDAOImpl;
import lk.ijse.student.bmgts.dao.custom.impl.LoanTypeDAOImpl;
import lk.ijse.student.bmgts.dao.custom.impl.TransactionDAOImpl;

/**
 *
 * @author Kasun
 */
public class DAOFactory {

    private static DAOFactory daof;

    public enum DAOFactypes {
        LOAN_TYPE, ACCOUNT_TYPE, ACCOUNT, CUSTOMER, CUSTOMERACCOUNTDETAILS, GARENTER, LOAN, Transaction, INSTALMENTPAYMENT;
    }

    public static DAOFactory getDAOFactory() {
        if (daof == null) {
            daof = new DAOFactory();
        }
        return daof;
    }

    public SuperDAO getSuperDAO(DAOFactypes types) throws Exception {
        switch (types) {
            case LOAN_TYPE:
                return new LoanTypeDAOImpl();
            case ACCOUNT_TYPE:
                return new AccountTypeDAOImpl();
            case ACCOUNT:
                return new AccountDAoImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case CUSTOMERACCOUNTDETAILS:
                return new CustomerAccountDetailsDAOImpl();
            case GARENTER:
                return new GarenterDAOImpl();
            case LOAN:
                return new LoanDAOImpl();
            case Transaction:
                return new TransactionDAOImpl();
            case INSTALMENTPAYMENT:
                return new InstalmentpaymentDAOImpl();

            default:
                return null;

        }
    }

}
