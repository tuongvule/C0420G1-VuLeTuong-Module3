package dao;

import model.Contract;
import model.Service;

import java.util.List;

public interface ContractDAO {
    List<Contract> findAll();
    void add(Contract contract);
}
