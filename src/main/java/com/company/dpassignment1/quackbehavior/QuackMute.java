package com.company.dpassignment1.quackbehavior;
// class providing the specific implementation of duck quack behaviour
public class QuackMute implements QuackBehavior {

    // quack() function displays the quack behavior of duck which can't quacks.
    public String quack() {
        return "I can't quack...";
    }
}
