package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.User;

import java.util.List;
import java.util.Optional;

public interface OperationDAO {
    public boolean saveOperation(Operation operation);
    public void deleteOperationById(int id);
    public List<Operation> getOperationsByUsername(String username);
}
