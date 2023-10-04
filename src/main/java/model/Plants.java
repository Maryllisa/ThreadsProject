package model;

import model.modelTemplate.Printer;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Plants implements Callable<Printer> {
    private String plant = "\u1F33F";
    private int x;
    private int y;
    private int sizeX;
    private int sizeY;
    private int speed=1;
    public Plants(int x, int x1, int sizeX, int sizeY) {
        this.x=x;
        this.y=y;
        this.sizeX = sizeX;
        this.sizeY =sizeY;
    }

    public String getName(){
        return "plants";
    }

    @Override
    public Printer call() throws Exception {
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
        return new Printer(getName(), this.x, this.y);
    }
}
