package com.example.formvalidation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Utenti")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    @NotNull
    @Size(min = 1, max = 30)
    String nome;
    @NotNull
    @Size(min = 1, max = 30)
    String cognome;
    @NotNull
    @Size(min = 1, max = 30)
    String email;
    @NotNull
    @Size(min = 1, max = 30)
    String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ListaPub> liste = new HashSet<>();

    public Set<ListaPub> getListe() {
        return liste;
    }

    public void setListe(Set<ListaPub> liste) {
        this.liste = liste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(@NotNull String nome, @NotNull String cognome, @NotNull String email, @NotNull String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
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
}
