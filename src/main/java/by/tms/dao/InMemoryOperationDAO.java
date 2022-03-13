package by.tms.dao;

import by.tms.entity.Operation;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryOperationDAO implements OperationDAO{
    private static volatile InMemoryOperationDAO instance;
    private final Map<Integer, Operation> dataSource = new ConcurrentHashMap<>();
    private static AtomicInteger idOperation = new AtomicInteger(0);

    private InMemoryOperationDAO(){
    }

    public static InMemoryOperationDAO getInstance(){
        if(instance==null){
            synchronized (InMemoryOperationDAO.class){
                instance = new InMemoryOperationDAO();
                return instance;
            }
        }
        return instance;
    }

    @Override
    public boolean saveOperation(Operation operation) {
        operation.setId(idOperation.incrementAndGet());
        return dataSource.putIfAbsent(operation.getId(), operation) == null;
    }

    @Override
    public void deleteOperationById(int id) {
        dataSource.remove(id);
    }

    @Override
    public List<Operation> getOperationsByUsername(String username) {
        List<Operation> operations= dataSource.values()
                .stream()
                .filter(currentOperation -> currentOperation.getUsername().equals(username)).collect(Collectors.toList());
        return operations;
    }
}
