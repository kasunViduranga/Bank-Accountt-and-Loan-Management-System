/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.AccountDTO;
import lk.ijse.student.bmgts.model.InstalmentpaymentDTO;

/**
 *
 * @author Kasun
 */
public interface InstalmentpaymentBO extends SuperBO{
    
    public boolean addInstalmentpayment(InstalmentpaymentDTO dto) throws Exception;

    public boolean deleteInstalmentpayment(String id) throws Exception;

    public boolean updateInstalmentpayment(InstalmentpaymentDTO dto) throws Exception;

    public InstalmentpaymentDTO searchInstalmentpayment(String id) throws Exception;

    public ArrayList<InstalmentpaymentDTO> getAllInstalmentpayment() throws Exception;
}
