package com.parcial_compi.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity @Table(name = "revenge_plans")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RevengePlan {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  @ManyToOne @JoinColumn(name = "bully_id")
  private Bully bully; // pertenece a un bully

  private boolean isExecuted;
  private LocalDate datePlanned;

  @Enumerated(EnumType.STRING)
  private SuccessLevel successLevel;

  @OneToMany(mappedBy = "revengePlan")
  @ToString.Exclude @EqualsAndHashCode.Exclude
  private List<Media> mediaList; // puede tener muchos media
}
