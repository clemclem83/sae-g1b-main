package fr.univ_amu.iut;

import fr.univ_amu.iut.entity.Etudiant;
import jakarta.persistence.*;

public class ExempleJPA {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionPedaPU")){
            try(EntityManager em = emf.createEntityManager()){
                TypedQuery<Etudiant> query = em.createNamedQuery("Etudiant.findByVille", Etudiant.class);
                query.setParameter("villeEt","AIX-EN-PROVENCE");
                System.out.println(query.getResultList());
            }
        }
    }
}
