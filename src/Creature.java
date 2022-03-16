public abstract class Creature {

    private final String name;
    private int health;
    private int strength;
    private int agility;
    private int level;

    public Creature(String name, int health, int strength, int agility, int level) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getLevel() {
        return level;
    }

    public Creature setHealth(int health) {
        this.health = health;
        return this;
    }

    public StringBuilder attack(Creature enemy, int randomResist) {
        StringBuilder result = new StringBuilder();
        boolean hit = this.getAgility() * 3 >= randomResist;

        if (hit) {
            result.append("Hit! ");
            boolean criticalHit = this.getAgility() * 3 <= randomResist + 5;
            int damage = this.getStrength();

            if (criticalHit) {
                result.delete(0, 3);
                result.append("Critical hit! ");
                damage = this.getStrength() * 2;
            }

            result.append("Damage: " + damage);
            enemy.setHealth(enemy.getHealth() - damage);

        } else {
            result.append("Miss! Damage is 0");
        }
        return result;
    }



}
