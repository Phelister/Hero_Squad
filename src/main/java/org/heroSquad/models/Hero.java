package org.heroSquad.models;

public class Hero {

    //many heros can belong to one squad
    private int id;
    private String name;
    private int age;



    private int weaknessId;
    private int squadIid;
    private boolean deleted;
    private Strength specialPower;

    private Weakness weakness;

    private Squad squad;

    public Hero() {
        this.name=null;
        this.age =0;
        this.specialPower=null;
        this.weakness=null;
    }

    public Hero(String name, int age, Strength specialPower, Weakness weakness) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.deleted=false;
    }


    private int strengthId;

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
        return squadIid;
    }

    public void setSquadIid(int squadIid) {
        this.squadIid = squadIid;
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

    public Strength getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(Strength specialPower) {
        this.specialPower = specialPower;
    }

    public Weakness getWeakness() {
        return weakness;
    }

    public void setWeakness(Weakness weakness) {
        this.weakness = weakness;
    }
}
