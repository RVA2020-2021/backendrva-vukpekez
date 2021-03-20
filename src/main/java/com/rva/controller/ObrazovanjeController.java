package com.rva.controller;

import com.rva.model.Obrazovanje;
import com.rva.repository.ObrazovanjeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ObrazovanjeController {
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
}
