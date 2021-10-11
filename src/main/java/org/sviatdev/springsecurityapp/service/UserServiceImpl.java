package org.sviatdev.springsecurityapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.sviatdev.springsecurityapp.model.Role;
import org.sviatdev.springsecurityapp.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.sviatdev.springsecurityapp.dao.RoleDao;
import org.sviatdev.springsecurityapp.dao.UserDao;

import java.util.HashSet;
import java.util.Set;

/**
        Implementation of {@link UserService} interface
 */
@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
