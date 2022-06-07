package fr.univ_amu.iut.dao;


import fr.univ_amu.iut.model.RegionAcademique;

import java.util.List;

public interface DAORegionAcademique extends DAO<RegionAcademique, Integer>{

    //List<RegionAcademique> findById(int Id);

    List<RegionAcademique> findByNom(String nom);
}
