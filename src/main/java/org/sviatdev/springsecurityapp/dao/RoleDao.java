package org.sviatdev.springsecurityapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sviatdev.springsecurityapp.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
