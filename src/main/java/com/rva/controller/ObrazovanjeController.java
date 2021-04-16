package com.rva.controller;

import com.rva.jpa.Obrazovanje;
import com.rva.repository.ObrazovanjeRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@Api(tags = {"Obrazovanje CRUD operacije"})
public class ObrazovanjeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObrazovanjeRepo repo;

    @GetMapping("obrazovanje")
    @ApiOperation(value = "Vraća kolekciju svih obrazovanja iz baze podataka")
    private Collection<Obrazovanje> getObrazovanja() {
        return repo.findAll();
    }

    @GetMapping("obrazovanje/{id}")
    @ApiOperation(value = "Vraća obrazovanje iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private Obrazovanje getObrazovanje(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }

    @GetMapping("obrazovanjeByNaziv/{naziv}")
    @ApiOperation(value = "Vraća kolekciju svih obrazovanja iz baze podataka koja u nazivu sadrže string vrednost prosleđenu kao path varijabla")
    private Collection<Obrazovanje> getObrazovanjeByNaziv(@PathVariable("naziv") String naziv) {
        return repo.findByNazivContainsIgnoreCase(naziv);
    }

    @PostMapping("obrazovanje")
    @ApiOperation(value = "Upisuje obrazovanje u bazu podataka")
    private ResponseEntity<Obrazovanje> insertObrazovanje(@RequestBody Obrazovanje obrazovanje) {
        if(!repo.existsById(obrazovanje.getId())) {
            repo.save(obrazovanje);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("obrazovanje")
    @ApiOperation(value = "Modifikuje postojeće obrazovanje u bazi podataka")
    private ResponseEntity<Obrazovanje> updateObrazovanje(@RequestBody Obrazovanje obrazovanje) {
        if(repo.existsById(obrazovanje.getId())) {
           repo.save(obrazovanje);
           return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("obrazovanje/{id}")
    @ApiOperation(value = "Briše obrazovanje i radnike koji imaju obrazovanje iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private ResponseEntity<Obrazovanje> deleteObrazovanje(@PathVariable("id") Integer id) {
        if(repo.existsById(id)) {
            jdbcTemplate.execute("delete from radnik where obrazovanje=" + id);
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
