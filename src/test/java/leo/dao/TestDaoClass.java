package leo.dao;

import leo.config.AppConfig;
import leo.model.User;
import leo.utils.Sha1Utils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)
public class TestDaoClass  {

    @Autowired
    private UserDAO userDAOimpl;

    private User defaultUser = new User();

    private List<User> users = new ArrayList<>();


    @Before
    public void setup() {
        String password = Sha1Utils.encryptPassword("test");
        defaultUser.setId(1L);
        defaultUser.setLogin("test");
        defaultUser.setPassword(password);
        defaultUser.setName("test");
        userDAOimpl.inserirUser(defaultUser);
    }

    @Test
    @Transactional
    public void inserirUser() throws Exception {
        User user = new User();
        user.setId(6L);
        user.setLogin("test");
        user.setPassword("test");
        user.setName("test");
        userDAOimpl.inserirUser(user);
        assertNotNull(user);
    }

    @Test
    @Rollback(true)
    public void testUser() throws Exception {
        User user = userDAOimpl.getUserById(defaultUser.getId());
        assertNotNull(user);
        assertEquals(defaultUser.getName(), user.getName());
    }

    @Test
    @Rollback(true)
    public void checkLogin() throws Exception {
        User user = userDAOimpl.getUserById(defaultUser.getId());
        assertNotNull(user);
        assertEquals(defaultUser.getLogin(), user.getLogin());
    }

    @Test
    @Rollback(true)
    public void checkPassword() throws Exception {
        User user = userDAOimpl.getUserById(defaultUser.getId());
        assertNotNull(user);
        assertEquals(defaultUser.getPassword(), user.getPassword());
    }

    @Test
    @Rollback(true)
    public void getAllUsers() throws Exception {
        users = userDAOimpl.getAllUsers();
        assertEquals(3, users.size());
        assertEquals(defaultUser.getName(), users.get(0).getName());
    }

    @Test
    @Rollback(true)
    @Transactional
    public void getUserById() throws Exception {
        users = userDAOimpl.getAllUsers();
        assertEquals(3, users.size());
        assertEquals(defaultUser.getId(), users.get(0).getId());
    }

    @Test
    @Rollback(true)
    public void deleteUser() {
        User user = new User();
        user.setId(5L);
        user.setLogin("test");
        user.setPassword("test");
        user.setName("test");

        userDAOimpl.deleteUser(user);
        User userNull = userDAOimpl.getUserById(5L);
        assertNull(userNull);

    }

}
