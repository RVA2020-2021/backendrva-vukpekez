package com.rva.repository;

import com.rva.jpa.Radnik;
import com.rva.jpa.Sektor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface RadnikRepo extends JpaRepository<Radnik, Integer> {
    Collection<Radnik> findByPrezimeContainsIgnoreCase(String prezime);
    Radnik findByBrojLk(Integer brojLk);
    @Query(value = "select * from radnik r join sektor s on r.sektor = s.id join preduzece p on p.id = s.preduzece where p.id = ?1", nativeQuery = true)
    Collection<Radnik> findByPreduzece(Integer id);
    Collection<Radnik> findBySektor(Sektor sektor);
}