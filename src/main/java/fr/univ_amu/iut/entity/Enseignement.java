package fr.univ_amu.iut.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

public class Enseignement {
    @Transient
    Module module;
    @Transient
    Prof prof;
    @Transient
    Etudiant etudiant;
}
