package com.company.dpassignment1.layout;

import com.company.dpassignment1.ducks.Duck;

public abstract class Layout extends Duck {

    Duck duck;
    public abstract String display();

    public void addChild(Duck duck){
        throw new UnsupportedOperationException();
    }

    public void removeChild(Duck duck){
        throw new UnsupportedOperationException();
    }

    public void getChild(int Id){
        throw new UnsupportedOperationException();
    }
}
