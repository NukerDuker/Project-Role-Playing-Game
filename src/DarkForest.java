import java.util.Random;

public class DarkForest implements Runnable {

    Hero hero;
    Creature enemy;
    Game game;
    Random rand = new Random();
    Thread levelUpListener;
    boolean endFight = false;

    DarkForest(Hero hero, Game game) {
        this.game = game;
        this.hero = hero;
        levelUpListener = new Thread(new LevelUpListener(hero));
        levelUpListener.start();
    }
//В методе реализованы создание монстров и сражения
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            createMonster();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//Метод создания монстров. Можно добавить значение уровня героя к генератору статов монстров, чтобы они тоже росли с уровнем героя
    private void createMonster() {
        //Получаем рандомное число, на основе его значения определяем тип монстра
        int randomizeEnemy = getRandInt(3, 1);
        System.out.println("Появляется монстр!");
        try {
            if (randomizeEnemy <= 1) {
                enemy = Skeleton.Builder.newInstance().setName("Skeleton").setHealth(80).setAgility(5).setStrength(5).build();
            }
            if (randomizeEnemy >= 2) {
                enemy = Goblin.Builder.newInstance().setName("Goblin").setHealth(100).setAgility(4).setStrength(6).build();
            }
            System.out.println(fight());
        } catch (NullPointerException e) {
            System.out.println("EXCEPTION (RandomiseEnemy): " + randomizeEnemy);
        }
    }
//Метод для генерации рандомных чисел в заданном диапазоне
    private int getRandInt(int max, int min) {
        int result = rand.nextInt(((max - min) + 1) + min);
        return result;
    }
//Метод битвы между героем и созданным монстром
    private String fight() {
        int randomResist;
        String result = "";

        //Начинается бой
        String battleBegins = """
                Начало боя
                ---------------""";
        System.out.println(battleBegins);

        while (!endFight) {
            //Проводим поочередную атаку, до тех пор, пока чье-то здоровье не опустится до <= 0
            randomResist = getRandInt(101, 0);
            hero.attack(enemy, randomResist);

            randomResist = getRandInt(101, 0);
            enemy.attack(hero, randomResist);

            //После каждого хода проверяем состояние здоровья
            if (hero.getHealth() > 0 && enemy.getHealth() <= 0) {
                int randomGold = getRandInt(10, 0);
                int receivedGold = randomGold + (enemy.getLevel());
                int receivedExp = ((enemy.getLevel() * 10) + 100);
                //Если герой победил, он получает золото и опыт
                hero.addGold(receivedGold);
                hero.addExperience(receivedExp);

                result = """
                ---------------
                Победа!""";
                result += "Gold: " + receivedGold + " , and exp: " + receivedExp + "\n";
                result += "Подожди, закапываем монстра, считаем золото...";
                endFight = true;

            } else if (enemy.getHealth() > 0 && hero.getHealth() <= 0) {
                result = """
                ---------------
                Поражение!""";
                result += "Герой мертв, нажмите любую кнопку для выхода.";
                game.setExit();
                hero.setDead();
                endFight = true;
            }
        }

        return result;
    }
}
