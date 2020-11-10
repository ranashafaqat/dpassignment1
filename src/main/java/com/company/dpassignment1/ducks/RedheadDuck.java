package com.company.dpassignment1.ducks;


import com.company.dpassignment1.flybehavior.FlyWithWings;
import com.company.dpassignment1.quackbehavior.Squeck;

public class RedheadDuck extends Duck {

    // the constructor of Redhead duck used to initialize
    // fly and quack behaviors of duck
    public RedheadDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Squeck();
    }

    // displays the duck.. current implementation show the duck name.
    public String display(){
        return "Redhead Duck";
    }
}
