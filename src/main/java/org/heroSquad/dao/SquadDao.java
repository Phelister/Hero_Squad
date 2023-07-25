package org.heroSquad.dao;

import org.heroSquad.config.DatabaseConfig;
import org.heroSquad.dto.Info;
import org.heroSquad.models.Hero;
import org.heroSquad.models.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class SquadDao {
        private static final Sql2o sql2o = DatabaseConfig.getDatabase();

        public static void create(Squad squad){
            try(Connection connection = sql2o.open()){
                String query = "INSERT INTO squad ( maxSize,name, cause) VALUES (:name, :max_size, :cause);";
                connection.createQuery(query)
                        .addParameter("maxSize", squad.getMaxSize())
                        .addParameter("name", squad.getName())
                        .addParameter("cause", squad.getCause())
                        .executeUpdate();
            } catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }

        public static Info findSquadById(int squadId) {
            try (Connection connection = sql2o.open()) {
                String querySquads = "SELECT * FROM squad WHERE NOT deleted AND id = :squadId;";
                Squad squad = connection.createQuery(querySquads)
                        .addParameter("squadId", squadId)
                        .executeAndFetchFirst(Squad.class);
                List<Hero> heroes = HeroDao.findAllHeroesBySquadId(squadId);

                Info info = new Info();
                info.setSquad(squad);
                info.setHeroes(heroes);
                info.setStrengthScore(getHeroScore(heroes, 0));
                info.setWeaknessScore(getHeroScore(heroes, 1));
                return info;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                return  null;
            }
        }

        private static int getHeroScore(List<Hero> heroes, int type) {
            int score = 0;
            if (type == 0){
                for(Hero hero: heroes){
                    int id = hero.getStrengthId();
                    score += StrengthDao.getScoreById(id);
                }
                return score;
            } else {
                for(Hero hero: heroes){
                    int id = hero.getWeaknessId();
//                score += WeaknessDao.getScoreById(id);
                }
                return score;
            }
        }

}