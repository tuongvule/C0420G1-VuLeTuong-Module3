package dao;

import model.RentType;
import model.ServiceType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDAOImpl implements ServiceTypeDAO{
    BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_SERVICE_TYPE = "select * from type_of_services";
    @Override
    public List <ServiceType> findAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        ServiceType serviceType = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                serviceType = new ServiceType();
                serviceType.setId(resultSet.getInt("id_type_of_service"));
                serviceType.setNameServiceType(resultSet.getString("name_type_of_service"));
                serviceTypeList.add(serviceType);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceTypeList;
    }
}
