package com.parcial_compi.demo.repo;

import com.parcial_compi.demo.model.RevengePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RevengePlanRepository extends JpaRepository<RevengePlan, Long> {
    List<RevengePlan> findByBully_Id(Long bullyId);
    List<RevengePlan> findByIsExecuted(boolean executed);
}
