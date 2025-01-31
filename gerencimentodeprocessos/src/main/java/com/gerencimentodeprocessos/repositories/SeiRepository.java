package com.gerencimentodeprocessos.repositories;

import com.gerencimentodeprocessos.domain.sei.Sei;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeiRepository extends JpaRepository<Sei, String> {
    List<Sei> findByNumberSei(Long numberSei);

}
