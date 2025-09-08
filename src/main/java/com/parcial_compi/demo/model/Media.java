package com.parcial_compi.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "media")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Media {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne @JoinColumn(name = "revenge_plan_id")
  private RevengePlan revengePlan;

  @Enumerated(EnumType.STRING)
  private MediaType type; // PHOTO, DRAWING, MEME, VIDEO

  private String url;

  @Column(length = 1000)
  private String caption;
}

