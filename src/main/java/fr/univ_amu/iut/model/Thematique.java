package fr.univ_amu.iut.model;
import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Thematique.findAll", query = "SELECT p FROM Thematique p"),
        @NamedQuery(name = "Thematique.findById", query = "SELECT p FROM Thematique p WHERE p.id = :id"),
})
@Entity
public class Thematique {

    public static Thematique ClasseInversee= new Thematique("Classe inversée");
    public static Thematique CreationNumerique = new Thematique("Création numérique");
    public static Thematique DifferenciationPedagogique = new Thematique("Différenciation pédagogique");
    public static Thematique EcoleInclusive = new Thematique("École inclusive");
    public static Thematique CitoyenneteNumerique = new Thematique("EMI citoyenneté numérique (Se protéger)");
    public static Thematique EnseignerADistance = new Thematique("Enseigner à distance");
    public static Thematique ExpressionOrale = new Thematique("Expression orale/podcast");
    public static Thematique Evaluation = new Thematique("Évaluation");
    public static Thematique FormationAuxOutilsNumeriques = new Thematique("Formation aux outils numériques");
    public static Thematique FormerADistance = new Thematique("Former à distance");
    public static Thematique Hybridation = new Thematique("Hybridation");
    public static Thematique Ludification = new Thematique("Ludification");
    public static Thematique PedagogieDeProjet = new Thematique("Pédagogie de projet");
    public static Thematique Programmation = new Thematique("Programmation/Codage/Robotique");
    public static Thematique RealiteVirtuelle = new Thematique("Réalité virtuelle et augmentée");
    public static Thematique ReseauxSociaux = new Thematique("Réseaux sociaux");
    public static Thematique SExercerSentrainer = new Thematique("S’exercer/s’entraîner");
    public static Thematique TiersLab = new Thematique("Tiers lab");
    public static Thematique TNE = new Thematique("TNE");
    public static Thematique TravailCollaboratif = new Thematique("Travail collaboratif/mutualisation");
    public static Thematique TravailEntrePairs = new Thematique("Travail entre pairs");
    public static Thematique WebRadio = new Thematique("Webradio");

    @Id
    @GeneratedValue
    int id;
    String nom;

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public Thematique(String nom) {
        this.nom = nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Thematique() {

    }
}
