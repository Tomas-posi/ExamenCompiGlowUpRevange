package com.parcial_compi.demo.repo;

import com.parcial_compi.demo.model.Bully;
import com.parcial_compi.demo.model.HighSchoolRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BullyRepository extends JpaRepository<Bully, Long> {
    List<Bully> findByClique_Name(String cliqueName);
    List<Bully> findByHighSchoolRole(HighSchoolRole role);
}
