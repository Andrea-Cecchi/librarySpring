package com.example.formvalidation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="libri")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String titolo;
    @NotNull
    @Size(min = 1, max = 60)
    private String autore;
    @NotNull
    private String annoPubblicazione;
    @NotNull
    @Min(0)
    private Integer prezzo;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<ListaPub> liste = new HashSet<>();

    public Book(@NotNull String titolo, @NotNull String autore, @NotNull String annoPubblicazione, @NotNull Integer prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public Book() {

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(String annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }
}
