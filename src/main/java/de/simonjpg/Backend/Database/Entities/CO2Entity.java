package de.simonjpg.Backend.Database.Entities;

public class CO2Entity {
    private int id;
    private final int year;
    private final double value;

    public CO2Entity(int id, int year, double value) {
        this.id = id;
        this.year = year;
        this.value = value;
    }

    public CO2Entity(int year, double value) {
        this.year = year;
        this.value = value;
    }

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

    public int getId() {
        return id;
    }
}
