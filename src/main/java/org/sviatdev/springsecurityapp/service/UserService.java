package org.sviatdev.springsecurityapp.service;

import org.sviatdev.springsecurityapp.model.User;

/**
 * Service class for {@link org.sviatdev.springsecurityapp.model.User}
 */
public interface UserService {

    void save(User user);
    User findByUsername(String username);

}
