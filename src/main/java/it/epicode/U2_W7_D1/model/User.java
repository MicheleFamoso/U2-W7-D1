package it.epicode.U2_W7_D1.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    @Column(unique = true) // Alla creazione controlla se ci sono altri username uguali e non ne fara fare di uguali
    private String email;
    private String password;


}
