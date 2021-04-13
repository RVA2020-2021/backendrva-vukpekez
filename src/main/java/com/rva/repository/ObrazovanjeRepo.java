package com.rva.repository;

import com.rva.jpa.Obrazovanje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ObrazovanjeRepo extends JpaRepository<Obrazovanje, Integer> {
    Collection<Obrazovanje> findByNazivContainsIgnoreCase(String naziv);
}
