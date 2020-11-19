package com.company.dpassignment1.layout;

import com.company.dpassignment1.ducks.Duck;
import com.company.dpassignment1.ducks.MallardDuck;

import java.util.ArrayList;
import java.util.List;

// concrete layout class representing the gridlayout and extending the layot interface/abstract-class
public class GridLayout extends Layout {

    // list which maintains all the childs of one instance
    private List childs = new ArrayList<Duck>();
    // displays the duck.. current implementation show the duck name.
    public String display(){
        return "Mallard Duck";
    }

    // adding child
    public void addChild(Duck duck){
        childs.add(duck);
    }

//    removing child
    public void removeChild(Duck duck){
        // iterating over all childs and deleting the required one.
        for (int i=0;i<childs.size();i++) {
            if (childs.get(i).equals(duck)) {
                childs.remove(i);
            }
        }
    }

    public ArrayList<Duck> getChilds(){
        return (ArrayList<Duck>) childs;
    }



}