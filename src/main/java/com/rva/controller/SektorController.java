package com.rva.controller;

import com.rva.model.Sektor;
import com.rva.repository.SektorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SektorController {
    @Autowired
    private SektorRepo repo;

    @GetMapping("sektor")
    private Collection<Sektor> getSektori() {
        return repo.findAll();
    }

    @GetMapping("sektor/{id}")
    private Sektor getSektor(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }
}
