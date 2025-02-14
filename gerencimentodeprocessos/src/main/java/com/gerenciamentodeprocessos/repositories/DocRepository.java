package com.gerenciamentodeprocessos.repositories;

import com.gerenciamentodeprocessos.domain.doc.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocRepository extends JpaRepository<Doc, String> {
    Optional<Doc> findById(String id);
    List<Doc> findByNumberSei(String numberSei);

}
