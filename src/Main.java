public class Main {
    private static volatile Hero hero;
    private static volatile Skeleton skeleton;
    private static volatile Goblin goblin;

    public static void main(String[] args) {
        hero = Hero.Builder.newInstance().setName("Aron").setHealth(100).setAgility(10).setStrength(10).build();
        System.out.println(hero.toString());

        skeleton = Skeleton.Builder.newInstance().setName("Skeleton").setHealth(80).setAgility(8).setStrength(8).build();
        System.out.println(skeleton.toString());

        goblin = Goblin.Builder.newInstance().setName("Goblin").setHealth(100).setAgility(8).setStrength(8).build();
        System.out.println(goblin.toString());

    }
}
