package com.example.Gestionale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "magazzini")
public class Magazzino {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // information fields
    private String nomeAttivita;
    private String indirizzo;
    private String tipologiaAttivita;
    // relation fields
    @OneToMany(mappedBy = "magazzino")
    private List<OggAbbigliamento> oggettiAbbigliamento;
    @OneToMany(mappedBy = "magazzino")
    private List<OggFarmacia> oggettiFarmacia;
    @OneToMany(mappedBy = "magazzino")
    private List<OggPub> oggettiPub;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    @JsonIgnore
    private Utente utente;

    // no args constructor
    public Magazzino() {
    }
    // all args constructor
    public Magazzino(Long id, String nomeAttivita, String indirizzo, String tipologia,
                     List<OggAbbigliamento> oggettiAbbigliamento, List<OggFarmacia> oggettiFarmacia, List<OggPub> oggettiPub, Utente utente) {
        this.id = id;
        this.nomeAttivita = nomeAttivita;
        this.indirizzo = indirizzo;
        this.tipologiaAttivita = tipologia;
        this.oggettiAbbigliamento = oggettiAbbigliamento;
        this.oggettiFarmacia = oggettiFarmacia;
        this.oggettiPub = oggettiPub;
        this.utente = utente;
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public String getNomeAttivita() {
        return nomeAttivita;
    }

    public void setNomeAttivita(String nomeAttivita) {
        this.nomeAttivita = nomeAttivita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTipologiaAttivita() {
        return tipologiaAttivita;
    }

    public void setTipologiaAttivita(String tipologia) {
        this.tipologiaAttivita = tipologia;
    }

    public List<OggAbbigliamento> getOggettiAbbigliamento() {
        return oggettiAbbigliamento;
    }

    public void setOggettiAbbigliamento(List<OggAbbigliamento> oggettiAbbigliamento) {
        this.oggettiAbbigliamento = oggettiAbbigliamento;
    }

    public List<OggFarmacia> getOggettiFarmacia() {
        return oggettiFarmacia;
    }

    public void setOggettiFarmacia(List<OggFarmacia> oggettiFarmacia) {
        this.oggettiFarmacia = oggettiFarmacia;
    }

    public List<OggPub> getOggettiPub() {
        return oggettiPub;
    }

    public void setOggettiPub(List<OggPub> oggettiPub) {
        this.oggettiPub = oggettiPub;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    /**
     * This method copies the information fields of another object of the same class, it copies only the fields that are not null.
     *
     * @param magazzino the object that contains the fields to be copied.
     */
    public void copyFields(Magazzino magazzino) {
        if (magazzino.getNomeAttivita() != null) this.nomeAttivita = magazzino.getNomeAttivita();
        if (magazzino.getIndirizzo() != null) this.indirizzo = magazzino.getIndirizzo();
        if (magazzino.getTipologiaAttivita() != null) this.tipologiaAttivita = magazzino.getTipologiaAttivita();
    }
}
