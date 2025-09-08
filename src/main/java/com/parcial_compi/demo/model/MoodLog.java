package com.parcial_compi.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Table(name = "mood_logs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MoodLog {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate date;
  private int moodLevel; // 1–10

  @Column(length = 1000)
  private String note;
}

