package com.company.dpassignment1.ducks;


import com.company.dpassignment1.flybehavior.FlyBehavior;
import com.company.dpassignment1.quackbehavior.QuackBehavior;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/*
*
* This is an abstract class, acts as a parent class for all ducks.
* It composes(contains instances of) changing behaviors of ducks defined as
* interfaces like fly behavior or quack behavior etc.
*
* */
public abstract class Duck {

    // these jSon properties are required to send the response object to in front end
    // Other than that they don't effect any working of our duck interface implemented
    // on server side.
    // *** id is used to identify multiple ducks added by user from frontend
    @JsonProperty("id")
    int id;
    @JsonProperty("name")
    String name;
    @JsonProperty("fly")
    String fly;
    @JsonProperty("quack")
    String quack;
    @JsonProperty("swim")
    String swim;
    @JsonProperty("ducks")
    List<Duck> ducks;

    // instances of interfaces defined in flybehavior package and quackbehavior package
    // that represent the changing behaviors of different ducks
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    // abstract method so that every duck will be forced to implement it
    // to show her own display.
    public abstract String display();

    // swim() function is assumed to be same among all ducks
    // so it is defined(implemented) in Duck class
    public String  swim() {
        return "I am swimming.. ";
    }

    // It provides the functionality of calling the respective fly() function
    // by providing the uniformity of objects
    public String performFly() {
        return flyBehavior.fly();
    }

    // It provides the functionality of calling the respective quack() function
    // by providing the uniformity of objects
    public String performQuack() {
        return quackBehavior.quack();
    }

    // this function enables user to change the fly behavior of
    // a duck at runtime.
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    // this function enables user to change the quack behavior of
    // a duck at runtime.
    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }


    /*
    * setter and getter functions of instance variables are defined below.
    * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSwim(String swim) {
        this.swim = swim;
    }

    public String getSwim() {
        return swim;
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }
}
