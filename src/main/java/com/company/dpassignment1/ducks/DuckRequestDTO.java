package com.company.dpassignment1.ducks;


import com.fasterxml.jackson.annotation.JsonProperty;

/*
* This class is defined to handle the requests coming from frontend
* other than that it has no other use. It has no  interaction
* our duck framework.
* */
public class DuckRequestDTO {

    // these jason properties are required to send the response object to in front end
    // Other than that they don't effect any working of our duck interface implemented
    // on server side.
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("fly")
    private String fly;
    @JsonProperty("quack")
    private String quack;
    @JsonProperty("swim")
    private String swim;
    @JsonProperty("shapeLevel")
    private int shapeLevel;

/*
* Setter and getter functions are defined below.
* */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFly() {
        return fly;
    }

    public void setFly(String fly) {
        this.fly = fly;
    }

    public String getQuack() {
        return quack;
    }

    public void setQuack(String quack) {
        this.quack = quack;
    }

    public String getSwim() {
        return swim;
    }

    public void setSwim(String swim) {
        this.swim = swim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShapeLevel() {
        return shapeLevel;
    }

    public void setShapeLevel(int shapeLevel) {
        this.shapeLevel = shapeLevel;
    }
}
