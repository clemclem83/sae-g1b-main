package fr.univ_amu.iut.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ETUDIANT")
@NamedQueries({
        @NamedQuery(name = "Etudiant.findAll", query = "SELECT p FROM Etudiant p"),
        @NamedQuery(name = "Etudiant.findById", query = "SELECT p FROM Etudiant p WHERE p.numEt = :numEt"),
        @NamedQuery(name = "Etudiant.findByVille", query = "SELECT p FROM Etudiant p WHERE p.villeEt = :villeEt")
})
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NUM_ET")
    private int numEt;
    @Column(name = "NOM_ET")
    private String nomEt;

    @Column(name = "PRENOM_ET")
    private String prenomEt;

    @Column(name = "CP_ET")
    private String cpEt;

    @Column(name = "VILLE_ET")
    private String villeEt;

    private int annee;
    private int groupe;

    public Etudiant() {
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getCpEt() {
        return cpEt;
    }

    public void setCpEt(String cpEt) {
        this.cpEt = cpEt;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public String getNomEt() {
        return nomEt;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public int getNumEt() {
        return numEt;
    }

    public void setNumEt(int numEt) {
        this.numEt = numEt;
    }

    public String getPrenomEt() {
        return prenomEt;
    }

    public void setPrenomEt(String prenomEt) {
        this.prenomEt = prenomEt;
    }

    public String getVilleEt() {
        return villeEt;
    }

    public void setVilleEt(String villeEt) {
        this.villeEt = villeEt;
    }

    @Override
    public String toString() {
        return "Etudiant [numEt=" + numEt + ", "
                + (nomEt != null ? "nomEt=" + nomEt + ", " : "")
                + (prenomEt != null ? "prenomEt=" + prenomEt + ", " : "")
                + (cpEt != null ? "cpEt=" + cpEt + ", " : "")
                + (villeEt != null ? "villeEt=" + villeEt + ", " : "")
                + "annee=" + annee + ", groupe=" + groupe + ", "
                + "]";
    }
}
