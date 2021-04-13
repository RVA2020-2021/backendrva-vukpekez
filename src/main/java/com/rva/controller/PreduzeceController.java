package com.rva.controller;

import com.rva.jpa.Preduzece;
import com.rva.repository.PreduzeceRepo;
import com.rva.repository.SektorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class PreduzeceController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PreduzeceRepo repo;

    @Autowired
    private SektorRepo sektorRepo;

    @GetMapping("preduzece")
    private Collection<Preduzece> getPreduzeca() {
        return repo.findAll();
    }

    @GetMapping("preduzece/{id}")
    private Preduzece getPreduzece(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }

    @GetMapping("preduzeceByNaziv/{naziv}")
    private Collection<Preduzece> getPreduzeceByNaziv(@PathVariable("naziv") String naziv) {
        return repo.findByNazivContainsIgnoreCase(naziv);
    }

    @GetMapping("preduzeceByPIB/{pib}")
    private Preduzece getPreduzeceByPIB(@PathVariable("pib") Integer pib) {
        return repo.findByPib(pib);
    }

    @PostMapping("preduzece")
    private ResponseEntity<Preduzece> insertPreduzece(@RequestBody Preduzece preduzece) {
        if(!repo.existsById(preduzece.getId())) {
            repo.save(preduzece);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("preduzece")
    private ResponseEntity<Preduzece> updatePreduzece(@RequestBody Preduzece preduzece) {
        if(repo.existsById(preduzece.getId())) {
            repo.save(preduzece);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("preduzece/{id}")
    private ResponseEntity<Preduzece> deletePreduzece(@PathVariable("id") Integer id) {
        if(repo.existsById(id)) {
            jdbcTemplate.execute("delete from sektor where preduzece=" + id);
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
