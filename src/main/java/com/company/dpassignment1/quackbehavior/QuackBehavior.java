package com.company.dpassignment1.quackbehavior;

/*
 * This interface is defined to manage the quack behavior among different ducks
 * because quack behavior is a changing behavior among different
 * ducks.
 * */
public interface QuackBehavior {
    // quack function which will be implemented by all classes
    // which will implement this interface.
    public String quack();
}
