package org.heroSquad.dao;

import org.heroSquad.config.DatabaseConfig;
import org.heroSquad.models.Strength;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import

public class StrengthDao {
//        Create Strength
//    List available strengths
//    Update strength (name and score)
//    Update strength details
//    Delete strength

        private static final Sql2o sql2o = DatabaseConfig.getDatabase();
         private static Connection connection = sql2o.open();

        public static void create(Strength strength){
            try{
                String name= strength.getName();
                Double score = strength.getScore();
                String query = "INSERT INTO strength (name, score) VALUES (name, score);";
                connection.createQuery(query)
                        .addParameter("name", strength.getName())
                        .addParameter("score", strength.getScore())
                        .executeUpdate();
            } catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }

        public static void listStrengths(){
            try {

                String query = "select * from strength where NOT deleted;";
                connection.createQuery(query)
                        .executeUpdate();
            } catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }


        public static void updateNameAndScore(String name, String id){
            try{
                String query = "UPDATE strength SET name = :name WHERE id = :id;";
                connection.createQuery(query)
                        .addParameter("name", name)
                        .addParameter("id", id)
                        .executeUpdate();
            } catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
    public static void updateAllStrengthDetails(Strength strength){
        try{
            int id=strength.getId();
            String name= strength.getName();
            Double score = strength.getScore();
            boolean delete=strength.isDeleted();
            String query = "UPDATE strength SET name = name, score=score  deleted=delete WHERE id = :id;";
            connection.createQuery(query)
                    .addParameter("name", strength.getName())
                    .addParameter("score", strength.getScore())
                    .executeUpdate();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    public static boolean deleteStrength(int  id){
        try{
            String query = "UPDATE strength SET deleted = true WHERE id = :id;";
            connection.createQuery(query)
                    .executeUpdate();
            return true;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return false;
    }

        public static int getScoreById(int id){
            try(Connection connection = sql2o.open()){
                String query = "SELECT score FROM strength WHERE id = :id;";
                int score = connection.createQuery(query)
                        .addParameter("id", id)
                        .executeScalar(Integer.class);
                System.out.println(score);
                return 0;
            } catch (Exception exception){
                System.out.println(exception.getMessage());
                return 0;
            }
        }



}
