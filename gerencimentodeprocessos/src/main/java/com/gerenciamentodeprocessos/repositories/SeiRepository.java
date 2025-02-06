package com.gerenciamentodeprocessos.repositories;

import com.gerenciamentodeprocessos.domain.sei.Sei;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeiRepository extends JpaRepository<Sei, String> {
    Optional<Sei> findById(String id);
    List<Sei> findByNumberSei(String numberSei);

}
