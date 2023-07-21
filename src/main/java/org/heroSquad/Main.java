package org.heroSquad;

import org.heroSquad.dao.SquadDao;
import org.heroSquad.dao.StrengthDao;
import org.heroSquad.models.Strength;
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

        post("/create-strength", (req, res)->{
            String name = req.queryParams("name");

            double score = Double.valueOf(req.queryParams("score"));

            Strength strength = new Strength();
            strength.setScore(score);
            strength.setName(name);

            StrengthDao.create(strength);

            res.redirect("/");
            return null;
        });

        System.out.println(SquadDao.findSquadById(2));
        StrengthDao.getScoreById(2);









       // System.out.println("Hello world!");
    }
}