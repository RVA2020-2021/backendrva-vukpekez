package com.rva.controller;

import com.rva.jpa.Preduzece;
import com.rva.jpa.Sektor;
import com.rva.repository.PreduzeceRepo;
import com.rva.repository.SektorRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
@Api(tags = {"Sektor CRUD operacije"})
public class SektorController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SektorRepo sektorRepo;

    @Autowired
    private PreduzeceRepo preduzeceRepo;

    @GetMapping("sektor")
    @ApiOperation(value = "Vraća kolekciju svih sektora iz baze podataka")
    private Collection<Sektor> getSektori() {
        return sektorRepo.findAll();
    }

    @GetMapping("sektor/{id}")
    @ApiOperation(value = "Vraća sektor iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private Sektor getSektor(@PathVariable("id") Integer id) {
        return sektorRepo.getOne(id);
    }

    @GetMapping("sektorByNaziv/{naziv}")
    @ApiOperation(value = "Vraća kolekciju svih sektora iz baze podataka koji u nazivu sadrže string vrednost prosleđenu kao path varijabla")
    private Collection<Sektor> getSektorByNaziv(@PathVariable("naziv") String naziv) {
        return sektorRepo.findByNazivContainsIgnoreCase(naziv);
    }

    @GetMapping("sektorByOznaka/{oznaka}")
    @ApiOperation(value = "Vraća kolekciju svih sektora iz baze podataka koji u oznaci sadrže string vrednost prosleđenu kao path varijabla")
    private Collection<Sektor> getSektorByOznaka(@PathVariable("oznaka") String oznaka) {
        return sektorRepo.findByOznakaContainsIgnoreCase(oznaka);
    }

    @GetMapping("sektorByPreduzece/{id}")
    @ApiOperation(value = "Vraća kolekciju svih sektora koji pripadaju preduzecu iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private Collection<Sektor> getSektorByPreduzece(@PathVariable("id") Integer id) {
        Preduzece preduzece = preduzeceRepo.getOne(id);
        return sektorRepo.findByPreduzece(preduzece);
    }

    @PostMapping("sektor")
    @ApiOperation(value = "Upisuje sektor u bazu podataka")
    private ResponseEntity<Sektor> insertSektor(@RequestBody Sektor sektor) {
        if(!sektorRepo.existsById(sektor.getId())) {
            sektorRepo.save(sektor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("sektor")
    @ApiOperation(value = "Modifikuje postojeći sektor u bazi podataka")
    private ResponseEntity<Sektor> updateSektor(@RequestBody Sektor sektor) {
        if(sektorRepo.existsById(sektor.getId())) {
            sektorRepo.save(sektor);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("sektor/{id}")
    @ApiOperation(value = "Briše sektor i radnike sektora iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private ResponseEntity<Sektor> deleteSektor(@PathVariable("id") Integer id) {
        if(sektorRepo.existsById(id)) {
            jdbcTemplate.execute("delete from radnik where sektor=" + id);
            sektorRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
