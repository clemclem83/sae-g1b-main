package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOTypeActeur;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.model.TypeActeur;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOTypeActeurJPA extends DAOJPAImpl implements DAOTypeActeur {
    public DAOTypeActeurJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(TypeActeur obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<TypeActeur> findAll() {
        return super.findImpl(TypeActeur.class, "TypeActeur.findAll");
    }

    @Override
    public TypeActeur getById(Integer id) {
        return super.getByIdImpl(TypeActeur.class, id);
    }

    @Override
    public TypeActeur insert(TypeActeur obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(TypeActeur obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<TypeActeur> findByNom(String nom) {
        return super.findByImpl(TypeActeur.class, "TypeActeur.findByNom", "nom", nom);
    }
}
