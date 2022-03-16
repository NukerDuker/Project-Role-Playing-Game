import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
//Неправильно поднимается уровень: всегда после 110 опыта, каждый бой.
public class Game {

    private static volatile Hero hero;
    private static volatile Skeleton skeleton;
    private static volatile Goblin goblin;
    private final String MENU =
            """
                    1. К торговцу
                    2. В Темный Лес
                    3. На выход
                    """;
    private boolean exit = false;

    public static void main(String[] args) {
        hero = Hero.Builder.newInstance().setName("Aron").setHealth(100).setAgility(10).setStrength(10).build();
        System.out.println(hero.toString());
        new Game().getMenu();
    }

    public void setExit() {
        exit = true;
    }
    public void getMenu() {
        System.out.println(MENU);
        Scanner scan = new Scanner(System.in);
        int result = scan.nextInt();
        switch (result) {
            case 1:
                System.out.println("Not ready");
                break;
            case 2: Thread battle = new Thread(new Battle(hero, this));
                    battle.start();
                    break;
            case 3: setExit();
        }
        if (!exit) {
            getMenu();
        }
    }
}
