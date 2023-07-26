package org.heroSquad;

import org.heroSquad.dao.HeroDao;
import org.heroSquad.dao.SquadDao;
import org.heroSquad.dao.StrengthDao;
import org.heroSquad.dao.WeaknessDao;
import org.heroSquad.models.Hero;
import org.heroSquad.models.Squad;
import org.heroSquad.models.Strength;
import org.heroSquad.models.Weakness;
import org.heroSquad.utils.SharedUtils;

import java.util.HashMap;

import static spark.Spark.post;
import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {

        get("/", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "index.hbs");
        });

        get("/strength/add", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "create-strength.hbs");
        });
        get("/weakness/add", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "create-weakness.hbs");
        });
        get("/squad/add", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "create-squad.hbs");
        });
        get("/hero/add", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "create-hero.hbs");
        });

        post("/create-strength", (req, res)->{

            String name = req.queryParams("name");
            System.out.println(name);
            double score = Double.valueOf(req.queryParams("score"));

            Strength strength = new Strength();
            strength.setScore(score);
            strength.setName(name);

            StrengthDao.create(strength);

            res.redirect("/");
            return null;
        });


        post("/create-weakness", (req, res)->{

            String name = req.queryParams("name");
            System.out.println(name);
            double score = Double.valueOf(req.queryParams("score"));
            if(score>0){
                score=-1* score;
            }

            Weakness weakness = new Weakness();
            weakness.setScore(score);
            weakness.setName(name);

            WeaknessDao.create(weakness);

            res.redirect("/");
            return null;
        });


        post("/create-hero", (req, res)->{

            String name = req.queryParams("name");
            int age = Integer.valueOf(req.queryParams("age"));
            String squadName= req.queryParams("squadname");
            String strengthName=req.queryParams("strengthname");
            String weaknessName=req.queryParams("weaknessname");
            System.out.println(weaknessName);
            System.out.println(strengthName);
            int squadId=SquadDao.findSquadByName(squadName);
            int strengthId=StrengthDao.findStrengthByName(strengthName);
            System.out.println(strengthId);
            int weaknessId=WeaknessDao.findWeaknessByName(weaknessName);
            System.out.println(weaknessId);
            Hero hero = new Hero(name, age, strengthId,weaknessId, squadId);
            HeroDao.create(hero);
            res.redirect("/");
            return null;
        });
        post("/create-squad", (req, res)->{

            String name = req.queryParams("name");
            int maxSize = Integer.valueOf(req.queryParams("maxSize"));
            String cause= req.queryParams("cause");
            Squad squad= new Squad(maxSize, name,cause);
            SquadDao.createSquad(squad);
            res.redirect("/");
            return null;
        });

       System.out.print(SquadDao.findSquadById(2));
       StrengthDao.getScoreById(4);









       // System.out.println("Hello world!");
    }
}