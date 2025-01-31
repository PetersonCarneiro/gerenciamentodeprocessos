package com.gerencimentodeprocessos.repositories;

import com.gerencimentodeprocessos.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByFirstName(String firstName);
    Optional<User> findByLogin(String login);
}
