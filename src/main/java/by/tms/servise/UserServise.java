package by.tms.servise;

import by.tms.dao.InMemoryUserDAO;
import by.tms.entity.User;

import java.util.Optional;

public class UserServise {
    public boolean saveUser(User user){
       return InMemoryUserDAO.getInstance().saveUser(user);
    }
    public Optional<User> getUserByUsername(String username){
        return InMemoryUserDAO.getInstance().getUserByUsername(username);
    }
}
