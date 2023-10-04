package model.herbivorous;

import model.modelTemplate.Herbivorous;
import model.modelTemplate.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

//волк
public class Wolf extends Herbivorous implements Callable<Printer> {
    private int HP;
    private int x;
    private int y;
    //-	0	0	0	0	10	15	60	80	60	70	15	10	40	0	0
    private final double[] probability = new double[]{0,0,0,0,0,0.10,0.15,0.60,0.80,0.60,0.70,0.15,0.10,0.40,0,0};
    private int speed;

    private double wight;
    private double foodMuch;
    private List<String> whoIs;
    private int sizeX;
    private int sizeY;

    public Wolf(Printer printer,List<String> whoIs, int sizeX, int sizeY) {
        this.HP = printer.getHP();
        this.x = printer.getX();
        this.y = printer.getY();
        this.speed = printer.getSpeed();
        this.foodMuch = printer.getFoodMuch();
        this.wight = printer.getWight();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.whoIs = whoIs;

    }

    public Wolf(float wight, int speed, float foodMuch, int x, int y, int sizeX, int sizeY){
        this.wight = wight;
        this.speed =speed;
        this.foodMuch =foodMuch;
        this.x=x;
        this.y = y;
        this.HP=100;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.whoIs = new ArrayList<>();
    }
    public String getName(){
        return "wolf";
    }

    @Override
    public void directionOfMovement() {
        int side = ThreadLocalRandom.current().nextInt(0,3);
        if(side==0){
            if ((this.y+this.speed)<this.sizeY) this.y+=this.speed;
        }
        else if(side==1){
            if ((this.y-this.speed)<this.sizeY && (this.y-this.speed)>0) this.y-=this.speed;
        }
        else if(side==2){
            if ((this.x+this.speed)<this.sizeX) this.x+=this.speed;
        }
        else {
            if ((this.x-this.speed)<this.sizeX && (this.x-this.speed)>0) this.x-=this.speed;
        }
    }

    @Override
    public boolean multiply(String name, String nameTwo) {
        return super.multiply(name, nameTwo);
    }
    @Override
    public Printer call() throws Exception {
        boolean reprodaction = false;
        String whoFood = null;
        if (whoIs.size()!=0){
            boolean choose = ThreadLocalRandom.current().nextBoolean();
            for (int i = 0; i < whoIs.size(); i++) {
                if(multiply(getName(), whoIs.get(i))) reprodaction =true;
            }
            whoFood = eat(this.probability, whoIs);
            if(whoFood==null) this.HP-=25;
        }
        directionOfMovement();
        return new Printer(getName(),
                this.HP,
                this.x,
                this.y,
                this.foodMuch,
                this.speed,
                this.wight,
                reprodaction,
                whoFood);
    }
}
