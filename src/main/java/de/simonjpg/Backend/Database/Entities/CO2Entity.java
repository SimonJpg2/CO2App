package de.simonjpg.Backend.Database.Entities;

/**
 * Class Co2Entity.
 * <p>
 *     Class to represent the data of the database.
 * </p>
 * @author Simon Balcke
 */

public class CO2Entity {
    private int id;
    private final int year;
    private final double value;

    /**
     * Constructor Co2Entity.
     * <p>
     *     Creates new instance
     * </p>
     * @param id id of the database entry
     * @param year year of the co2 value
     * @param value actual co2 data
     */

    public CO2Entity(int id, int year, double value) {
        this.id = id;
        this.year = year;
        this.value = value;
    }

    /**
     * Constructor Co2Entity.
     * <p>
     *     Creates new instance.
     * </p>
     * @param year year of the co2 value
     * @param value actual co2 data
     */

    public CO2Entity(int year, double value) {
        this.year = year;
        this.value = value;
    }

    @SuppressWarnings("unused")
    public CO2Entity() {
        this.id = -1;
        this.year = -1;
        this.value = -1.0;
    }

    public int getYear() {
        return year;
    }

    public double getValue() {
        return value;
    }

    @SuppressWarnings("unused")
    public int getId() {
        return id;
    }
}
