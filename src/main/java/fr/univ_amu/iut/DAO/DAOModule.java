package fr.univ_amu.iut.DAO;

import fr.univ_amu.iut.entity.Module;
import fr.univ_amu.iut.entity.Prof;

import java.util.List;


public interface DAOModule extends DAO<Module, String> {
    List<Module> findByLibelle(String libelle);

    List<Module> findByDiscipline(String discipline);

    List<Module> findByResponsable(Prof Responsable);
}
