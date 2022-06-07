package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Thematique;

import java.util.List;

public interface DAOThematique extends DAO<Thematique, Integer>{


    //List<Thematique> findById(int Id);

    List<Thematique> findByNom(String nom);
}
