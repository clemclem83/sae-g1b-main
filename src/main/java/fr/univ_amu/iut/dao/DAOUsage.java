package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Usage;

import java.util.List;

public interface DAOUsage extends DAO<Usage, Integer>{

    //List<Usage> findById(int Id);

    List<Usage> findByNom(String nom);

    List<Usage> findByDescription(String description);

    List<Usage> findByCommentaire(String commentaire);

    List<Usage> findByAcademie(Academie academie);
}
