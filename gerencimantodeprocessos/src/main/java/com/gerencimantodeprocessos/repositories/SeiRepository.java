package com.gerencimantodeprocessos.repositories;

import com.gerencimantodeprocessos.domain.sei.Sei;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeiRepository extends JpaRepository<Sei, String> {
    List<Sei> findByNumberSei(Long numberSei);

}
