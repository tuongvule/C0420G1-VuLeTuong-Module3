package bo;

import model.Contract;

import java.util.List;

public interface ContractBO {
    List<Contract> findAll();
    void add(Contract contract);
}
