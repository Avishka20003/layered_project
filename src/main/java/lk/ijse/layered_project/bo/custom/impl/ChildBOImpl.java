package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.ChildBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.ChildDAO;
import lk.ijse.layered_project.dao.custom.impl.ChildDAOImpl;
import lk.ijse.layered_project.dto.ChildDto;
import lk.ijse.layered_project.entity.Child;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChildBOImpl implements ChildBO {

    ChildDAO childDAO = (ChildDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHILD);
    @Override
    public ArrayList<ChildDto> getAllChild() throws SQLException, ClassNotFoundException {
        ArrayList<Child> child = childDAO.getAll();
        ArrayList<ChildDto> childDtos = new ArrayList<>();
        for (Child c : child) {
            childDtos.add(new ChildDto(
                    c.getChild_id(),
                    c.getMother_id(),
                    c.getFather_id(),
                    c.getName(),
                    c.getAddress(),
                    c.getBirth_place(),
                    c.getGender(),
                    c.getDob(),
                    c.getBirth_height(),
                    c.getBirth_weight(),
                    c.getNote(),
                    c.getBlood_type()

            ));
        }
        return childDtos;
    }

    @Override
    public boolean saveChild(ChildDto dto) throws SQLException, ClassNotFoundException {
        return childDAO.save(new Child(
                dto.getChild_id(),
                dto.getMother_id(),
                dto.getFather_id(),
                dto.getName(),
                dto.getAddress(),
                dto.getBirth_place(),
                dto.getGender(),
                dto.getDob(),
                dto.getBirth_height(),
                dto.getBirth_weight(),
                dto.getNote(),
                dto.getBlood_type()
        ));
    }

    @Override
    public boolean updateChild(ChildDto dto) throws SQLException, ClassNotFoundException {
        return childDAO.update(new Child(
                dto.getChild_id(),
                dto.getMother_id(),
                dto.getFather_id(),
                dto.getName(),
                dto.getAddress(),
                dto.getBirth_place(),
                dto.getGender(),
                dto.getDob(),
                dto.getBirth_height(),
                dto.getBirth_weight(),
                dto.getNote(),
                dto.getBlood_type()
        ));
    }

    @Override
    public boolean deleteChild(int id) throws SQLException, ClassNotFoundException {
        return childDAO.delete(id);
    }
}
