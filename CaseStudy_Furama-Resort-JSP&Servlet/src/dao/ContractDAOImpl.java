package dao;

import model.Contract;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements  ContractDAO{
    BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_CONTRACT = "select * from contracts";
    private static final String ADD_NEW_CONTRACT = "insert into contracts (contract_start_date,contract_end_date,deposit," +
            "total_money,id_employee,id_customer,id_service) value (?,?,?,?,?,?,?)";

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Contract contract = null;
        try {
            PreparedStatement preparedStatement = baseDAO.getConnection().prepareStatement(FIND_ALL_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                contract = new Contract();
                contract.setId(resultSet.getInt("id_contract"));
                contract.setStartDate(resultSet.getString("contract_start_date"));
                contract.setEndDate(resultSet.getString("contract_end_date"));
                contract.setDeposit(resultSet.getInt("deposit"));
                contract.setTotalMoney(resultSet.getInt("total_money"));
                contract.setIdEmployee(resultSet.getInt("id_employee"));
                contract.setIdCustomer(resultSet.getInt("id_customer"));
                contract.setIdService(resultSet.getInt("id_service"));
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public void add(Contract contract) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(ADD_NEW_CONTRACT);
            preparedStatement.setString(1,contract.getStartDate());
            preparedStatement.setString(2,contract.getEndDate());
            preparedStatement.setInt(3,contract.getDeposit());
            preparedStatement.setInt(4,contract.getTotalMoney());
            preparedStatement.setInt(5, contract.getIdEmployee());
            preparedStatement.setInt(6, contract.getIdCustomer());
            preparedStatement.setInt(7,contract.getIdService());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
