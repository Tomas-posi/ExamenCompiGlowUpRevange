package com.parcial_compi.demo.repo;

import com.parcial_compi.demo.model.MoodLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodLogRepository extends JpaRepository<MoodLog, Long> {}

