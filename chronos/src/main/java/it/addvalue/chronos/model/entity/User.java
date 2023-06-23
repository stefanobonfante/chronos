package it.addvalue.chronos.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_UTENTI")
public class User {
  @Id
  @Column(name = "COD_UTENTE")
  private String userCode;

  @Column(name = "NOME")
  private String name;

  @Column(name = "COGNOME")
  private String surname;

  @Column(name = "LIVELLO")
  private int level;
}
