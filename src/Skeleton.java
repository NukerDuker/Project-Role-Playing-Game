public class Skeleton extends Creature{

    private int health;
    private int strength;
    private int agility;
    private int level;


    Skeleton() {

    }

    public static class Builder {
        private int health;
        private int strength;
        private int agility;
        private int level;
    }
    @Override
    String attack(Creature enemy, int randomResist) {
        return null;
    }
}
