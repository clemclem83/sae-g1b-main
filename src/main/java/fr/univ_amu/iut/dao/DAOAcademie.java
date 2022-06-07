package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Academie;

import java.util.List;

public interface DAOAcademie extends DAO<Academie, String>{
    List<Academie> findByNom(String nom);
}
