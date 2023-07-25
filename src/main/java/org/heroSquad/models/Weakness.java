package org.heroSquad.models;

public class Weakness {
    private int id;
    private String name;
    private Double score;
    private boolean deleted=false;

    public Weakness( String name, Double score) {
        this.name = name;
        this.score = score;
        this.deleted = false;
    }
    public Weakness(){

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
