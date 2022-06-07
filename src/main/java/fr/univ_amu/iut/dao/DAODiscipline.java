package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Discipline;

import java.util.List;

public interface DAODiscipline extends DAO<Discipline, Integer>{

    //List<Discipline> findById(int Id);

    List<Discipline> findByNom(String nom);
}
