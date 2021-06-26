package com.rva.repository;

import com.rva.jpa.Preduzece;
import com.rva.jpa.Sektor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SektorRepo extends JpaRepository<Sektor, Integer> {
    Collection<Sektor> findByNazivContainsIgnoreCase(String naziv);
    Collection<Sektor> findByOznakaContainsIgnoreCase(String oznaka);
    Collection<Sektor> findByPreduzece(Preduzece preduzece);
}
