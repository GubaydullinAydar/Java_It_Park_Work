package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.User;

/**
 * Service class for {@link net.proselyte.springsecurityapp.model.User}.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
