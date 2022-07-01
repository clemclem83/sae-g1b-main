package fr.univ_amu.iut.DAO;

import fr.univ_amu.iut.entity.Module;
import fr.univ_amu.iut.entity.Prof;

import java.util.List;

public interface DAOProf extends DAO<Prof, Integer> {
    List<Prof> findByNom(String nom);

    List<Prof> findMatSpec(Module matSpec);

    int computeNbProf();
}
