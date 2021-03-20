package com.rva.controller;

import com.rva.model.Radnik;
import com.rva.repository.RadnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RadnikController {
    @Autowired
    private RadnikRepo repo;

    @GetMapping("radnik")
    private Collection<Radnik> getRadnici() {
        return repo.findAll();
    }

    @GetMapping("radnik/{id}")
    private Radnik getRadnik(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }
}
