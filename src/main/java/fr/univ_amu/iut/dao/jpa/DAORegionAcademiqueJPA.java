package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAORegionAcademique;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.RegionAcademique;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAORegionAcademiqueJPA extends DAOJPAImpl implements DAORegionAcademique {
    public DAORegionAcademiqueJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(RegionAcademique obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<RegionAcademique> findAll() {
        return super.findImpl(RegionAcademique.class, "RegionAcademique.findAll");
    }

    @Override
    public RegionAcademique getById(Integer id) {
        return super.getByIdImpl(RegionAcademique.class, id);
    }

    @Override
    public RegionAcademique insert(RegionAcademique obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(RegionAcademique obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public List<RegionAcademique> findByNom(String nom) {
        return super.findByImpl(RegionAcademique.class, "RegionAcademique.findByNom", "nom", nom);
    }
}
