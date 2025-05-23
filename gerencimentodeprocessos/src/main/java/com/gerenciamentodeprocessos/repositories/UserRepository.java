package com.gerenciamentodeprocessos.repositories;

import com.gerenciamentodeprocessos.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByFirstName(String firstName);
    User findByLogin(String login);
}
