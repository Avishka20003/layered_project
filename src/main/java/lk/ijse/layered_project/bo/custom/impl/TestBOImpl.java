package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.TestBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.TestDAO;
import lk.ijse.layered_project.dto.TestDto;
import lk.ijse.layered_project.entity.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class TestBOImpl implements TestBO {

    TestDAO testDAO = (TestDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TEST);

    @Override
    public ArrayList<TestDto> getAllTest() throws SQLException, ClassNotFoundException {
        ArrayList<Test> tests = testDAO.getAll();
        ArrayList<TestDto> testDtos = new ArrayList<>();
        for (Test test : tests) {
            testDtos.add(new TestDto(
                    test.getId(),
                    test.getMother_id(),
                    test.getName()
            ));
        }
        return testDtos;
    }

    @Override
    public boolean saveTest(TestDto dto) throws SQLException, ClassNotFoundException {
        return testDAO.save(new Test(
                dto.getId(),
                dto.getMother_id(),
                dto.getName()));
    }

    @Override
    public boolean updateTest(TestDto dto) throws SQLException, ClassNotFoundException {
        return testDAO.update(new Test(
                dto.getId(),
                dto.getMother_id(),
                dto.getName()));
    }

    @Override
    public boolean deleteTest(String id) throws SQLException, ClassNotFoundException {
        return testDAO.delete(id);
    }
}
