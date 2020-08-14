package dao;

import model.RentType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeDAOImpl implements RentTypeDAO{
    BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_TYPE_RENT = "select * from type_of_rents";
    @Override
    public List<RentType> findAll() {
        List<RentType> rentTypeList = new ArrayList<>();
        RentType rentType = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_TYPE_RENT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                rentType = new RentType();
                rentType.setId(resultSet.getInt("id_type_of_rent"));
                rentType.setNameRentType(resultSet.getString("name_type_of_rent"));
                rentType.setPrice(resultSet.getInt("price"));
                rentTypeList.add(rentType);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeList;
    }
}
