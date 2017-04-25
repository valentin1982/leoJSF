package leo.dao;

import leo.model.User;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAOimpl implements UserDAO {

    final private static Logger loger = Logger.getLogger(UserDAOimpl.class);

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("users");
    private EntityManager em = factory.createEntityManager();

    @Override
    public User checkLogin(String login, String password) {
        try {
            User user = (User) em.createQuery("SELECT u from User u where u.login = :login and u.password = :password").setParameter("login", login).setParameter("password", password).getSingleResult();
            return user;
        } catch (NoResultException e) {
            loger.error("UserDAOimpl checkLogin :" + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = em.createQuery("Select u From User u", User.class).getResultList();
        return users;
    }

    @Override
    public boolean inserirUser(User user) {
        try {
            em.persist(user);
            return true;
        } catch (Exception e) {
            loger.error("UserDAOimpl inserirUser :" + e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public boolean deleteUser(User user) {
        try {
            em.remove(user);
            return true;
        } catch (Exception e) {
            loger.error("UserDAOimpl deleUser " + e.getLocalizedMessage());
            return false;
        }
    }

}
