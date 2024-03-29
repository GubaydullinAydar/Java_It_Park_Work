package ru.itpark.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.itpark.models.User;

import static org.junit.Assert.*;


public class UsersDaoJdbcImplTest {

    private UsersDaoJdbcImpl usersDao;

    private final int USER_5_ID = 5;
    private final int USER_10_ID = 10;
    private final String USER_5_Name = "Rustam";

    private final User USER_5 = new User(5, "Rustam", "33@mail", "123qwe");

    private final User USER = new User( 5,"Rustam", "33@mail.ru", "123qwe");

    @Before
    public void setUp() throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("test-db");
        context.load("ru.itpark\\context.xml");
        context.refresh();
        usersDao = context.getBean(UsersDaoJdbcImpl.class);
    }

    @Test
    public void testFindById() throws Exception {
        User actual = usersDao.find(USER_5_ID);
        User expected = USER_5;

        assertEquals(expected, actual);
    }

    @Test
    public void testFindByMail() throws Exception {
        User actual = usersDao.findByName(USER_5_Name);
        User expected = USER_5;

        assertEquals(expected, actual);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testDelete() throws Exception {
        usersDao.delete(USER_10_ID);
        usersDao.find(USER_10_ID);
    }

    @Test
    public void testUpdate() {
        usersDao.update(USER);
        User actual = usersDao.find(5);
        User expected = USER;

        assertEquals(actual, expected);
    }
}