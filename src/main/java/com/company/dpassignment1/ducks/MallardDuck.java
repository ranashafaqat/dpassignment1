package com.company.dpassignment1.ducks;

import com.company.dpassignment1.flybehavior.FlyWithWings;
import com.company.dpassignment1.quackbehavior.Quack;


public class MallardDuck extends Duck{

    // the constructor of Mallared duck used to initialize
    // fly and quack behaviors of duck
    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    // displays the duck.. current implementation show the duck name.
    public String display(){
        return "Mallard Duck";
    }
}
