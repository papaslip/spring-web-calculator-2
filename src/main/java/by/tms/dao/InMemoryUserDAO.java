package by.tms.dao;

import by.tms.entity.User;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class InMemoryUserDAO implements UserDAO{
    private static volatile InMemoryUserDAO instance;
    private final Map<Integer, User> dataSource = new ConcurrentHashMap<>();
    private static AtomicInteger idUser = new AtomicInteger(0);

    private InMemoryUserDAO(){
    }

    public static InMemoryUserDAO getInstance(){
        if(instance==null){
            synchronized (InMemoryUserDAO.class){
                instance = new InMemoryUserDAO();
                return instance;
            }
        }
        return instance;
    }


    @Override
    public boolean saveUser(User user) {
        user.setId(idUser.incrementAndGet());
        return dataSource.putIfAbsent(user.getId(), user) == null;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> optional = dataSource.values().stream().filter(currentUser -> currentUser.getUsername().equals(username)).findAny();
        return optional;
    }
}
