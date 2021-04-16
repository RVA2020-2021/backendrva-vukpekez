package com.rva.controller;

import com.rva.jpa.Obrazovanje;
import com.rva.jpa.Preduzece;
import com.rva.jpa.Radnik;
import com.rva.repository.ObrazovanjeRepo;
import com.rva.repository.PreduzeceRepo;
import com.rva.repository.RadnikRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
@Api(tags = {"Radnik CRUD operacije"})
public class RadnikController {
    @Autowired
    private RadnikRepo repo;

    @Autowired
    private ObrazovanjeRepo obrazovanjeRepo;

    @GetMapping("radnik")
    @ApiOperation(value = "Vraća kolekciju svih radnika iz baze podataka")
    private Collection<Radnik> getRadnici() {
        return repo.findAll();
    }

    @GetMapping("radnik/{id}")
    @ApiOperation(value = "Vraća radnika iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private Radnik getRadnik(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }

    @GetMapping("radnikByPrezime/{prezime}")
    @ApiOperation(value = "Vraća kolekciju svih sektora iz baze podataka čije prezime sadrži string vrednost prosleđenu kao path varijabla")
    private Collection<Radnik> getRadnikByPrezime(@PathVariable("prezime") String prezime) {
        return repo.findByPrezimeContainsIgnoreCase(prezime);
    }

    @GetMapping("radnikByBrojLk/{brojLk}")
    @ApiOperation(value = "Vraća radnika iz baze podataka čiji je broj lične karte integer vrednost prosleđena kao path varijabla")
    private Radnik getRadnikByBrojLk(@PathVariable("brojLk") Integer brojLk) {
        return repo.findByBrojLk(brojLk);
    }

    @GetMapping("radnikByPreduzece/{id}")
    @ApiOperation(value = "Vraća kolekciju svih radnika koji rade u sektorima koji pripadaju preduzecu iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private Collection<Radnik> getRadnikByPreduzece(@PathVariable("id") Integer id)  {
        return repo.findBypreduze(id);
    }

    @GetMapping("radnikByObrazovanje/{id}")
    @ApiOperation(value = "Vraća kolekciju svih radnika koji imaju obrazovanje iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private Collection<Radnik> getRadnikByObrazovanje(@PathVariable("id") Integer id) {
        Obrazovanje obrazovanje = obrazovanjeRepo.getOne(id);
        return repo.findByObrazovanje(obrazovanje);
    }

    @PostMapping("radnik")
    @ApiOperation(value = "Upisuje radnika u bazu podataka")
    private ResponseEntity<Radnik> insertRadnik(@RequestBody Radnik radnik) {
        if(!repo.existsById(radnik.getId())) {
            repo.save(radnik);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("radnik")
    @ApiOperation(value = "Modifikuje postojećeg radnika u bazi podataka")
    private ResponseEntity<Radnik> updateRadnik(@RequestBody Radnik radnik) {
        if(repo.existsById(radnik.getId())) {
            repo.save(radnik);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("radnik/{id}")
    @ApiOperation(value = "Briše radnika iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
    private ResponseEntity<Radnik> deleteRadnik(@PathVariable("id") Integer id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
