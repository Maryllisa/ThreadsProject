package constant;

import java.util.HashMap;

public class ConstCol {
    public HashMap<String, Integer> animalCol;
    ConstAnimal constAnimal = new ConstAnimal();
    public ConstCol()
    {
        animalCol = new HashMap<>();
        animalCol.put(constAnimal.wolf, 30);
        animalCol.put(constAnimal.boa, 30);
        animalCol.put(constAnimal.fox,30);
        animalCol.put(constAnimal.bear, 5);
        animalCol.put(constAnimal.eagle,20);
        animalCol.put(constAnimal.horse, 20);
        animalCol.put(constAnimal.deer, 20);
        animalCol.put(constAnimal.rabbit, 150);
        animalCol.put(constAnimal.boar, 140);
        animalCol.put(constAnimal.buffalo, 50);
        animalCol.put(constAnimal.duck,200);
        animalCol.put(constAnimal.caterpillar,1000);
        animalCol.put(constAnimal.plants,200);
        animalCol.put(constAnimal.goat, 140);
        animalCol.put(constAnimal.sheep, 140);
        animalCol.put(constAnimal.mouse, 500);


    }
}
