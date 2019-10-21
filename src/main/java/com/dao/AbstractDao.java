package com.dao;

import com.domain.vegetable.AbstractVegetable;
import com.persistence.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends AbstractVegetable> implements CRUDInterface <T>{
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDao.class);
    private static final String SELECT_FROM_VEGETABLE_PROTOTYPE = "SELECT type.id FROM vegetable_prototype AS type WHERE type.name LIKE '%?%'";
    protected static final String COLUMN_ID = "id";

    public List<T> getAll(String query, EntityMapper<T> mapper) {
        List<T> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                T entity = mapper.getEntity(resultSet);

                result.add(entity);
            }

        } catch (SQLException e) {
            LOG.error("Exception while getting all entities");
        }

        return result;
    }

    public int getPrototypeId(T entity) {
        int id = 0;
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(SELECT_FROM_VEGETABLE_PROTOTYPE)) {
            preparedStatement.setString(1, entity.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            id = resultSet.getInt(COLUMN_ID);
        } catch (SQLException e) {
            LOG.error("Exception while getting all entities");
        }
        return id;
    }

    public boolean createUpdate(String query, StatementMapper statementMapper){
        try(PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(query)) {
            statementMapper.map(preparedStatement);

            int result = preparedStatement.executeUpdate();

            return result == 1;
        } catch (SQLException e) {
            LOG.error("Could not create entity!!", e);
        }

        return false;
    }

}
