package org.heroSquad.models;

public class Strength {

    private int id;
    private String name;
    private Double score;
    private boolean deleted;

    public Strength(int id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.deleted = false;
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
