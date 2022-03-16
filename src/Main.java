public class Main {
    private static volatile Hero hero;

    public static void main(String[] args) {
        hero = Hero.Builder.newInstance()
                .setName("Aron")
                .setHealth(100)
                .setAgility(10)
                .setStrength(10)
                .build();
        System.out.println(hero.toString());
    }
}
