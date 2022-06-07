package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOTypeRessource;
import fr.univ_amu.iut.model.TypeActeur;
import fr.univ_amu.iut.model.TypeRessource;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOTypeRessourceJPA extends DAOJPAImpl implements DAOTypeRessource {
    public DAOTypeRessourceJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(TypeRessource obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<TypeRessource> findAll() {
        return super.findImpl(TypeRessource.class, "TypeRessource.findAll");
    }

    @Override
    public TypeRessource getById(Integer id) {
        return super.getByIdImpl(TypeRessource.class, id);
    }

    @Override
    public TypeRessource insert(TypeRessource obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(TypeRessource obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<TypeRessource> findByNom(String nom) {
        return super.findByImpl(TypeRessource.class, "TypeRessource.findByNom", "nom", nom);
    }
}
