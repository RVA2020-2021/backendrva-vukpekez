package com.rva.controller;

import com.rva.jpa.Preduzece;
import com.rva.repository.PreduzeceRepo;
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
@Api(tags = {"Preduzece CRUD operacije"})
public class PreduzeceController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PreduzeceRepo repo;

    @GetMapping("preduzece")
    @ApiOperation(value = "Vraca kolekciju svih preduzeca iz baze podataka")
    private Collection<Preduzece> getPreduzeca() {
        return repo.findAll();
    }

    @GetMapping("preduzece/{id}")
    @ApiOperation(value = "Vraca preduzece iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
    private Preduzece getPreduzece(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }

    @GetMapping("preduzeceByNaziv/{naziv}")
    @ApiOperation(value = "Vraca kolekciju svih preduzeca iz baze podataka koja u nazivu sadrze string vrednost prosledjenu kao path varijabla")
    private Collection<Preduzece> getPreduzeceByNaziv(@PathVariable("naziv") String naziv) {
        return repo.findByNazivContainsIgnoreCase(naziv);
    }

    @GetMapping("preduzeceByPIB/{pib}")
    @ApiOperation(value = "Vraca preduzece iz baze podataka ciji je PIB integer vrednost prosledjena kao path varijabla")
    private Preduzece getPreduzeceByPIB(@PathVariable("pib") Integer pib) {
        return repo.findByPib(pib);
    }

    @PostMapping("preduzece")
    @ApiOperation(value = "Upisuje preduzece u bazu podataka")
    private ResponseEntity<Preduzece> insertPreduzece(@RequestBody Preduzece preduzece) {
    	repo.save(preduzece);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("preduzece")
    @ApiOperation(value = "Modifikuje postojece preduzece u bazi podataka")
    private ResponseEntity<Preduzece> updatePreduzece(@RequestBody Preduzece preduzece) {
        if(repo.existsById(preduzece.getId())) {
            repo.save(preduzece);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("preduzece/{id}")
    @ApiOperation(value = "Brise preduzece i sektore sa radnicima koji pripadaju preduzecu iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
    private ResponseEntity<Preduzece> deletePreduzece(@PathVariable("id") Integer id) {
        if(repo.existsById(id)) {
            jdbcTemplate.execute(
                    "delete from radnik where sektor in (select sektor.id from sektor where preduzece=" + id + ")"
            );
            jdbcTemplate.execute("delete from sektor where preduzece=" + id);
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
