package com.example.Gestionale.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // fields
    private String email;
    private String password;
    // relations
    @OneToMany(mappedBy = "utente")
    private List<Magazzino> magazzini;

    // no args constructor
    public Utente() {
    }
    // all args constructor
    public Utente(Long id, String email, String password, List<Magazzino> magazzini) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.magazzini = magazzini;
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Magazzino> getMagazzini() {
        return magazzini;
    }

    public void setMagazzini(List<Magazzino> magazzini) {
        this.magazzini = magazzini;
    }

    /**
     * This method copies the fields of another object of the same class, except id.
     *
     * @param utente the object that contains the fields to be copied.
     */
    // forse qui non servono email e password
    public void copyFields(Utente utente) {
        this.email = utente.getEmail();
        this.password = utente.getPassword();
    }
}
