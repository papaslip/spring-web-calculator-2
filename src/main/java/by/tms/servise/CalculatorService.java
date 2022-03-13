package by.tms.servise;

import by.tms.dao.InMemoryOperationDAO;
import by.tms.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CalculatorService {

    public boolean saveOperation(Operation operation){
        return InMemoryOperationDAO.getInstance().saveOperation(operation);
    }
    public void deleteOperationById(int id){
        InMemoryOperationDAO.getInstance().deleteOperationById(id);
    }

    public List<Operation> getOperationsByUsername(String username){
        List<Operation> operations = InMemoryOperationDAO.getInstance().getOperationsByUsername(username);
        return operations;
    }
}
