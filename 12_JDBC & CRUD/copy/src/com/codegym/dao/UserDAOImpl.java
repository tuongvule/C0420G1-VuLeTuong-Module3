package com.codegym.dao;

import com.codegym.model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String GET_USER_BY_ID = "{CALL get_user_by_id(?)}";
    private static final String INSERT_USER_STORE = "{CALL insert_user(?,?,?)}";

    private BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_SQL = "SELECT id, `name`, email, country FROM users;";
    private static final String SAVE_SQL =
                    "insert into users (`name`, email, country)" +
                    "value (?, ? , ?)";
    private static final String FIND_BY_ID_SQL = "SELECT id, `name`, email, country FROM users where id = ?;";
    private static final String UPDATE_SQL =
                    "UPDATE users " +
                    "SET `name` = ?, email = ?, country = ? " +
                    "WHERE (id = ?);";
    private static final String REMOVE_SQL = "DELETE FROM users WHERE (`id` = ?);";
    private static final String FIND_BY_COUNTRY_SQL = "SELECT id, `name`, email, country FROM users where country like concat ('%',?,'%');";
    private static final String SORT_BY_NAME_SQL = "SELECT id, `name`, email, country FROM users ORDER BY `name`;";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (`name`, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(FIND_ALL_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();// resultSet chứa kq trả về sau khi thực thi SQL

            User user = null; // để hứng kết quả, đặt là null vì chưa biết có hay không;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(SAVE_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public User findById(int id) {
        User user = new User();
        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(FIND_BY_ID_SQL);
            preparedStatement.setInt(1, id);
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
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(REMOVE_SQL);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {

        User user = null;

        try (Connection connection = baseDAO.getConnection();

             // Step 2:Create a statement using connection object

             CallableStatement callableStatement = connection.prepareCall(GET_USER_BY_ID);) {

            callableStatement.setInt(1, id);

            // Step 3: Execute the query or update query

            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                user = new User(id, name, email, country);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return user;


    }

    @Override
    public void insertUserStore(User user) throws SQLException {

        try (Connection connection = baseDAO.getConnection();

             CallableStatement callableStatement = connection.prepareCall(INSERT_USER_STORE);) {

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace() ;

        }


    }

    @Override
    public List<User> findByCountry(String country) {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(FIND_BY_COUNTRY_SQL);
            preparedStatement.setString(1, String.valueOf(country));
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

//    @Override
//    public void addUserTransaction(User user, int[] permision) {
//        Connection conn = null;
//
//        // for insert a new user
//
//        PreparedStatement pstmt = null;
//
//        // for assign permision to user
//
//        PreparedStatement pstmtAssignment = null;
//
//        // for getting user id
//
//        ResultSet rs = null;
//
//        try {
//
//            conn = baseDAO.getConnection();
//
//            // set auto commit to false
//
//            conn.setAutoCommit(false);
//
//            //
//
//            // Insert user
//
//            //
//
//            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
//
//            pstmt.setString(1, user.getName());
//
//            pstmt.setString(2, user.getEmail());
//
//            pstmt.setString(3, user.getCountry());
//
//            int rowAffected = pstmt.executeUpdate();
//
//            // get user id
//
//            rs = pstmt.getGeneratedKeys();
//
//            int userId = 0;
//
//            if (rs.next())
//
//                userId = rs.getInt(1);
//
//            //
//
//            // in case the insert operation successes, assign permision to user
//
//            //
//
//            if (rowAffected == 1) {
//
//                // assign permision to user
//
//                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "
//
//                        + "VALUES(?,?)";
//
//                pstmtAssignment = conn.prepareStatement(sqlPivot);
//
//                for (int permisionId : permision) {
//
//                    pstmtAssignment.setInt(1, userId);
//
//                    pstmtAssignment.setInt(2, permisionId);
//
//                    pstmtAssignment.executeUpdate();
//
//                }
//
//                conn.commit();
//                conn.setAutoCommit(true);
//
//            } else {
//
//                conn.rollback();
//
//            }
//
//        } catch (SQLException ex) {
//
//            // roll back the transaction
//
//            try {
//
//                if (conn != null)
//
//                    conn.rollback();
//
//            } catch (SQLException e) {
//
//                System.out.println(e.getMessage());
//
//            }
//
//            System.out.println(ex.getMessage());
//
//        } finally {
//
//            try {
//
//                if (rs != null) rs.close();
//
//                if (pstmt != null) pstmt.close();
//
//                if (pstmtAssignment != null) pstmtAssignment.close();
//
//                if (conn != null) conn.close();
//
//            } catch (SQLException e) {
//
//                System.out.println(e.getMessage());
//
//            }
//
//        }
//    }
//
//    @Override
//    public void insertUpdateWithoutTransaction() {
//
//        try (Connection conn = baseDAO.getConnection();
//
//             Statement statement = conn.createStatement();
//
//             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
//
//             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {
//
//
//
//            statement.execute(SQL_TABLE_DROP);
//
//            statement.execute(SQL_TABLE_CREATE);
//
//
//
//            // Run list of insert commands
//
//            psInsert.setString(1, "Quynh");
//
//            psInsert.setBigDecimal(2, new BigDecimal(10));
//
//            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//
//            psInsert.execute();
//
//
//
//            psInsert.setString(1, "Ngan");
//
//            psInsert.setBigDecimal(2, new BigDecimal(20));
//
//            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//
//            psInsert.execute();
//
//
//
//            // Run list of update commands
//
//
//
//            // below line caused error, test transaction
//
//            // org.postgresql.util.PSQLException: No value specified for parameter 1.
//
//            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
//
//
//
//            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
//
//            psUpdate.setString(2, "Quynh");
//
//            psUpdate.execute();
//
//
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }
//
//    }
//
//    @Override
//    public void insertUpdateUseTransaction() {
//        try (Connection conn = baseDAO.getConnection();
//
//             Statement statement = conn.createStatement();
//
//             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
//
//             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {
//
//            statement.execute(SQL_TABLE_DROP);
//
//            statement.execute(SQL_TABLE_CREATE);
//
//            // start transaction block
//
//            conn.setAutoCommit(false); // default true
//
//            // Run list of insert commands
//
//            psInsert.setString(1, "Quynh");
//
//            psInsert.setBigDecimal(2, new BigDecimal(10));
//
//            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//
//            psInsert.execute();
//
//
//
//            psInsert.setString(1, "Ngan");
//
//            psInsert.setBigDecimal(2, new BigDecimal(20));
//
//            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//
//            psInsert.execute();
//
//
//
//            // Run list of update commands
//
//
//
//            // below line caused error, test transaction
//
//            // org.postgresql.util.PSQLException: No value specified for parameter 1.
//
//            psUpdate.setBigDecimal(1, new BigDecimal(999.99));
//
//
//
//            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
//
//            psUpdate.setString(2, "Quynh");
//
//            psUpdate.execute();
//
//
//
//            // end transaction block, commit changes
//
//            conn.commit();
//
//            // good practice to set it back to default true
//
//            conn.setAutoCommit(true);
//
//
//
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//
//            e.printStackTrace();
//
//        }
//
//    }
//
//    @Override
//    public List<User> getAll() {
//        User user = null;
//        List<User> list = new ArrayList<>();
//        String query = "{CALL get_user()}";
//
//        try {
//            Connection connection = baseDAO.getConnection();
//            CallableStatement callableStatement = connection.prepareCall(query);
//            ResultSet rs = callableStatement.executeQuery();
//            while (rs.next()) {
//                Integer id = rs.getInt("id");
//
//                String name = rs.getString("name");
//
//                String email = rs.getString("email");
//
//                String country = rs.getString("country");
//
//                user = new User(id, name, email, country);
//                list.add(user);
//            }
//            connection.close();
//            return list;
//
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        return null;
//        }
//
//
//    }
}
