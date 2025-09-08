package com.parcial_compi.demo.web;

import com.parcial_compi.demo.model.Bully;
import com.parcial_compi.demo.model.HighSchoolRole;
import com.parcial_compi.demo.repo.BullyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bullies")
public class BullyController {

    private final BullyRepository repo;

    public BullyController(BullyRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Bully> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Bully byId(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/by-role/{role}")
    public List<Bully> byRole(@PathVariable HighSchoolRole role) {
        return repo.findByHighSchoolRole(role);
    }

    @GetMapping("/by-clique/{name}")
    public List<Bully> byClique(@PathVariable String name) {
        return repo.findByClique_Name(name);
    }

    @PostMapping
    public Bully create(@RequestBody Bully b) {
        return repo.save(b);
    }
}

