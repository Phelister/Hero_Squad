package org.heroSquad.dao;

import org.heroSquad.config.DatabaseConfig;
import org.heroSquad.models.Squad;
import org.heroSquad.models.Strength;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.heroSquad.constants.constants.covering_mouth;
import static org.junit.jupiter.api.Assertions.*;

class StrengthDaoTest {

    private static final Sql2o sql2o = DatabaseConfig.getDatabase();

    private static Connection connection = sql2o.open();
    Strength strength=null;

    @BeforeEach
    void setUp() {

        strength=new Strength("writing ", 10.0);
    }

    @Test
    @DisplayName(value = "Create Strength")
    void createStrengthTest() {

        String query = "INSERT INTO strength (name, score) VALUES (:name, :score);";
        connection.createQuery(query)
                .addParameter("name", strength.getName())
                .addParameter("score", strength.getScore())
                .executeUpdate();

        String queryB = "SELECT * FROM strength WHERE NOT deleted AND name = :name;";
        Strength strength1 = connection.createQuery(queryB)
                .addParameter("name", strength.getName())
                .executeAndFetchFirst(Strength.class);

        assertEquals(strength.getName(),strength1.getName());
        assertNotEquals("izi",strength1.getName());
    }

    @AfterEach
    void tearDown() {
        String query = "DELETE FROM strength WHERE name = :name;";
        connection.createQuery(query)
                .addParameter("name", strength.getName())
                .executeUpdate();
    }
}