import java.util.Random;
import java.util.Scanner;

public class Battle implements Runnable{

    Hero hero;
    Creature enemy;
    Game game;
    Random rand = new Random();
    Thread levelUpListener;
    boolean endFight = false;

    Battle(Hero hero, Game game){
        this.game = game;
        this.hero = hero;
        levelUpListener = new Thread(new LevelUpListener(hero));
        levelUpListener.start();
    }

    @Override
    public void run() {
        int randomizeEnemy = getRandInt(3, 1);
        try{
            if (randomizeEnemy <= 1) {
                enemy = Skeleton.Builder.newInstance().setName("Skeleton").setHealth(80).setAgility(8).setStrength(8).build();
            } if (randomizeEnemy >= 2) {
                enemy = Goblin.Builder.newInstance().setName("Goblin").setHealth(100).setAgility(7).setStrength(9).build();
            }
            System.out.println(fight());
        } catch (NullPointerException e) {
            System.out.println("EXCEPTION: " + randomizeEnemy);
        }
    }

    private int getRandInt(int max, int min) {
        int result = rand.nextInt(((max - min) + 1) + min);
        return result;
    }

    private String fight() {
        int randomResist;
        //Начинается бой
        while (!endFight) {
            randomResist = getRandInt(101, 0);
            hero.attack(enemy, randomResist);
            if (enemy.getHealth() <= 0) {
                endFight = true;
                break;
            }

            randomResist = getRandInt(101, 0);
            enemy.attack(hero, randomResist);
            if (hero.getHealth() <= 0) {
                endFight = true;
                break;
            }
        }
        String result = hero.getHealth() > 0 ? "Hero " + hero.getName() + " wins!" : "Monster wins," + hero.getName() + " dies!";

        if (hero.getHealth() > 0 && enemy.getHealth() <= 0) {

            int randomGold = getRandInt(10, 0);
            int receivedGold = randomGold + (enemy.getLevel());
            int receivedExp = ((enemy.getLevel() * 10) + 100);

            hero.addGold(receivedGold);
            hero.addExperience(receivedExp);
            hero.fullHealth();
            System.out.println("Drop: " + receivedGold + " , and exp: " + receivedExp);

        } else if(enemy.getHealth() > 0 && hero.getHealth() <= 0) {
            System.out.println("Game over, " + hero.getName() + " is dead!");
            game.setExit();
        }
        return result;
    }
}
