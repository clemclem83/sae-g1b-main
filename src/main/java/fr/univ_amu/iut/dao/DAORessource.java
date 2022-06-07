package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Ressource;
import fr.univ_amu.iut.model.TypeRessource;

import java.net.URL;
import java.util.List;

public interface DAORessource extends DAO<Ressource, Integer>{

    //List<Ressource> findById(int Id);

    List<Ressource> findByTypeRessource(TypeRessource typeRessource);

    List<Ressource> findByURL(URL lienRessource);
}
