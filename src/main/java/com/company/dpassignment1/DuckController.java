package com.company.dpassignment1;

import com.company.dpassignment1.ducks.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
* This controller is used to receive requests from frontend
* and to send back response to the frontend in json.
* */
@RestController
public class DuckController {

    // list is created to maintain the list of objects of ducks created by used
    private List<Duck> ducks = new ArrayList<Duck>();

    // this function returns the list of ducks
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/duck/all")
    public List<Duck> getDucks() {
        return ducks;
    }

    // this function adds duck sent from frontend in the
    // list of ducks maintained in controller
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/duck")
    public void addDuck(@RequestBody DuckRequestDTO duck) {
        Duck new_duck;
        if (duck.getName().equals("MallardDuck")) {
            new_duck = new MallardDuck();
        } else if (duck.getName().equals("RedheadDuck")) {
            new_duck = new RedheadDuck();
        } else if (duck.getName().equals("RubberDuck")) {
            new_duck = new RubberDuck();
        } else {
            new_duck = new Duck() {
                @Override
                public String display() {
                    return "New Duck";
                }
            };
        }

        new_duck.setId(ducks.size() + 1);
        new_duck.setName(new_duck.display());
        new_duck.setFly(new_duck.performFly());
        new_duck.setQuack(new_duck.performQuack());
        new_duck.setSwim(new_duck.swim());
        ducks.add(new_duck);
    }

    // This function deletes the specified duck from the list of ducks.
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/api/duck/{duckId}")
    public void deleteDuck(@PathVariable("duckId") int duckId) {

        // iterating over all ducks and deleting the required one.
        for (int i=0;i<ducks.size();i++) {
            if (ducks.get(i).getId() == duckId) {
                ducks.remove(i);
            }
        }

    }


    // this function returns the duck specified by id.
    // id is used to identify multiple ducks added  by user from frontend
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/duck/{duckId}")
    public Duck getDuckById(@PathVariable("duckId") int duckId) {
        for (Duck duck : ducks) {
            if (duck.getId() == duckId) {
                return duck;
            }
        }
        return null;
    }

    // this function is used to update(change) behaviors of duck
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/api/duck/{duckId}")
    public void updateDuck(@PathVariable("duckId") int duckId, @RequestBody DuckRequestDTO duckRequest) {

        for (int i=0;i<ducks.size();i++) {
            if (ducks.get(i).getId() == duckId) {
                ducks.get(i).setFly(duckRequest.getFly());
                ducks.get(i).setQuack(duckRequest.getQuack());
            }
        }

    }

    // this function is used to add layout of duck
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/duck/layout")
    public void addDuckLayout() {
        Duck duck = new Duck() {
            @Override
            public String display() {
                return null;
            }
        };
        Duck new_duck = new MallardDuck();
        new_duck.setId(ducks.size() + 1);
        new_duck.setName(new_duck.display());
        new_duck.setFly(new_duck.performFly());
        new_duck.setQuack(new_duck.performQuack());
        new_duck.setSwim(new_duck.swim());

        List<Duck> duckList = new ArrayList<>();
        duckList.add(new_duck);
        duck.setDucks(duckList);

        ducks.add(duck);
    }

    // this function is used to add layout of duck
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/duck/{duckId}/child")
    public void addDuckLayout(@PathVariable("duckId") int duckId, @RequestBody DuckRequestDTO duck) {

        Duck new_duck;
        if (duck.getName().equals("MallardDuck")) {
            new_duck = new MallardDuck();
        } else if (duck.getName().equals("RedheadDuck")) {
            new_duck = new RedheadDuck();
        } else if (duck.getName().equals("RubberDuck")) {
            new_duck = new RubberDuck();
        } else {
            new_duck = new Duck() {
                @Override
                public String display() {
                    return "New Duck";
                }
            };
        }

        new_duck.setId(ducks.size() + 1);
        new_duck.setName(new_duck.display());
        new_duck.setFly(new_duck.performFly());
        new_duck.setQuack(new_duck.performQuack());
        new_duck.setSwim(new_duck.swim());
        ducks.get(duckId - 1).getDucks().add(new_duck);
    }



}
