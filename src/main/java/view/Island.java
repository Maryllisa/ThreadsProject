package view;

import constant.ConstAnimal;
import constant.ConstCol;
import model.Plants;
import model.herbivorous.*;
import model.modelTemplate.Printer;
import model.predators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Island {

    List<Printer>[][] island;
    private final int sizeX;
    private final int sizeY;

    public Island(int sizeX, int sizeY) {

        island = new ArrayList[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                this.island[i][j] = new ArrayList<>();
            }

        }
    }
    public boolean checkCol(String name, List<Printer> nameWhoIs){
        ConstCol constCol = new ConstCol();
        int col =0;
        for (int i = 0; i < nameWhoIs.size(); i++) {
            if (name.equals(nameWhoIs.get(i).getName()))
                col++;
        }
        return col < constCol.animalCol.get(name);

    }
    public void setIsland(List<Future<Printer>> infoAboutAnimal) throws ExecutionException, InterruptedException {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                for (int k = 0; k < infoAboutAnimal.size(); k++) {
                    if (i == infoAboutAnimal.get(k).get().getX() && j == infoAboutAnimal.get(k).get().getY()) {
                        if (checkCol(infoAboutAnimal.get(k).get().getName(),island[i][j]))
                            island[i][j].add(infoAboutAnimal.get(k).get());
                        else System.out.println("Животное " + infoAboutAnimal.get(k).get().getName() + " не поместилось на локацию и было ликвидировано...");
                    }
                }
            }
        }
    }


    public void getIsland() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                System.out.print("Локация [" + i + "][" + j + "]:");
                int flag = 0;
                for (int k = 0; k < island[i][j].size(); k++) {
                    System.out.print("  " + island[i][j].get(k).getName());
                    flag++;

                }
                if (flag == 0) {
                    System.out.print("  пусто ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public List<Future<Printer>> getStart(int[] colLifeLocation, ExecutorService herbivorous, ExecutorService predators) {
        List<Future<Printer>> listThreadAnimalFirst = new ArrayList<>();
        for (int i = 0; i < colLifeLocation[0]; i++) {
            int x = ThreadLocalRandom.current().nextInt(0, sizeX);
            int y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Bear bear = new Bear(500, 2, 80, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Boa boa = new Boa(15, 1, 3, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Eagle eagle = new Eagle(6, 3, 1, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Fox fox = new Fox(8, 2, 2, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Wolf wolf = new Wolf(50, 3, 8, x, y, this.sizeX, this.sizeY);
            listThreadAnimalFirst.add(herbivorous.submit(bear));
            listThreadAnimalFirst.add(herbivorous.submit(boa));
            listThreadAnimalFirst.add(herbivorous.submit(eagle));
            listThreadAnimalFirst.add(herbivorous.submit(fox));
            listThreadAnimalFirst.add(herbivorous.submit(wolf));
        }
        for (int i = 0; i < colLifeLocation[1]; i++) {
            int x = ThreadLocalRandom.current().nextInt(0, sizeX);
            int y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Boar boar = new Boar(70, 3, 10, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Buffalo buffalo = new Buffalo(400, 2, 50, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Caterpillar caterpillar = new Caterpillar(0.01, 0, 0, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Deer deer = new Deer(300, 4, 50, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Duck duck = new Duck(1, 4, 0.15, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Horse horse = new Horse(400, 4, 60, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Mouse mouse = new Mouse(0.05, 1, 0.01, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Rabbit rabbit = new Rabbit(2, 2, 0.45, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Goat goat = new Goat(2, 2, 0.45, x, y, this.sizeX, this.sizeY);
            x = ThreadLocalRandom.current().nextInt(0, sizeX);
            y = ThreadLocalRandom.current().nextInt(0, sizeY);
            Sheep sheep = new Sheep(2, 2, 0.45, x, y, this.sizeX, this.sizeY);
            listThreadAnimalFirst.add(predators.submit(boar));
            listThreadAnimalFirst.add(predators.submit(buffalo));
            listThreadAnimalFirst.add(predators.submit(caterpillar));
            listThreadAnimalFirst.add(predators.submit(deer));
            listThreadAnimalFirst.add(predators.submit(duck));
            listThreadAnimalFirst.add(predators.submit(horse));
            listThreadAnimalFirst.add(predators.submit(mouse));
            listThreadAnimalFirst.add(predators.submit(rabbit));
            listThreadAnimalFirst.add(predators.submit(goat));
            listThreadAnimalFirst.add(predators.submit(sheep));

        }

        return listThreadAnimalFirst;
    }

    public List<Future<Printer>> deleteWhoFood(List<Future<Printer>> infoAboutAnimal) throws ExecutionException, InterruptedException {
        List<Integer> listIndex = new ArrayList<>();
        for (int i = 0; i < infoAboutAnimal.size(); i++) {
            if (infoAboutAnimal.get(i).get().getHP() == 0)
                listIndex.add(i);
        }
        for (int j = 0; j < listIndex.size(); j++) {
            infoAboutAnimal.remove(infoAboutAnimal.remove(listIndex.get(j)));
        }
        List<Integer> mas = new ArrayList<>();
        for (int i = 0; i < infoAboutAnimal.size(); i++) {
            if (infoAboutAnimal.get(i).get().getWhoFood() != null && infoAboutAnimal.get(i).get().getWhoFood() != "")
                mas.add(i);
        }
        for (int j = 0; j < mas.size(); j++) {
            infoAboutAnimal.remove(infoAboutAnimal.remove(mas.get(j)));
        }
        return infoAboutAnimal;
    }

    //Должно быть создано минимум
    // 10 видов травоядных
    // 5 видов хищников
    public int[] randomLife(int size) {
        int colPredators = ThreadLocalRandom.current().nextInt(10, size > 10 ? size : size + 10);
        int colHerbivorous = ThreadLocalRandom.current().nextInt(5, size > 5 ? size : size + 5);
        int colForOnePredators = colPredators / 8;
        int colForOneHerbivorous = colHerbivorous / 5;
        return new int[]{colForOneHerbivorous, colForOnePredators};
    }

    public void getIsland(Scanner in) throws ExecutionException, InterruptedException {

        System.out.println("Все почти готово, осталось только определить жителей нашей локации!\n" + "По стандарту это будет: ");
        ConstCol constCol = new ConstCol();
        int[] colLifeLocation = randomLife(island.length * island[0].length);
        ConstAnimal constAnimal = new ConstAnimal();
        System.out.println("Хищников на острове: " + colLifeLocation[0] * 5 + "\n" + "Травоядных на острове: " + colLifeLocation[1] * 8 + "\n" + "Трава будет генирироваться каждую секунду");
        System.out.println("Генирация остановиться, когда все животные на острове вымрут. Чтобы остановить досрочно введите stop");
        ExecutorService herbivorous = Executors.newScheduledThreadPool(colLifeLocation[0] * 5);
        ExecutorService predators = Executors.newScheduledThreadPool(colLifeLocation[1] * 8);
        ExecutorService plants = Executors.newScheduledThreadPool(1);
        String stop = " ";
        int flag = 0;

        List<Future<Printer>> listThreadAnimal = new ArrayList<>();
        while (!stop.equals("stop")) {

            if (flag == 0) {

                listThreadAnimal = getStart(colLifeLocation, herbivorous, predators);
                flag++;
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(0,5); l++)
                {
                            int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                            int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                            Plants plant = new Plants(x, y, this.sizeX, this.sizeY);
                            listThreadAnimal.add(plants.submit(plant));
                }
            } else {
                listThreadAnimal.clear();
                for (int i = 0; i < island.length; i++) {
                    for (int j = 0; j < island[i].length; j++) {
                        for (int k = 0; k < island[i][j].size(); k++) {
                            if (constAnimal.bear.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.bear.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Bear bear = new Bear(500, 2, 80, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(herbivorous.submit(bear));
                                    }

                                }
                                Bear bear = new Bear(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(herbivorous.submit(bear));
                            } else if (constAnimal.boa.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.boa.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Boa boa = new Boa(15, 1, 3, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(herbivorous.submit(boa));
                                    }

                                }
                                Boa boa = new Boa(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(herbivorous.submit(boa));
                            } else if (constAnimal.eagle.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.eagle.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Eagle eagle = new Eagle(6, 3, 1, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(herbivorous.submit(eagle));
                                    }

                                }
                                Eagle eagle = new Eagle(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(herbivorous.submit(eagle));
                            } else if (constAnimal.fox.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.fox.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Fox fox = new Fox(8, 2, 2, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(herbivorous.submit(fox));
                                    }

                                }
                                Fox fox = new Fox(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(herbivorous.submit(fox));
                            } else if (constAnimal.wolf.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.wolf.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Wolf wolf = new Wolf(50, 3, 8, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(herbivorous.submit(wolf));
                                    }

                                }
                                Wolf wolf = new Wolf(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(herbivorous.submit(wolf));
                            } else if (constAnimal.boar.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.boar.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Boar boar = new Boar(70, 3, 10, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(boar));
                                    }

                                }
                                Boar boar = new Boar(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(boar));
                            } else if (constAnimal.buffalo.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.buffalo.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Buffalo buffalo = new Buffalo(400, 2, 50, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(buffalo));
                                    }

                                }
                                Buffalo buffalo = new Buffalo(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(buffalo));
                            } else if (constAnimal.caterpillar.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.caterpillar.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Caterpillar caterpillar = new Caterpillar(0.01, 0, 0, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(caterpillar));
                                    }

                                }
                                Caterpillar caterpillar = new Caterpillar(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(caterpillar));
                            } else if (constAnimal.deer.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.deer.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Deer deer = new Deer(300, 4, 50, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(deer));
                                    }

                                }
                                Deer deer = new Deer(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(deer));
                            } else if (constAnimal.duck.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.duck.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Duck duck = new Duck(1, 4, 0.15, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(duck));
                                    }

                                }
                                Duck duck = new Duck(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(duck));
                            } else if (constAnimal.goat.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.goat.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Goat goat = new Goat(2, 2, 0.45, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(goat));
                                    }

                                }
                                Goat goat = new Goat(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(goat));
                            } else if (constAnimal.horse.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.horse.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Horse horse = new Horse(400, 4, 60, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(horse));
                                    }

                                }
                                Horse horse = new Horse(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(horse));
                            } else if (constAnimal.mouse.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.mouse.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Mouse mouse = new Mouse(0.05, 1, 0.01, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(mouse));
                                    }

                                }
                                Mouse mouse = new Mouse(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(mouse));
                            } else if (constAnimal.rabbit.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.rabbit.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Rabbit rabbit = new Rabbit(2, 2, 0.45, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(rabbit));
                                    }

                                }
                                Rabbit rabbit = new Rabbit(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(rabbit));
                            } else if (constAnimal.sheep.equals(island[i][j].get(k).getName())) {
                                List<String> listWhoIs = new ArrayList<>();
                                for (int l = 0; l < island[i][j].size(); l++) {
                                    listWhoIs.add(island[i][j].get(l).getName());
                                }
                                if (constAnimal.sheep.equals(island[i][j].get(k).isReproduction())) {
                                    int x = ThreadLocalRandom.current().nextInt(0, sizeX);
                                    int y = ThreadLocalRandom.current().nextInt(0, sizeY);
                                    int col = ThreadLocalRandom.current().nextInt(0, 4);
                                    for (int l = 0; l < col; l++) {
                                        Sheep sheep = new Sheep(2, 2, 0.45, x, y, this.sizeX, this.sizeY);
                                        listThreadAnimal.add(predators.submit(sheep));
                                    }

                                }
                                Sheep sheep = new Sheep(island[i][j].get(k), listWhoIs, this.sizeX, this.sizeY);
                                listThreadAnimal.add(predators.submit(sheep));
                            }
                            else if (constAnimal.plants.equals(island[i][j].get(k).getName())) {
                                Plants plant = new Plants(island[i][j].get(k).getX(), island[i][j].get(k).getX(), this.sizeX, this.sizeY);
                                listThreadAnimal.add(plants.submit(plant));
                            }
                        }
                    }
                }

            }
            for (int i = 0; i < island.length; i++) {
                for (int j = 0; j < island[i].length; j++) {
                    island[i][j].clear();
                }
            }
            listThreadAnimal = deleteWhoFood(listThreadAnimal);
            setIsland(listThreadAnimal);
            getIsland();

            System.out.println("Продолжить?");
            stop = in.nextLine();
        }
    }

}
