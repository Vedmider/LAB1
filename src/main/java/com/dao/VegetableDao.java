package com.dao;

import com.domain.vegetable.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VegetableDao extends AbstractDao<AbstractVegetable>{
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDao.class);
    private static final String SELECT_FROM_VEGETABLES = "SELECT vp.name, v.weight FROM vegetables AS v LEFT JOIN vegetable_prototype vp on v.prototype = vp.id";
    private static final String INSERT_INTO_VEGETABLES = "INSERT INTO vegetables (prototype, weight) VALUES (?, ?)";
    private static final String UPDATE_VEGETABLES = "UPDATE vegetables SET weight = ? where id = ?";
    private static final String DELETE_FROM_VEGETABLES = "DELETE FROM vegetables WHERE id = ?";

    @Override
    public List<AbstractVegetable> getAll(){
        return getAll(SELECT_FROM_VEGETABLES, resultSet -> {
            String name = resultSet.getString("name");
            int weight = resultSet.getInt("weight");
            switch (name.trim().toUpperCase()) {
                case ("CARROT"):
                    return new Carrot(weight);
                case ("CUCUMBER"):
                    return new Cucumber(weight);
                case ("KALE"):
                    return new Kale(weight);
                case ("ONION"):
                    return new Onion(weight);
                case ("TOMATO"):
                    return new Tomato(weight);
                default:
                    return null;
            }
        });
    }

    @Override
    public boolean create(AbstractVegetable entity) {
        return createUpdate(INSERT_INTO_VEGETABLES, ps -> {
            ps.setInt(1, getPrototypeId(entity));
            ps.setInt(2, entity.getWeight());
        } );
    }

    @Override
    public boolean update(AbstractVegetable entity) {
        return createUpdate(UPDATE_VEGETABLES, ps -> {
            ps.setInt(1, entity.getWeight());
            ps.setInt(2, entity.getId());
        });
    }

    @Override
    public boolean delete(AbstractVegetable entity){
        LOG.debug("Delete vegetale : " + entity.getName() + " with id " + entity.getId());
        return createUpdate(DELETE_FROM_VEGETABLES, ps -> ps.setInt(1, entity.getId()));
    }
}
