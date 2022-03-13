package by.tms.servise;

import by.tms.dao.InMemoryUserDAO;
import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserServise {

    public boolean saveUser(User user){
       return InMemoryUserDAO.getInstance().saveUser(user);
    }

    public Optional<User> getUserByUsername(String username){
        return InMemoryUserDAO.getInstance().getUserByUsername(username);
    }
}
