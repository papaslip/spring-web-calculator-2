package by.tms.dao;

import by.tms.entity.User;

import java.util.Optional;

public interface UserDAO {
    public boolean saveUser(User user);
    public Optional<User> getUserByUsername(String username);
}
