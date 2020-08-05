package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String FIND_BY_ID_SQL = "SELECT id, `name`, email, country FROM users where id = ?;";

    private static final String FIND_ALL_SQL = "select id, `name`, email, country FROM users;";

    private static final String SAVE_SQL=
        "INSERT INTO users (`name`, email, country) " +
                "VALUES (?, ?, ?);";

    private static final String UPDATE_SQL=
        "UPDATE users " +
                "SET `name` = ?, email = ?, country = ? " +
                "WHERE (id = ?);";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(FIND_ALL_SQL);
//            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall();
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
//                user.setName(resultSet.getString(1));
//                user.setName(resultSet.getString(2));
//                user.setEmail(resultSet.getString(3));
//                user.setCountry(resultSet.getString(4));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        User user = new User();
        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(FIND_BY_ID_SQL);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(int id, User user) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setString(4, String.valueOf(user.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {

    }
}
