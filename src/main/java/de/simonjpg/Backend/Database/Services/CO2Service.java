package de.simonjpg.Backend.Database.Services;

import de.simonjpg.Backend.Database.Entities.CO2Entity;
import de.simonjpg.Backend.Exceptions.DeleteStatementFailedException;
import de.simonjpg.Backend.Exceptions.InsertStatementFailedException;
import de.simonjpg.Backend.Exceptions.SelectStatementFailedException;
import de.simonjpg.Backend.Exceptions.UpdateStatementFailedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// TODO: Add javadoc and logging
public class CO2Service {
    private static CO2Service co2Service;
    private final Connection connection;

    public CO2Service(Connection connection) {
        this.connection = connection;
    }

    public static CO2Service instance(Connection connection) {
        if (co2Service == null) {
            co2Service = new CO2Service(connection);
        }
        return co2Service;
    }

    //TODO: Add custom select statement for each year (1990, 1995, ...)

    public List<CO2Entity> select() throws SelectStatementFailedException {
        List<CO2Entity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM co2");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idOfRs = resultSet.getInt(1);
                int yearOfRs = resultSet.getInt(2);
                double valueOfRs = resultSet.getDouble(3);
                entities.add(new CO2Entity(idOfRs, yearOfRs, valueOfRs));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new SelectStatementFailedException(e.getMessage());
        }
        return entities;
    }

    public CO2Entity selectById(int id) throws SelectStatementFailedException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM co2 WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int idOfRs = resultSet.getInt(0);
            int yearOfRs = resultSet.getInt(1);
            double valueOfRs = resultSet.getDouble(2);
            resultSet.close();
            preparedStatement.close();
            return new CO2Entity(idOfRs, yearOfRs, valueOfRs);
        } catch (SQLException e) {
            throw new SelectStatementFailedException(e.getMessage());
        }
    }

    public boolean create(CO2Entity entity) throws InsertStatementFailedException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO co2 (year, value) VALUES (?, ?)");
            preparedStatement.setInt(1, entity.getYear());
            preparedStatement.setDouble(2, entity.getValue());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new InsertStatementFailedException(e.getMessage());
        }
    }

    public boolean update(int id, CO2Entity entity) throws UpdateStatementFailedException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE co2 SET year = ?, value = ? WHERE id = ?");
            preparedStatement.setInt(1, entity.getYear());
            preparedStatement.setDouble(2, entity.getValue());
            preparedStatement.setInt(3, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new UpdateStatementFailedException(e.getMessage());
        }
    }

    public boolean delete(int id) throws DeleteStatementFailedException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM co2 WHERE id = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DeleteStatementFailedException(e.getMessage());
        }
    }
}
