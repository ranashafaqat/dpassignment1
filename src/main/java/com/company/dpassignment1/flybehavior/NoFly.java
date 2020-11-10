package com.company.dpassignment1.flybehavior;
// class providing the specific implementation of duck fly behaviour
public class NoFly implements FlyBehavior {

    // fly() function displays the fly behavior of duck which can't fly.
    @Override
    public String fly() {
        return "I can't fly..";
    }
}
