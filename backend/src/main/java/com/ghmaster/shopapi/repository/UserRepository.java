package com.ghmaster.shopapi.repository;


import com.ghmaster.shopapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, String> {
    User findByEmail(String email);

    Collection<User> findAllByRole(String role);

}
