package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dto.CashierDto;
import lk.ijse.layered_project.entity.Cashier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CashierBO {

    public boolean saveCashier(CashierDto dto) throws SQLException, ClassNotFoundException ;

    public boolean updateCashier(CashierDto dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteCashier(int id) throws SQLException, ClassNotFoundException ;

    public ArrayList<CashierDto> getAllCashier() throws SQLException, ClassNotFoundException ;
}
