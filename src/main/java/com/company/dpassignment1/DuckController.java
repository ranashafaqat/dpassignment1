package com.company.dpassignment1;

import com.company.dpassignment1.ducks.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This controller is used to receive requests from frontend
 * and to send back response to the frontend in json.
 * */
@RestController
public class DuckController {

    // list is created to maintain the list of objects of ducks created by used
    private List<Duck> ducks = new ArrayList<Duck>();
    private List<Integer> undoDuckList = new ArrayList<>();
    private List<Integer> redoDuckList = new ArrayList<>();

    // AutoIncrementId
    private int duckId = 0;

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

        new_duck.setId(duckId++);
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
        for (Duck duck : ducks) {
            if (duck.getDucks() != null && duck.getDucks().size() > 0) {
                duck.getDucks().removeIf(duckChild -> duckChild.getId() == duckId);
            } else if (duck.getId() == duckId) {
                ducks.remove(duck);
            }
        }

    }


    // this function returns the duck specified by id.
    // id is used to identify multiple ducks added  by user from frontend
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/duck/{duckId}")
    public Duck getDuckById(@PathVariable("duckId") int duckId) {
        for (Duck duck : ducks) {
            if (duck.getDucks() != null && duck.getDucks().size() > 0) {
                for (Duck duckChild : duck.getDucks()) {
                    if (duckChild.getId() == duckId) {
                        return duckChild;
                    }
                }
            } else if (duck.getId() == duckId) {
                return duck;
            }
        }
        return null;
    }

    // this function is used to update(change) behaviors of duck
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/api/duck/{duckId}")
    public void updateDuck(@PathVariable("duckId") int duckId, @RequestBody DuckRequestDTO duckRequest) {

        for (Duck duck : ducks) {
            if (duck.getDucks() != null && duck.getDucks().size() > 0) {
                for (Duck duckChild : duck.getDucks()) {
                    if (duckChild.getId() == duckId) {
                        duckChild.setFly(duckRequest.getFly());
                        duckChild.setQuack(duckRequest.getQuack());
                        if (duckChild.getShapeLevel() != duckRequest.getShapeLevel()) {
                            undoDuckList.add(duckChild.getId());
                            redoDuckList = new ArrayList<>();
                        }
                        duckChild.setShapeLevel(duckRequest.getShapeLevel());
                    }
                }
            } else if (duck.getId() == duckId) {
                duck.setFly(duckRequest.getFly());
                duck.setQuack(duckRequest.getQuack());
                if (duck.getShapeLevel() != duckRequest.getShapeLevel()) {
                    undoDuckList.add(duck.getId());
                    redoDuckList = new ArrayList<>();
                }
                duck.setShapeLevel(duckRequest.getShapeLevel());
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
        duck.setId(this.duckId++);
        Duck new_duck = new MallardDuck();
        new_duck.setId(this.duckId++);
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
        switch (duck.getName()) {
            case "MallardDuck":
                new_duck = new MallardDuck();
                break;
            case "RedheadDuck":
                new_duck = new RedheadDuck();
                break;
            case "RubberDuck":
                new_duck = new RubberDuck();
                break;
            default:
                new_duck = new Duck() {
                    @Override
                    public String display() {
                        return "New Duck";
                    }
                };
                break;
        }

        new_duck.setId(this.duckId++);
        new_duck.setName(new_duck.display());
        new_duck.setFly(new_duck.performFly());
        new_duck.setQuack(new_duck.performQuack());
        new_duck.setSwim(new_duck.swim());

        for (Duck duckItem : ducks) {
            if (duckItem.getId() == duckId) {

                duckItem.getDucks().add(new_duck);
            }
        }
    }


    // this function returns the list of duck names
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/duck/all-names")
    public String[] default_ducks() {
        String ducks[] = new String[3];
        try {
            File myObj = new File("/home/rana/IdeaProjects/Duck-App/src/assets/images/list.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return ducks;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/duck/actions")
    public RecentAction getDuckActions() {
        RecentAction recentAction = new RecentAction();
        recentAction.setCanUndo(undoDuckList != null && undoDuckList.size() > 0);
        recentAction.setCanRedo(redoDuckList != null && redoDuckList.size() > 0);
        return recentAction;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/api/duck/actions/{action}")
    public List<Duck> implementAction(@PathVariable("action") String actionType) {
        if (actionType.equals("undo")) {
            int undoDuckId = undoDuckList.get(undoDuckList.size() - 1);

            for (Duck duck : ducks) {
                if (duck.getDucks() != null && duck.getDucks().size() > 0) {
                    for (Duck duckChild : duck.getDucks()) {
                        if (duckChild.getId() == undoDuckId) {
                            duckChild.setShapeLevel(duckChild.getShapeLevel() - 1);
                            redoDuckList.add(duckChild.getId());
                            undoDuckList.remove(undoDuckList.size() - 1);
                        }
                    }
                } else if (duck.getId() == undoDuckId) {
                    duck.setShapeLevel(duck.getShapeLevel() - 1);
                    redoDuckList.add(duck.getId());
                    undoDuckList.remove(undoDuckList.size() - 1);
                }
            }
        } else if (actionType.equals("redo")) {
            int redoDuckId = redoDuckList.get(redoDuckList.size() - 1);

            for (Duck duck : ducks) {
                if (duck.getDucks() != null && duck.getDucks().size() > 0) {
                    for (Duck duckChild : duck.getDucks()) {
                        if (duckChild.getId() == redoDuckId) {
                            duckChild.setShapeLevel(duckChild.getShapeLevel() + 1);
                            undoDuckList.add(duckChild.getId());
                            redoDuckList.remove(redoDuckList.size()- 1);
                        }
                    }
                } else if (duck.getId() == redoDuckId) {
                    duck.setShapeLevel(duck.getShapeLevel() + 1);
                    undoDuckList.add(duck.getId());
                    redoDuckList.remove(redoDuckList.size()- 1);
                }
            }
        }
        return getDucks();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/duck/new/list")
    public void clearDuckList() {
       ducks = new ArrayList<>();
    }
}
