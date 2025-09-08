package com.parcial_compi.demo.web;

import com.parcial_compi.demo.model.MoodLog;
import com.parcial_compi.demo.repo.MoodLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moods")
public class MoodLogController {
  private final MoodLogRepository repo;
  public MoodLogController(MoodLogRepository repo) { this.repo = repo; }

  @GetMapping public List<MoodLog> all() { return repo.findAll(); }
  @PostMapping public MoodLog create(@RequestBody MoodLog m) { return repo.save(m); }
}

