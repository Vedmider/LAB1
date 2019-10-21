package com.dao;

import com.domain.vegetable.AbstractVegetable;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface EntityMapper<T extends AbstractVegetable> {
    T getEntity(ResultSet resultSet) throws SQLException;
}
