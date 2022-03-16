public class Game {
    private static volatile Hero hero;
    private static volatile Skeleton skeleton;
    private static volatile Goblin goblin;

    public static void main(String[] args) {
        hero = Hero.Builder.newInstance().setName("Aron").setHealth(100).setAgility(10).setStrength(10).build();
        System.out.println(hero.toString());

        Thread battle = new Thread(new Battle(hero, goblin));
        battle.start();

    }
}
