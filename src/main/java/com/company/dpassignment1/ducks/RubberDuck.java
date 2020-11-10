package com.company.dpassignment1.ducks;


import com.company.dpassignment1.flybehavior.NoFly;
import com.company.dpassignment1.quackbehavior.QuackMute;

public class RubberDuck extends Duck{

    // the constructor of Redhead duck used to initialize
    // fly and quack behaviors of duck
    public RubberDuck(){
        flyBehavior = new NoFly();
        quackBehavior = new QuackMute();
    }

    // displays the duck.. current implementation show the duck name.
    public String display(){
        return "Rubber Duck";
    }

}
