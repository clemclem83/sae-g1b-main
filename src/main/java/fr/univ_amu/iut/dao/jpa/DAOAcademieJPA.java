package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOAcademie;
import fr.univ_amu.iut.model.Academie;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOAcademieJPA extends DAOJPAImpl implements DAOAcademie {
    public DAOAcademieJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(Academie obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Academie> findByNom(String nom){
        return null;
    }

    @Override
    public List<Academie> findAll() {
        return super.findImpl(Academie.class, "Academie.findAll");
    }

    @Override
    public Academie getById(String code) {
        return super.getByIdImpl(Academie.class, code);
    }

    @Override
    public Academie insert(Academie obj) {
        super.insertImpl(obj);
        return getById(obj.getCode());
    }

    @Override
    public boolean update(Academie obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
