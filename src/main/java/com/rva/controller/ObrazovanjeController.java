package com.rva.controller;

import com.rva.jpa.Obrazovanje;
import com.rva.repository.ObrazovanjeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class ObrazovanjeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObrazovanjeRepo repo;

    @GetMapping("obrazovanje")
    private Collection<Obrazovanje> getObrazovanja() {
        return repo.findAll();
    }

    @GetMapping("obrazovanje/{id}")
    private Obrazovanje getObrazovanje(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }

    @GetMapping("obrazovanjeByNaziv/{naziv}")
    private Collection<Obrazovanje> getObrazovanjeByNaziv(@PathVariable("naziv") String naziv) {
        return repo.findByNazivContainsIgnoreCase(naziv);
    }

    @PostMapping("obrazovanje")
    private ResponseEntity<Obrazovanje> insertObrazovanje(@RequestBody Obrazovanje obrazovanje) {
        if(!repo.existsById(obrazovanje.getId())) {
            repo.save(obrazovanje);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("obrazovanje")
    private ResponseEntity<Obrazovanje> updateObrazovanje(@RequestBody Obrazovanje obrazovanje) {
        if(repo.existsById(obrazovanje.getId())) {
           repo.save(obrazovanje);
           return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("obrazovanje/{id}")
    private ResponseEntity<Obrazovanje> deleteObrazovanje(@PathVariable("id") Integer id) {
        if(repo.existsById(id)) {
            jdbcTemplate.execute("delete from radnik where obrazovanje=" + id);
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
