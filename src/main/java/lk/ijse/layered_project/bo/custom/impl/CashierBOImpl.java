package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.CashierBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.CashierDAO;
import lk.ijse.layered_project.dto.CashierDto;
import lk.ijse.layered_project.entity.Cashier;

import java.sql.SQLException;
import java.util.ArrayList;

public class CashierBOImpl implements CashierBO {

    CashierDAO cashierDAO = (CashierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CASHIER);

    @Override
    public boolean saveCashier(CashierDto dto) throws SQLException, ClassNotFoundException {
        return cashierDAO.save(new Cashier(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact()
        ));
    }

    @Override
    public boolean updateCashier(CashierDto dto) throws SQLException, ClassNotFoundException {
        return cashierDAO.update(new Cashier(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact()
        ));
    }

    @Override
    public boolean deleteCashier(int id) throws SQLException, ClassNotFoundException {
        return cashierDAO.delete(id);
    }

    @Override
    public ArrayList<CashierDto> getAllCashier() throws SQLException, ClassNotFoundException {
        ArrayList<Cashier> cashiers = cashierDAO.getAll();
        ArrayList<CashierDto> cashierDtos = new ArrayList<>();
        for (Cashier cashier : cashiers) {
            cashierDtos.add(new CashierDto(
                    cashier.getId(),
                    cashier.getName(),
                    cashier.getAddress(),
                    cashier.getContact()
            ));
        }
        return cashierDtos;
    }
}
