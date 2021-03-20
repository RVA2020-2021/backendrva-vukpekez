package com.rva.controller;

import com.rva.model.Preduzece;
import com.rva.repository.PreduzeceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PreduzeceController {
    @Autowired
    private PreduzeceRepo repo;

    @GetMapping("preduzece")
    private Collection<Preduzece> getPreduzeca() {
        return repo.findAll();
    }

    @GetMapping("preduzece/{id}")
    private Preduzece getPreduzece(@PathVariable("id") Integer id) {
        return repo.getOne(id);
    }
}
