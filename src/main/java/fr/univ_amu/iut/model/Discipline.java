package fr.univ_amu.iut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Discipline {
    @Transient
    public static Discipline Toutes = new Discipline("Toutes disciplines");
    @Transient
    public static Discipline HistoireGeographie = new Discipline("Histoire-géographie");
    @Transient
    public static Discipline PhysiqueChimie = new Discipline("Physique-chimie");
    @Transient
    public static Discipline ScienceEtVieDeLaTerre = new Discipline("SVT");
    @Transient
    public static Discipline Technologie = new Discipline("Technologie");
    @Transient
    public static Discipline Francais = new Discipline("Français");
    @Transient
    public static Discipline EconomieGestion = new Discipline("Économie Gestion");
    @Transient
    public static Discipline LangueVivante = new Discipline("Langue Vivante");

    @Id
    @GeneratedValue
    int id;
    String nom;

    public Discipline() {

    }

    Discipline(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Integer getId() {return id;}
}
