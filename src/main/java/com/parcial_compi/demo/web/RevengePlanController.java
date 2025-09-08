package com.parcial_compi.demo.web;

import com.parcial_compi.demo.model.RevengePlan;
import com.parcial_compi.demo.repo.RevengePlanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class RevengePlanController {
  private final RevengePlanRepository repo;

  public RevengePlanController(RevengePlanRepository repo) { this.repo = repo; }

  @GetMapping
  public List<RevengePlan> all() { return repo.findAll(); }

  @GetMapping("/by-bully/{bullyId}")
  public List<RevengePlan> byBully(@PathVariable Long bullyId) {
    return repo.findByBully_Id(bullyId);
  }

  @GetMapping("/executed/{flag}")
  public List<RevengePlan> byExecuted(@PathVariable boolean flag) {
    return repo.findByIsExecuted(flag);
  }

  @PostMapping
  public RevengePlan create(@RequestBody RevengePlan plan) {
    return repo.save(plan);
  }

  // marcar un plan como ejecutado
  @PatchMapping("/{id}/execute")
  public RevengePlan markExecuted(@PathVariable Long id) {
    return repo.findById(id).map(p -> {
      p.setExecuted(true);
      return repo.save(p);
    }).orElse(null);
  }
}


