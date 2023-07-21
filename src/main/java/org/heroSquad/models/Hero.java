package org.heroSquad.models;

public class Hero {

    //many heros can belong to one squad
    private int id;
    private String name;
    private int age;
    private int strengthId;

    private int weaknessId;
    private int squadId;
    private boolean deleted;

    public Hero() {
    }

    public Hero(String name, int age, Strength specialPower, Weakness weakness) {
        this.name = name;
        this.age = age;
        this.deleted=false;
    }

    public int getStrengthId() {
        return strengthId;
    }

    public void setStrengthId(int strengthId) {
        this.strengthId = strengthId;
    }

    public int getWeaknessId() {
        return weaknessId;
    }

    public void setWeaknessId(int weaknessId) {
        this.weaknessId = weaknessId;
    }

    public int getSquadIid() {
        return squadId;
    }

    public void setSquadIid(int squadIid) {
        this.squadId = squadIid;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

