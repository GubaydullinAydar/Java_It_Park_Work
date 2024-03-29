package ru.itpark.dao;

import ru.itpark.models.User;

public interface UsersDao extends BaseCrudDao<User> {

    public User findByName(String name);

}
