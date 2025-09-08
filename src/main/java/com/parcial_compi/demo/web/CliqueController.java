package com.parcial_compi.demo.web;

import com.parcial_compi.demo.model.Clique;
import com.parcial_compi.demo.repo.CliqueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliques")
public class CliqueController {
  private final CliqueRepository repo;
  public CliqueController(CliqueRepository repo) { this.repo = repo; }

  @GetMapping public List<Clique> all() { return repo.findAll(); }
  @PostMapping public Clique create(@RequestBody Clique c) { return repo.save(c); }
}
