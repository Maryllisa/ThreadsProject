package model.modelTemplate;

import constant.ConstCol;
import model.herbivorous.*;
import model.predators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class Printer {
    private String name;

    private int HP;
    private int x;
    private int y;
    private double foodMuch;

    private int speed;
    private double wight;

    public Printer(String name,
                   int HP,
                   int x,
                   int y,
                   double foodMuch,
                   int speed,
                   double wight,
                   boolean reproduction,
                   String whoFood) {
        this.name = name;
        this.HP = HP;
        this.x = x;
        this.y = y;
        this.foodMuch = foodMuch;
        this.speed = speed;
        this.wight = wight;
        this.reproduction = reproduction;
        this.whoFood = whoFood;
    }

    public Printer(String name, int x, int y) {
        this.name = name;
        this.HP = 1;
        this.x = x;
        this.y = y;
        this.foodMuch = 1;
        this.speed = 1;
        this.wight = 1;
        this.reproduction = false;
        this.whoFood = null;

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private boolean reproduction;
    private String whoFood;

    public void setWight(double wight) {
        this.wight = wight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getFoodMuch() {
        return foodMuch;
    }

    public void setFoodMuch(double foodMuch) {
        this.foodMuch = foodMuch;
    }

    public boolean isReproduction() {
        return reproduction;
    }

    public void setReproduction(boolean reproduction) {
        this.reproduction = reproduction;
    }

    public String getWhoFood() {
        return whoFood;
    }

    public void setWhoFood(String whoFood) {
        this.whoFood = whoFood;
    }

    public double getWight() {
        return wight;
    }
}