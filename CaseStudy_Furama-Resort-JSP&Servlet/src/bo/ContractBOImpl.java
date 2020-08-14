package bo;

import dao.ContractDAO;
import dao.ContractDAOImpl;
import model.Contract;

import java.util.List;

public class ContractBOImpl implements ContractBO {
    ContractDAO contractDAO = new ContractDAOImpl();
    @Override
    public List<Contract> findAll() {
        return this.contractDAO.findAll();
    }

    @Override
    public void add(Contract contract) {
        this.contractDAO.add(contract);
    }
}
