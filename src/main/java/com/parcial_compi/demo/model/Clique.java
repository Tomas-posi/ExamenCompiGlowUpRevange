package com.parcial_compi.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity @Table(name = "cliques")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Clique {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(length = 1000)
  private String description;

  @OneToMany(mappedBy = "clique")
  @ToString.Exclude @EqualsAndHashCode.Exclude
  private List<Bully> bullies;
}

