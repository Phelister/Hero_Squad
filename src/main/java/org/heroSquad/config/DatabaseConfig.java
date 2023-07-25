package org.heroSquad.config;
import org.sql2o.Sql2o;

public class DatabaseConfig {
    public static Sql2o getDatabase(){
        //database url and password
            return new Sql2o("jdbc:postgresql://localhost:5432/test", "postgres", "root");

    }


}
