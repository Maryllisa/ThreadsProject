import view.Island;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать в генератор жизни на остраве");
        System.out.println("Введите размер острова (это должны быть два целых числа) ");
        Island island = new Island(in.nextInt(), in.nextInt());
        try {
            island.getIsland(in);

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}