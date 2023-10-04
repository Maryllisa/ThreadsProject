package model.modelTemplate;

import constant.ConstAnimal;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal {
    @Override
    public String eat(double []probability, List<String> whoIs) {
        ConstAnimal constAnimal = new ConstAnimal();
        Random random = new Random();
        for (int i = 0; i <whoIs.size(); i++) {
            boolean eat;
            if (constAnimal.wolf.equals(whoIs.get(i))) {
                eat = random.nextDouble() < probability[0];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.boa.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[1];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.fox.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[2];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.bear.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[3];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.eagle.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[4];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.horse.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[5];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.deer.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[6];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.rabbit.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[7];
                if (eat) return whoIs.get(i);
            }  else if (constAnimal.mouse.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[8];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.goat.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[9];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.sheep.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[10];
                if (eat) return whoIs.get(i);
            }  else if (constAnimal.boar.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[11];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.buffalo.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[12];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.duck.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[13];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.caterpillar.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[14];
                if (eat) return whoIs.get(i);
            }
            else if (constAnimal.plants.equals(whoIs.get(i))){
                eat = random.nextDouble() < probability[15];
                if (eat) return whoIs.get(i);
            }

        }
        return null;
    }

    @Override
    public void directionOfMovement() {}
    @Override
    public boolean multiply(String name, String nameTwo) {
        if (name.equals(nameTwo)){
            return ThreadLocalRandom.current().nextBoolean();
        }
        else return false;
    }
}
