package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOThematique;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.Thematique;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOThematiqueJPA extends DAOJPAImpl implements DAOThematique {
    public DAOThematiqueJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(Thematique obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Thematique> findAll() {
        return super.findImpl(Thematique.class, "Thematique.findAll");
    }

    @Override
    public Thematique getById(Integer id) {
        return super.getByIdImpl(Thematique.class, id);
    }

    @Override
    public Thematique insert(Thematique obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(Thematique obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Thematique> findByNom(String nom) {
        return super.findByImpl(Thematique.class, "Thematique.findByNom", "nom", nom);
    }
}
