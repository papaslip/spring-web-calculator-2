package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Repository
@Transactional
public class DBUserDAO implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private static volatile DBUserDAO instance;

    public static DBUserDAO getInstance(){
        if(instance==null){
            synchronized (DBUserDAO.class){
                instance = new DBUserDAO();
                return instance;
            }
        }
        return instance;
    }

    @Override
    public boolean saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
        return true;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.empty();
    }
}
