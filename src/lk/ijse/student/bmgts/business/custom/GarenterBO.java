/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.business.custom;

import java.util.ArrayList;
import lk.ijse.student.bmgts.business.SuperBO;
import lk.ijse.student.bmgts.model.AccountDTO;
import lk.ijse.student.bmgts.model.GarenterDTO;
import lk.ijse.student.bmgts.model.LoanDTO;

/**
 *
 * @author Kasun
 */
public interface GarenterBO extends SuperBO{
    public boolean addGarente(GarenterDTO dto) throws Exception;

    public boolean deleteGarente(String id) throws Exception;

    public boolean updateGarente(GarenterDTO dto) throws Exception;

    public AccountDTO searchGarente(String id) throws Exception;

    public ArrayList<GarenterDTO> getAllGarente() throws Exception;
    
    public ArrayList<String> getAllGarenteID() throws Exception;
}
