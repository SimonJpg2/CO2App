package de.simonjpg.Backend.Database.Services;

import de.simonjpg.Backend.Database.Entities.CO2Entity;
import de.simonjpg.Backend.Exceptions.DeleteStatementFailedException;
import de.simonjpg.Backend.Exceptions.InsertStatementFailedException;
import de.simonjpg.Backend.Exceptions.SelectStatementFailedException;
import de.simonjpg.Backend.Exceptions.UpdateStatementFailedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Class Co2Service.
 * <p>
 *     Business logic for SQL-Queries.
 * </p>
 * @author Simon Balcke
 */

public class CO2Service {
    private static CO2Service co2Service;
    private final Connection connection;
    private static final Logger LOGGER = LogManager.getLogger(CO2Service.class);

    public CO2Service(Connection connection) {
        this.connection = connection;
    }

    public static CO2Service instance(Connection connection) {
        if (co2Service == null) {
            LOGGER.info("Instantiate new object");
            co2Service = new CO2Service(connection);
        }
        LOGGER.info("Referencing service instance");
        return co2Service;
    }

    /**
     * Method select.
     * <p>
     *     Selects every Co2 data from the co2 table.
     * </p>
     * @return a {@link java.util.List} with CO2Entities.
     * @throws SelectStatementFailedException if selection failed.
     */

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

    /**
     * Method select.
     * <p>
     *     Selects every Co2 data with the given year from the co2 table.
     * </p>
     * @param year for the CO₂ data.
     * @return a {@link java.util.List} with CO2Entities.
     * @throws SelectStatementFailedException if selection failed.
     */

    public List<CO2Entity> selectYear(int year) throws SelectStatementFailedException {
        List<CO2Entity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM co2 WHERE year = ?");
            preparedStatement.setInt(1, year);
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

    /**
     * Method selectById.
     * <p>
     *     Selects a specific Co2 data by id.
     * </p>
     * @return a CO2Entity.
     * @throws SelectStatementFailedException if selection failed.
     */

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

    /**
     * Method create.
     * <p>
     *     Creates new co2 entry
     * </p>
     * @param entity values to be added.
     * @return status of success.
     * @throws InsertStatementFailedException if insertion failed.
     */

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

    /**
     * Method update.
     * <p>
     *     Updates existing co2 entry.
     * </p>
     * @param id of co2 entry to be updated
     * @param entity new value
     * @return status of success.
     * @throws UpdateStatementFailedException if update failed.
     */

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

    /**
     * Method delete.
     * <p>
     *     Deletes existing co2 entry.
     * </p>
     * @param id of entry to be deleted.
     * @return success status.
     * @throws DeleteStatementFailedException if delete statement failed.
     */

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
