package de.simonjpg.Backend.Database.Services;

import de.simonjpg.Backend.Database.Database;
import de.simonjpg.Backend.Database.Entities.CO2Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


class CO2ServiceTest {

    @Test
    void instance() {
        try (Connection connection = Database.instance("jdbc:mysql://localhost:3306/test").connect()) {
            CO2Service.instance(connection);
        } catch (SQLException ignored) {
            Assertions.fail();
        }

    }

    @Test
    void select() {
        try (Connection connection = Database.instance("jdbc:mysql://localhost:3306/test").connect()) {
            CO2Service service = CO2Service.instance(connection);
            List<CO2Entity> entities = service.select();
            Assertions.assertEquals(42.133713371337, entities.get(0).getValue());
            Assertions.assertEquals(1995, entities.get(0).getYear());
        } catch (SQLException ignored) {
        }
    }

    @Test
    void selectById() {
        try (Connection connection = Database.instance("jdbc:mysql://localhost:3306/test").connect()) {
            CO2Service service = CO2Service.instance(connection);
            CO2Entity entities = service.selectById(1);
            Assertions.assertEquals(42.133713371337, entities.getValue());
            Assertions.assertEquals(1995, entities.getYear());
        } catch (SQLException ignored) {
        }
    }

    @Test
    void create() {
        try (Connection connection = Database.instance("jdbc:mysql://localhost:3306/test").connect()) {
            CO2Service service = CO2Service.instance(connection);
            boolean actual = service.create(new CO2Entity(1995, 42.2151231));
            Assertions.assertTrue(actual);
        } catch (SQLException ignored) {
        }
    }

    @Test
    void update() {
        try (Connection connection = Database.instance("jdbc:mysql://localhost:3306/test").connect()) {
            CO2Service service = CO2Service.instance(connection);
            boolean actual = service.update(2, new CO2Entity(1995, 42.21515221331));
            Assertions.assertTrue(actual);
        } catch (SQLException ignored) {
        }
    }

    @Test
    void delete() {
        try (Connection connection = Database.instance("jdbc:mysql://localhost:3306/test").connect()) {
            CO2Service service = CO2Service.instance(connection);
            boolean actual = service.delete(2);
            Assertions.assertTrue(actual);
        } catch (SQLException ignored) {
        }
    }
}