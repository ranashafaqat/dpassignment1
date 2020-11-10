package com.company.dpassignment1.layout;

import com.company.dpassignment1.ducks.Duck;

import java.util.ArrayList;
import java.util.List;

public class GridLayout extends Layout {

    List childs = new ArrayList<Duck>();
    // displays the duck.. current implementation show the duck name.
    public String display(){
        return "Mallard Duck";
    }

    public void addChild(Duck duck){
        childs.add(duck);
    }

    public void removeChild(Duck id){
        // iterating over all childs and deleting the required one.
        for (int i=0;i<childs.size();i++) {
//            if (childs.get(i).getId() == id) {
//                childs.remove(i);
//            }
        }
    }

    public void getChild(int Id){
        throw new UnsupportedOperationException();
    }



}