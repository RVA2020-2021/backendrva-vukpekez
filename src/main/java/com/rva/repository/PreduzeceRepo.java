package com.rva.repository;

import com.rva.jpa.Preduzece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PreduzeceRepo extends JpaRepository<Preduzece, Integer> {
    Collection<Preduzece> findByNazivContainsIgnoreCase(String naziv);
    Preduzece findByPib(Integer pib);
}
