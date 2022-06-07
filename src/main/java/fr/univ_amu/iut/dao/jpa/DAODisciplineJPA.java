package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAODiscipline;
import fr.univ_amu.iut.model.Acteur;
import fr.univ_amu.iut.model.Discipline;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAODisciplineJPA extends DAOJPAImpl implements DAODiscipline {
    public DAODisciplineJPA(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public boolean delete(Discipline obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Discipline> findAll() {
        return super.findImpl(Discipline.class, "Discipline.findAll");
    }

    @Override
    public Discipline getById(Integer id) {
        return super.getByIdImpl(Discipline.class, id);
    }

    @Override
    public Discipline insert(Discipline obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(Discipline obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Discipline> findByNom(String nom) {
        return super.findByImpl(Discipline.class, "Discipline.findByNom", "nom", nom);
    }
}

