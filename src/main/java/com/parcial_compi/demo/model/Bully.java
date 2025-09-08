package com.parcial_compi.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity @Table(name = "bullies")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bully {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String nickname;

  @Enumerated(EnumType.STRING)
  private HighSchoolRole highSchoolRole; // JOCK, GOSSIP, etc.

  @ManyToOne @JoinColumn(name = "clique_id")
  private Clique clique; // un bully pertenece a una clique

  @Column(length = 1000)
  private String bullyingReason;

  private int levelOfAnnoyance; // 1–10

  @OneToMany(mappedBy = "bully")
  @ToString.Exclude @EqualsAndHashCode.Exclude
  private List<RevengePlan> revengePlans;
}

