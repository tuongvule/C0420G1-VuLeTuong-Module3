package dao;

import model.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO{
    BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_SERVICE = "select * from services";
    private static final String ADD_NEW_SERVICE = "insert into services (name_service,area,floor,number_of_people,cost," +
            "status,id_type_of_rent,id_type_of_service) value (?,?,?,?,?,?,?,?)";

    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        Service service = null;
        try {
            PreparedStatement preparedStatement = baseDAO.getConnection().prepareStatement(FIND_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                service = new Service();
                service.setId(resultSet.getInt("id_service"));
                service.setName(resultSet.getString("name_service"));
                service.setArea(resultSet.getInt("area"));
                service.setFloor(resultSet.getInt("floor"));
                service.setNumberOfPeople(resultSet.getString("number_of_people"));
                service.setCost(resultSet.getString("cost"));
                service.setStatus(resultSet.getString("status"));
                service.setIdRentType(resultSet.getInt("id_type_of_rent"));
                service.setIdServiceType(resultSet.getInt("id_type_of_service"));
                serviceList.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void add(Service service) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(ADD_NEW_SERVICE);
            preparedStatement.setString(1,service.getName());
            preparedStatement.setInt(2,service.getArea());
            preparedStatement.setInt(3,service.getFloor());
            preparedStatement.setString(4,service.getNumberOfPeople());
            preparedStatement.setString(5, service.getCost());
            preparedStatement.setString(6, service.getStatus());
            preparedStatement.setInt(7,service.getIdRentType());
            preparedStatement.setInt(8,service.getIdServiceType());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
