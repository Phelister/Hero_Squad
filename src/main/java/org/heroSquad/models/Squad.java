package org.heroSquad.models;

public class Squad {

    //many heros can belong to one squad
    private int id;
    private int maxSize;
    private String name;
    private Cause cause;

    private boolean deleted;

    public Squad(int maxSize, String name, Cause cause) {
        this.maxSize = maxSize;
        this.name = name;
        this.cause = cause;
        this.deleted=false;
    }
    public Squad(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }
}
