package com.parcial_compi.demo.repo;

import com.parcial_compi.demo.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {}
