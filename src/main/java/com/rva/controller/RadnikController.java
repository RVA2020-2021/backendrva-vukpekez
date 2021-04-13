package com.rva.controller;

import com.rva.jpa.Obrazovanje;
import com.rva.jpa.Preduzece;
import com.rva.jpa.Radnik;
import com.rva.repository.ObrazovanjeRepo;
import com.rva.repository.PreduzeceRepo;
import com.rva.repository.RadnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
public class RadnikController {
    @Autowired
    private RadnikRepo repo;

    @Autowired
    private ObrazovanjeRepo obrazovanjeRepo;

    @GetMapping("radnik")
    private Collection<Radnik> getRadnici() {
        return repo.findAll();
    }

    @GetMapping("radnik/{id}")
    private Radnik getRadnik(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }

    @GetMapping("radnikByPrezime/{prezime}")
    private Collection<Radnik> getRadnikByPrezime(@PathVariable("prezime") String prezime) {
        return repo.findByPrezimeContainsIgnoreCase(prezime);
    }

    @GetMapping("radnikByBrojLk/{brojLk}")
    private Radnik getRadnikByBrojLk(@PathVariable("brojLk") Integer brojLk) {
        return repo.findByBrojLk(brojLk);
    }

    @GetMapping("radnikByPreduzece/{id}")
    private Collection<Radnik> getRadnikByPreduzece(@PathVariable("id") Integer id)  {
        return repo.findBypreduze(id);
    }

    @GetMapping("radnikByObrazovanje/{id}")
    private Collection<Radnik> getRadnikByObrazovanje(@PathVariable("id") Integer id) {
        Obrazovanje obrazovanje = obrazovanjeRepo.getOne(id);
        return repo.findByObrazovanje(obrazovanje);
    }

    @PostMapping("radnik")
    private ResponseEntity<Radnik> insertRadnik(@RequestBody Radnik radnik) {
        if(!repo.existsById(radnik.getId())) {
            repo.save(radnik);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("radnik")
    private ResponseEntity<Radnik> updateRadnik(@RequestBody Radnik radnik) {
        if(repo.existsById(radnik.getId())) {
            repo.save(radnik);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("radnik/{id}")
    private ResponseEntity<Radnik> deleteRadnik(@PathVariable("id") Integer id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
