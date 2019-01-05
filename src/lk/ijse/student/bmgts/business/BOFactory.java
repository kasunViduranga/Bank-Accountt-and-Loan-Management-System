/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business;

import lk.ijse.student.bmgts.business.custom.impl.AccountBOImpl;
import lk.ijse.student.bmgts.business.custom.impl.AccountTypeBOImpl;
import lk.ijse.student.bmgts.business.custom.impl.CustomerAccountDetailsBOImpl;
import lk.ijse.student.bmgts.business.custom.impl.CustomerBOImpl;
import lk.ijse.student.bmgts.business.custom.impl.GarenterBOImpl;
import lk.ijse.student.bmgts.business.custom.impl.InstalmentpaymentBOImpl;
import lk.ijse.student.bmgts.business.custom.impl.LoanBOImpl;
import lk.ijse.student.bmgts.business.custom.impl.LoanTypeBOImpl;
import lk.ijse.student.bmgts.business.custom.impl.TransactionBOImpl;

/**
 *
 * @author Kasun
 */
public class BOFactory {
    
    private static BOFactory bOFactory;

    public enum BOTypes {
        LOAN_TYPE, ACCOUNT_TYPE, ACCOUNT, CUSTOMER, CUSTOMERACCOUNTDETAILS, LOAN, GARENTER, Transaction, INSTALMENTPAYMENT;
    }

    public static BOFactory getBOFactory() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public SuperBO getSuperBO(BOTypes types) throws Exception {
        switch (types) {
            case LOAN_TYPE:
                return new LoanTypeBOImpl();
            case ACCOUNT_TYPE:
                return new AccountTypeBOImpl();
            case ACCOUNT:
                return new AccountBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case CUSTOMERACCOUNTDETAILS:
                return new CustomerAccountDetailsBOImpl();
            case LOAN:
                return new LoanBOImpl();
            case GARENTER:
                return new GarenterBOImpl();
            case Transaction:
                return new TransactionBOImpl();
            case INSTALMENTPAYMENT:
                return new InstalmentpaymentBOImpl();
            
            default:
                return null;
        }

    }
}
