package com.rva.controller;

import com.rva.jpa.Radnik;
import com.rva.jpa.Sektor;
import com.rva.repository.RadnikRepo;
import com.rva.repository.SektorRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@Api(tags = {"Radnik CRUD operacije"})
public class RadnikController {
    @Autowired
    private RadnikRepo repo;

    @Autowired
    private SektorRepo sektorRepo;
    
    @GetMapping("radnik")
    @ApiOperation(value = "Vraca kolekciju svih radnika iz baze podataka")
    private Collection<Radnik> getRadnici() {
        return repo.findAll();
    }

    @GetMapping("radnik/{id}")
    @ApiOperation(value = "Vraca radnika iz baze podataka je id vrednost prosledjena kao path varijabla")
    private Radnik getRadnik(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }

    @GetMapping("radnikByPrezime/{prezime}")
    @ApiOperation(value = "Vraca kolekciju svih sektora iz baze podataka cije prezime sadrzi string vrednost prosledjenu kao path varijabla")
    private Collection<Radnik> getRadnikByPrezime(@PathVariable("prezime") String prezime) {
        return repo.findByPrezimeContainsIgnoreCase(prezime);
    }

    @GetMapping("radnikByBrojLk/{brojLk}")
    @ApiOperation(value = "Vraca radnika iz baze podataka ciji je broj licnene karte integer vrednost prosledjena kao path varijabla")
    private Radnik getRadnikByBrojLk(@PathVariable("brojLk") Integer brojLk) {
        return repo.findByBrojLk(brojLk);
    }

    @GetMapping("radnikByPreduzece/{id}")
    @ApiOperation(value = "Vraca kolekciju svih radnika koji rade u sektorima koji pripadaju preduzecu iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
    private Collection<Radnik> getRadnikByPreduzece(@PathVariable("id") Integer id)  {
        return repo.findByPreduzece(id);
    }

    @GetMapping("radnikBySektor/{id}")
    @ApiOperation(value = "Vraca kolekciju svih radnika koji rade u sektoru iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
    private Collection<Radnik> getRadnikBySektor(@PathVariable("id") Integer id) {
    	Sektor sektor = sektorRepo.getOne(id);
    	return repo.findBySektor(sektor);
    }
    
    @PostMapping("radnik")
    @ApiOperation(value = "Upisuje radnika u bazu podataka")
    private ResponseEntity<Radnik> insertRadnik(@RequestBody Radnik radnik) {
    	repo.save(radnik);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("radnik")
    @ApiOperation(value = "Modifikuje postojeceg radnika u bazi podataka")
    private ResponseEntity<Radnik> updateRadnik(@RequestBody Radnik radnik) {
        if(repo.existsById(radnik.getId())) {
            repo.save(radnik);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("radnik/{id}")
    @ApiOperation(value = "Brise radnika iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
    private ResponseEntity<Radnik> deleteRadnik(@PathVariable("id") Integer id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
